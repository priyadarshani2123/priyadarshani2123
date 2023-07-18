package com.hashtag.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Readconfig {
	Properties properties;
	String path="C:\\Users\\admin\\eclipse-workspace-new\\DemoProject\\Configuration\\confifproperties";
	
	
	    public Readconfig() {
		try {
		properties=new Properties();
		
		
		FileInputStream fis=new FileInputStream(path);
		
		properties.load(fis);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
       public String getbaseUrl()
	{
		String value = properties.getProperty("baseUrl");
		
		if(value!=null)
		return value;
		else	
		throw new RuntimeException("Url is not specified in config file");
	}
	public String getbrowser()
	{
		String value = properties.getProperty("browser");

		if(value!=null)
		return value;
		else 
		throw new RuntimeException("browser is not specified in config file");
	}
	
}	
		
		
	
	

