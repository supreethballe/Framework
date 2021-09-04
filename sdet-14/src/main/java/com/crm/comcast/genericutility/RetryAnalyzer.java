package com.crm.comcast.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int count=0;
	
	private int retryCount=3;
	
	@Override
	public boolean retry(ITestResult result) {
		while(count<retryCount){
			count++;
			return true;
		}
		return false;
	}

}
