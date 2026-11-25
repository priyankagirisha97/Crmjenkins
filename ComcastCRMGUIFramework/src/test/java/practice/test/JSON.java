package practice.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JSON {
@Test
	public void jsonData() throws FileNotFoundException, IOException, ParseException {
		
	
	
	JSONParser parse=new JSONParser();
	JSONObject jo=(JSONObject)parse.parse(new FileReader("./Json/Launchingbrowser.json"));
	System.out.println("Browser:"+jo.get("browser"));
	System.out.println("url:"+jo.get("url"));
	
	

}
}
