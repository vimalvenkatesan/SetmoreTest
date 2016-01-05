package logins;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import org.testng.annotations.Listeners;
import Utility.Reporter;
import org.testng.annotations.Test;

@Listeners(Reporter.class)

public class TestingSample 
{
	@Test
	public void testRealReportOne()
	{
		AssertJUnit.assertTrue(true);
	}

	@Test
	public void testRealReportTwo()
	{
		AssertJUnit.assertTrue(false);
	}

	// Test case depends on failed testcase= testRealReportTwo
	@Test(dependsOnMethods = "testRealReportTwo")
	public void testRealReportThree() {
	}

}