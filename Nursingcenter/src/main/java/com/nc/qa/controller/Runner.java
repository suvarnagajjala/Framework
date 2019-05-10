package com.nc.qa.controller;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.nc.qa.excelUtils.ExcelUtils;



public class Runner {
	

	

		static ExcelUtils excelUtility = new ExcelUtils();
		public static void main(String[] args) 
		{
			excelUtility.readTestSuite();
			System.out.println("TestData reading done");
			Map<String, String> map = excelUtility.LoginModuleData;
			Set<String> keys = map.keySet();
	        Iterator<String> itr = keys.iterator();
	 
	        String key;
	        String value;
	        while(itr.hasNext())
	        {
	            key = (String)itr.next();
	            value = (String)map.get(key);
	            System.out.println(key + " - "+ value);
	        }
				
		}
	}

	
	

