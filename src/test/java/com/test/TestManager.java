package com.test;

import java.io.IOException;

import com.test.Tests.HeaderTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestManager {

        //TODO использовать assert и softAssert

        //вынести все настройки (driver)для общих тестов в тест-сьют
        //общий функционал - один suit
        //действие 

        //например, для хэдера
        //headerSuitBefore - определение driver, getUrl, 
        //  searchTestBefore - preCondition конкретно этого теста, pages
        //  BasketTest
        //      //clickLogin()

        public static void main(String[] args) throws IOException, InterruptedException {
                
                //driver.get(URL);
                //driver.manage().window().maximize();

                Result result = JUnitCore.runClasses(HeaderTest.class);					
                for (Failure failure : result.getFailures()) {							
                        System.out.println("failures" + failure.toString());					
                }

                // Request request = Request.method(HeaderTest.class, "logo");
                // Result result = new JUnitCore().run(request);

                //Reporter.log("Result successful: " + result.wasSuccessful(), true);

                // TestListenerAdapter tla = new TestListenerAdapter();
                // TestNG testng = new TestNG();
                // List<String> suites = Lists.newArrayList();
                // suites.add("c:/tests/testng1.xml");//path to xml..
                // suites.add("c:/tests/testng2.xml");
                // testng.setTestSuites(suites);
                // testng.run();


                //Warning: if test not runs, check annotation's library, should be "import org.testng.annotations.Test;"

                //TestNG testSuite = new TestNG();
		//testSuite.setTestClasses(new Class[] { SearchTest.class, HeaderTest.class });

		//testSuite.addListener(new SuiteListener());
		//testSuite.setOutputDirectory("/home/bonum/Projects/testing workspace/automation/test/reports/");
		//testSuite.setDefaultTestName("My Test");

		//testSuite.setDefaultSuiteName("Header Test Suite");
		//testSuite.run();
        
                	
        }
}
