package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//com.mystore.utilities.ExtentListenerClass
public class ExtentListenerClass implements ITestListener {

    // object of reports

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport() {

	ReadConfig readconfig = new ReadConfig();
	String timestamp = new SimpleDateFormat("yyyy.mm.dd hh.mm.ss").format(new Date());
	String reportName = "MystoreTestReport" + timestamp + ".html";
	htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
	reports = new ExtentReports();
	reports.attachReporter(htmlReporter);

// Add system information /environment info to report

	reports.setSystemInfo("Machine", "testpc1");
	reports.setSystemInfo("os", "windows 11");
	reports.setSystemInfo("browser:", readconfig.getBrowser());
	reports.setSystemInfo("user name", "Nitin");

// Configuration to change look and feel of reports

	htmlReporter.config().setDocumentTitle("Extent Listner reports");
	htmlReporter.config().setReportName("Thise id my first report");
	htmlReporter.config().setTheme(Theme.DARK);

    }

    @Override

    // On finish Method is called after all test are Executed.

    public void onFinish(ITestContext Results) {

	System.out.println("On Finish method Finished.....");
	reports.flush();// (It is mandatory to call flush method to ensure information is written to the
			// starter Reporter.)
    }

//ITestListeneer Interfaces Method called

    // oN start method is called when any test Start.
    @Override
    public void onStart(ITestContext Results) {
	configureReport();
	System.out.println("On Start method invoked.....");
    }

    public void onTestFailedButwithinSuccesspercentage(ITestResult Result) {
    }

    // when Test case get failed, This method called.
    @Override
    public void onTestFailure(ITestResult Results) {

	System.out.println("Name of test method failed:" + Results.getName());

	test = reports.createTest(Results.getName());

	// Create entry in the html report.
	test.log(Status.FAIL,
		MarkupHelper.createLabel("Name of the Failed test case is:" + Results.getName(), ExtentColor.RED));

	String Screenshotpath = System.getProperty("user.dir") + "\\Screenshot\\" + Results.getName() + ".png";

	File screenshotsFile = new File(Screenshotpath);

	if (screenshotsFile.exists()) {
	    test.fail("Captured Screenshot is Below:" + test.addScreenCaptureFromPath(Screenshotpath));
	}

// test.addScreenCaptureFromPath(null)
    }

    // OnTest Skipped method called when test case get skipped
    @Override
    public void onTestSkipped(ITestResult Results) {

	System.out.println("Name of test method Skipped:" + Results.getName());

	test = reports.createTest(Results.getName());// Cteate entry in the html report
	test.log(Status.SKIP,
		MarkupHelper.createLabel("Name of the Skipped test case is:" + Results.getName(), ExtentColor.YELLOW));

    }

    // OnTest Skipped method called when test case get skipped
    @Override
    public void onTestStart(ITestResult Results) {

	System.out.println("Name of test method Started:" + Results.getName());

    }

    // OnTest Success method called when test case get skipped
    @Override
    public void onTestSuccess(ITestResult Results) {

	System.out.println("Name of test method Success:" + Results.getName());

	test = reports.createTest(Results.getName());
// Create entry in the html report
	test.log(Status.PASS,
		MarkupHelper.createLabel("Name of the Sucess test case is:" + Results.getName(), ExtentColor.GREEN));

    }

}