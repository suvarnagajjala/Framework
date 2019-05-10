package com.nc.qa.base;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Logging {
	
	

	/**
	 * Created by Dell on 14-07-2017.
	 */
	
	    Object obj = Logging.class.getName();

	    /**
	     * This method logs the starting time of the test
	     * @param sClassName - Name of the classing script
	     * @author rwilliams
	     */
	    public static void startLogging(String sClassName){
	        String strTime = getCurrentDateAndTime();
	        Logger Log = Logger.getLogger(sClassName);
	        //Log.getClass().
	        Log.info("______________________________");
	        Log.info("Test Started: "+strTime);
	        //System.out.println("Test Started: "+strTime);
	        //System.out.println("\n______________________________________________\n");

	    }

	    /**
	     * This method logs the end time of the test
	     * @param sClassName - The calling script
	     * @author rwilliams
	     */
	    public static void endLogging(String sClassName){
	        String strTime = getCurrentDateAndTime();
	        Logger Log = Logger.getLogger(sClassName);
	        Log.info("Test Ended: "+strTime);
	        Log.info("______________________________");
	        //System.out.println("Test Ended: "+strTime);
	        //System.out.println("______________________________________________");

	    }

	    /**
	     * This method logs the message specified in strMessage
	     *
	     * @param sClassName - Calling Script
	     * @param strMessage - Message to be logged
	     * @author rwilliams
	     */
	    public void logInfo(String sClassName,String strMessage){
	        Logger Log = Logger.getLogger(sClassName);
	        Log.info(strMessage);
	        Log.debug(strMessage);
	        System.out.println(strMessage);
	    }

	    /**
	     * This method gets the current date & time and returns them as a String
	     * @return - Current Date & Time
	     * @author rwilliams
	     */
	    public static String getCurrentDateAndTime(){
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        Date date = new Date();
	        String strTime = dateFormat.format(date);
	        return strTime;
	    }

	    /**
	     * This method gets the current date and returns it as a String
	     * @return - Current Date
	     * @author rwilliams
	     */
	    public static String getCurrentDate(){
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date date = new Date();
	        String strTime = dateFormat.format(date);
	        return strTime;
	    }

	    public static Date addDays(Date date, int days)
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days); //minus number would decrement the days
	        return cal.getTime();
	    }


	    public static String addToCurrentDate(int iDays){
	        Date date = new Date();

	        GregorianCalendar cal = new GregorianCalendar();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, iDays);

	        Date newDate = cal.getTime();

	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        String outStr = simpleDateFormat.format(newDate);

	        return outStr;
	    }


	    /**
	     * This methods pauses execution of the script for the
	     * time specified by iHowLong
	     * @param sClassName - Calling Script
	     * @param iHowLong - Duration in MilliSeconds
	     */
	    public void sleep(String sClassName,int iHowLong){
	        Logger Log = Logger.getLogger(sClassName);
	        try {
	            Log.info("Sleeping for "+iHowLong+" milliseconds");
	            Thread.sleep(iHowLong);
	        }
	        catch (InterruptedException e) {
	            e.getMessage();
	        }

	        //System.out.println("Sleeping for "+iHowLong+" milliseconds");
	    }

	    public String getDateInPast(int iNumOfDaysInPast, String strFormat){
	        DateFormat format = new SimpleDateFormat(strFormat);
	        Calendar date = new GregorianCalendar();
	        date.add(Calendar.DATE, iNumOfDaysInPast);
	        String strDate = format.format(date.getTime());
	        logInfo(obj.toString(), "Date of "+iNumOfDaysInPast+" in past of format "+strFormat+" :- "+strDate );

	        return strDate;
	    }
	}





