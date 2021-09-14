package com.Demo.Utills;
import java.io.File;

public class Constants {
	
	
	public static final String path = System.getProperty("user.dir");
	public static final String Chrome = "chrome";
	public static final String Firefox = "firefox";
	public static final String IE = "internetexplorer";
	
	public static final String	ChromeDriverPath = path+File.separator+Constants.Src+File.separator+Constants.Resources+File.separator+Constants.Drivers+File.separator+"chromedriver.exe";
	public static final String	FirefoxDriverPath = path+File.separator+Constants.Src+File.separator+Constants.Resources+File.separator+Constants.Drivers+File.separator+"geckodriver.exe";
	public static final String	IEDriverPath = path+File.separator+Constants.Src+File.separator+Constants.Resources+File.separator+Constants.Drivers+File.separator+"IEDriverServer.exe";

	public static final String	DownloadFolderPath = path+File.separator+Constants.Resources+File.separator+Constants.Downloads;
	public static final String Src = "src";
	public static final String Resources = "Resources";
	public static final String Drivers = "Drivers";
	public static final String Data = "Data";
	public static final String Downloads = "Downloads";
	
	public static final String index = "Index";
	public static final String value = "Value";
	public static final String visibleText = "VisibleText";
	
	public static final String herokuapp_Url = "https://the-internet.herokuapp.com/";
	
	public static String LocEnd = "']";
	


}
