package com.company.model.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResidualAmount {
	
	public double Calculate(String purchaseDate, Double depreciation, Double purchasePrice ) {
		Double resAmt = 0.0; //residual amount
		try {
			Date today = new Date();
			long finalTime = today.getTime();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date purchaseDate2 = formatter.parse(purchaseDate);
			long initialTime = purchaseDate2.getTime();
			long millInYear = (86400000L * 365L); //milliseconds in one year
			long resYears = (finalTime - initialTime) / millInYear; //residual years
			//Double resAmt ; //residual amount
			
			if(resYears >= depreciation) {
				resAmt = 0.0;
			} else if(resYears >= 0) {
				resAmt = purchasePrice * (1 - resYears/depreciation);
			} else {
				resAmt = 0.0;
			}
			
			
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return resAmt;
		
	}

}
