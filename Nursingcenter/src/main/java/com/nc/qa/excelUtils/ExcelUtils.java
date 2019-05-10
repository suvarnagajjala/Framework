package com.nc.qa.excelUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class ExcelUtils {

	
	
	
		public static String testCase_ID;
		public static String execution_Status;
		public static String module_Name;
		public static String test_Run_Status;
		
		public static String path_TestData = "C:\\Users\\DELL\\suvvi-workspace\\Nursingcenter\\TestData.xlsx";
		public static Fillo fillo = new Fillo();
		public static Map<String,String> LoginModuleData = new  HashMap<String,String>();
		public static Map<String,String> RegistrationModuleData= new  HashMap<String,String>();
		
		public void  readTestSuite()
		{
			List<String> testCaseList = new ArrayList<String>();
			try
			{
				Connection readTestSuiteConnection = null;
				Recordset readTestSuiteRecordset = null;
				
				readTestSuiteConnection = fillo.getConnection(path_TestData);
				String query = "Select * from TestSuite Where Execution_Status='Yes'";
				System.out.println("Test Suite Query :"+query);
				readTestSuiteRecordset = readTestSuiteConnection.executeQuery(query);
				while(readTestSuiteRecordset.next())
				{
					testCaseList.add(readTestSuiteRecordset.getField("TestCase_ID")+"~"+readTestSuiteRecordset.getField("Module_Name"));
				}
				
				readTestSuiteConnection.close();
				readTestSuiteRecordset.close();
				
				Iterator<String> valuesItertor = testCaseList.iterator();
				for(int i=0;i<testCaseList.size();i++)
				{
				//int i = 0;
				//while(valuesItertor.next() != null)
				//{
					String[] testCaseCount = testCaseList.get(i).split("~");
					if(testCaseCount.length>=1)
					{
						testCase_ID = testCaseCount[0];
						module_Name = testCaseCount[1];
						if(module_Name.equalsIgnoreCase("Login"))
						{
							populateIndiaTestData(module_Name, testCase_ID);
						} else if(module_Name.equalsIgnoreCase("Registration"))
						{
							populateAustraliaTestData(module_Name, testCase_ID);
						}
					}
				}
			} catch(Exception e)
			{
				System.out.println("Failed to read TestSuite data from Excel : "+e.getMessage());
			}
		}
		
		public void populateIndiaTestData(String moduleName,String testCaseId)
		{
			Connection testDataConnection = null;
			Recordset testDataRecordSet = null;
			//Map<String,String> indiaModuleData = new  HashMap<String,String>();
			
			try
			{
				testDataConnection = fillo.getConnection(path_TestData);
				String query = "Select * from "+moduleName+" where testCase_ID='"+testCaseId+"'";
				testDataRecordSet = testDataConnection.executeQuery(query);
				while(testDataRecordSet.next())
				{
					LoginModuleData.put("UserName", testDataRecordSet.getField("UserName"));
					LoginModuleData.put("Password", testDataRecordSet.getField("Password"));
					/*indiaModuleData.put("Age", testDataRecordSet.getField("Age"));
					indiaModuleData.put("BattingRank", testDataRecordSet.getField("BattingRank"));
					indiaModuleData.put("BatAvg", testDataRecordSet.getField("BatAvg"));
					indiaModuleData.put("AllRounder", testDataRecordSet.getField("AllRounder"));*/
					
				}
				
				testDataConnection.close();
				testDataRecordSet.close();
			} catch(Exception e)
			{
				System.out.println("TestData not populated from : "+moduleName+" "+e.getMessage());
				testDataConnection.close();
				testDataRecordSet.close();
			}
		}
		
		public void populateAustraliaTestData(String moduleName,String testCaseId)
		{
			Connection testDataConnection = null;
			Recordset testDataRecordSet = null;
			//Map<String,String> AustModuleData = new  HashMap<String,String>();
			
			try
			{
				testDataConnection = fillo.getConnection(path_TestData);
				String query = "Select * from "+moduleName+" where testCase_ID='"+testCaseId+"'";
				testDataRecordSet = testDataConnection.executeQuery(query);
				while(testDataRecordSet.next())
				{
					RegistrationModuleData.put("Email Address", testDataRecordSet.getField("Email Address"));
					RegistrationModuleData.put("Password", testDataRecordSet.getField("Password"));
					RegistrationModuleData.put("FullName", testDataRecordSet.getField("FullName"));
					RegistrationModuleData.put("Practice Area", testDataRecordSet.getField("Practice Area"));
					RegistrationModuleData.put("Nursing Role", testDataRecordSet.getField("Nursing Role"));
					//RegistrationModuleData.put("AllRounder", testDataRecordSet.getField("AllRounder"));
					
				}
				testDataConnection.close();
				testDataRecordSet.close();
			} catch(Exception e)
			{
				System.out.println("TestData not populated from : "+moduleName+" "+e.getMessage());
				testDataConnection.close();
				testDataRecordSet.close();
			}
		}
	}

