package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CreateScreenshot
{
	public static void snap(WebDriver driver,String screen){
    String path;
    try {
        
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        path = "./Snapshot/"+screen+".jpeg";
        FileUtils.copyFile(scrFile, new File(path)); 
        System.out.println("Snapshot Taken");
     
    }
    catch(IOException e) 
    {
        path = "Failed to capture screenshot: " + e.getMessage();
//        System.out.println("Snapshot Taken");
    }
    return;
}
}