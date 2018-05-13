package maprdbrest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class restapp {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		HttpClient client = new DefaultHttpClient();

	
		HttpGet request = new HttpGet(
		        "http://<your maprdbrestnode: port>/< your maprdb table name>/<row key>/<columnfamily:columnname");
				
		request.addHeader("Accept", "Application/json");

		HttpResponse response = client.execute(request);
		// System.out.println(response.toString());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		String line = "";
		JSONParser parser = new JSONParser();

		while ((line = rd.readLine()) != null) {

			//System.out.println(line);
			try {
				JSONObject obj = (JSONObject) parser.parse(line);

				//System.out.println(obj);
				//System.out.println(obj.get("Row"));

				JSONArray obj1 = (JSONArray) obj.get("Row");
				//System.out.println(obj1.get(0));

				JSONObject obj2 = (JSONObject) obj1.get(0);
				//System.out.println(obj2.get("Cell"));

				JSONArray obj3 = (JSONArray) obj2.get("Cell");
				//System.out.println(obj3.get(0));

				JSONObject obj4 = (JSONObject) obj3.get(0);
				System.out.println(obj4.get("$"));

				byte[] resultStr = Base64.decodeBase64((String) obj4.get("$"));
				// byte[] resultStr = Base64.decodeBase64("");

			
				PrintWriter out = new PrintWriter("Receipt.html");
				out.println(new String(resultStr));
				System.out.println(new String(resultStr));
				out.close();

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
