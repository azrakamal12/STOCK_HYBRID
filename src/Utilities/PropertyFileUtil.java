package Utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFileUtil {
public static String getValueForKey(String Key) throws Exception{
	Properties conpro= new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\kamal.a\\Documents\\MyNewWorkspace\\Stock_Accounting\\src\\Utilities\\PropertyFileUtil.java");
	conpro.load(fis);
	return(String) conpro.get(Key) ;
}
}
