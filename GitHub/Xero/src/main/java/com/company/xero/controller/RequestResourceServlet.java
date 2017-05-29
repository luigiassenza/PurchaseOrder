package com.company.xero.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.xero.api.XeroClient;
import com.company.xero.model.DataToDisplay;
import com.company.xero.model.TokenStorage;
import com.xero.api.Config;
import com.xero.api.JsonConfig;
import com.xero.api.OAuthAccessToken;
import com.xero.api.XeroApiException;
import com.xero.model.*;

public class RequestResourceServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private Config config = JsonConfig.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		

		String startingDateString = request.getParameter("startingDate");  		
		String endingDateString = request.getParameter("endingDate");  		
		String amountGreaterString = request.getParameter("amountGreater");  		
		String currencyString = request.getParameter("currency");  		

		String object = request.getParameter("object");
		ArrayList<String> messages = new ArrayList<String>();
		
		// Get Xero API Resource - DEMONSTRATION ONLY get token from Cookie
		TokenStorage storage = new TokenStorage();
		String token = storage.get(request,"token");
		String tokenSecret = storage.get(request,"tokenSecret");
		
		if(storage.tokenIsNull(token)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		OAuthAccessToken refreshToken = new OAuthAccessToken(config);
		String tokenTimestamp = storage.get(request, "tokenTimestamp");
		if(config.getAppType().equals("PARTNER") && refreshToken.isStale(tokenTimestamp)) {
			System.out.println("Time for a refresh");

			refreshToken.setToken(storage.get(request, "token"));
			refreshToken.setTokenSecret(storage.get(request, "tokenSecret"));
			refreshToken.setSessionHandle(storage.get(request, "sessionHandle"));
			
			boolean success = refreshToken.build().execute();
			if (!success) {
				try {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// DEMONSTRATION ONLY - Store in Cookie - you can extend TokenStorage
			// and implement the save() method for your database
			storage.save(response,refreshToken.getAll());
			token =  refreshToken.getToken();
			tokenSecret = refreshToken.getTokenSecret();
		}
		
		XeroClient client = new XeroClient();
		client.setOAuthToken(token, tokenSecret);
		
		//SampleData data = new SampleData(client);
		
		/*
		 * ******************************************
		 */
		
		if(object.equals("Invoices")) {
			try {
				
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				Date startingDate = fmt.parse(startingDateString);	
				Date endingDate = fmt.parse(endingDateString);
				Double amountGreater = Double.parseDouble(amountGreaterString);
					
				List<Invoice> getInv = client.getInvoices();
				
				ArrayList<DataToDisplay> dataToDisplay = new ArrayList<DataToDisplay>();
				ArrayList<DataToDisplay> revenueToDisplay = new ArrayList<DataToDisplay>();
				ArrayList<DataToDisplay> expenseToDisplay = new ArrayList<DataToDisplay>();

				for(int i=0; i<getInv.size(); i++) {
					InvoiceType type = getInv.get(i).getType();
					
					CurrencyCode currency = getInv.get(i).getCurrencyCode();
					
					BigDecimal amt = new BigDecimal(amountGreater);
					BigDecimal amtInv = getInv.get(i).getAmountPaid();
					
					if(type == InvoiceType.ACCREC && currencyString.equals(currency.toString()) && amt.compareTo(amtInv) < 0 && startingDate.before(getInv.get(i).getDate().getTime()) && endingDate.after(getInv.get(i).getDate().getTime())) {
						DataToDisplay data = new DataToDisplay();
						String contactName = getInv.get(i).getContact().getName();
						BigDecimal amountPaid = getInv.get(i).getAmountPaid();
						data.setContactName(contactName);
						data.setAmountPaid(amountPaid);
						revenueToDisplay.add(data);	
					}
					
					if(type == InvoiceType.ACCPAY && currencyString.equals(currency.toString()) && amt.compareTo(amtInv) < 0 && startingDate.before(getInv.get(i).getDate().getTime()) && endingDate.after(getInv.get(i).getDate().getTime())) {
						DataToDisplay data = new DataToDisplay();
						String contactName = getInv.get(i).getContact().getName();
						BigDecimal amountPaid = getInv.get(i).getAmountPaid();
						data.setContactName(contactName);
						data.setAmountPaid(amountPaid);
						expenseToDisplay.add(data);	
					}
				}

				Collections.sort(dataToDisplay, Comparator.comparing(DataToDisplay::getAmountPaid).reversed());
				request.setAttribute("dataToDispaly", dataToDisplay);
				
				
				BigDecimal maxValueRev = new BigDecimal(0);
				BigDecimal minValueRev = new BigDecimal(0);
				if(revenueToDisplay.size() == 0) {
					maxValueRev = new BigDecimal(0); //new
					minValueRev = new BigDecimal(0);
				} else {
					Collections.sort(revenueToDisplay, Comparator.comparing(DataToDisplay::getAmountPaid).reversed());
					maxValueRev = revenueToDisplay.get(0).getAmountPaid(); //new
					minValueRev = revenueToDisplay.get(revenueToDisplay.size()-1).getAmountPaid(); //new

				}
				
				BigDecimal maxValueExp = new BigDecimal(0);
				BigDecimal minValueExp = new BigDecimal(0);
				if(expenseToDisplay.size() == 0) {
					maxValueExp = new BigDecimal(0);
					minValueExp = new BigDecimal(0);
				} else {
					Collections.sort(expenseToDisplay, Comparator.comparing(DataToDisplay::getAmountPaid).reversed());
					maxValueExp = expenseToDisplay.get(0).getAmountPaid();
					minValueExp = expenseToDisplay.get(expenseToDisplay.size()-1).getAmountPaid();
				}
				
				
				
				BigDecimal maxValueChart = maxValueRev.max(maxValueExp);
				
				BigDecimal sumRev = new BigDecimal(0);
				for(int i=0; i<revenueToDisplay.size(); i++) {
					sumRev = sumRev.add(revenueToDisplay.get(i).getAmountPaid());
				}
				
				BigDecimal sumExp = new BigDecimal(0);
				for(int i=0; i<expenseToDisplay.size(); i++) {
					sumExp = sumExp.add(expenseToDisplay.get(i).getAmountPaid());
				}
				
				BigDecimal netResult = sumRev.subtract(sumExp);
				
				request.setAttribute("expenseToDispaly", expenseToDisplay);
				request.setAttribute("revenueToDispaly", revenueToDisplay);
				request.setAttribute("maxValueRev", maxValueRev); //new
				request.setAttribute("minValueRev", minValueRev); //new
				request.setAttribute("maxValueExp", maxValueExp);
				request.setAttribute("minValueExp", minValueExp);
				request.setAttribute("maxValueChart", maxValueChart);
				request.setAttribute("sumRev", sumRev);
				request.setAttribute("sumExp", sumExp);
				request.setAttribute("netResult", netResult);
				request.setAttribute("startingDateDisplay", startingDateString);
				request.setAttribute("endingDateDisplay", endingDateString);
				request.setAttribute("amountGreater", amountGreater);
				request.setAttribute("currency", currencyString);
				request.getRequestDispatcher("chart.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * ******************************************
		 */
		 
		
	}

}