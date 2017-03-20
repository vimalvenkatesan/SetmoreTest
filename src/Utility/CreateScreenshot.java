package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CreateScreenshot
{
	
	public static String snap(WebDriver driver,String screenshotNames){
    String path;
    try {
        
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        path = "./Screenshots/"+screenshotNames+".png";
        FileUtils.copyFile(scrFile, new File(path)); 
        System.out.println("Snapshot Taken");
     
    }
    catch(IOException e) 
    {
        path = "Failed to capture screenshot: " + e.getMessage();
        System.out.println("Exception while taking snapshot");
    }
    return path;
}
}