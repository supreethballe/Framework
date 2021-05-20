package commonUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileUtility {
	
	public static void main(String[] args) throws Throwable {
		
		FileReader reader = new FileReader("./commonData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject jobj= (JSONObject)obj;
		
		String value=jobj.get("url").toString();
		System.out.println(value);
	}
	

}
