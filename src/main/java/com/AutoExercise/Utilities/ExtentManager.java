package com.AutoExercise.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
        	
        	String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
    		String reportName = "Automation Exercise Test Reports" + timestamp + ".html";
    		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
            htmlReporter.config().setDocumentTitle("Automation Exercise Test Report");
            htmlReporter.config().setReportName("Test Execution Report");
            htmlReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            
            ReadConfig readConfig = new ReadConfig();
            extent.setSystemInfo("machine", "LAPTOP-B8TJUCIE");
            extent.setSystemInfo("os", "window 11 pro");
            extent.setSystemInfo("browser", readConfig.getBrowser());
            extent.setSystemInfo("user name", "Rushi");
        }
        return extent;
    }
}
