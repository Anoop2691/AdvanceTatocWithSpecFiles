package AdvanceTatocTest;

import java.io.BufferedReader;
import static AdvanceTatocTest.RetrieveLocators.element;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestingRestPageByAddingSession extends ReturnPageHeading{

	public String getSessionId() {
		return element("findSessionId").getText();
	}
	
	public void generatingTokenAndRegisterRestService() throws IOException {
		String [] sessionArr=getSessionId().split(": ");
		URL geturl = new URL("http://10.0.1.86/tatoc/advanced/rest/service/token/" + sessionArr[1]);
		HttpURLConnection getconn = (HttpURLConnection) geturl.openConnection();
		getconn.setRequestMethod("GET");
		getconn.setRequestProperty("Accept", "application/json");
		if (getconn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ getconn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((getconn.getInputStream())));
		String output;
		String restful = new String();
		while ((output = br.readLine()) != null) {
			restful=restful.concat(output);
		}
		br.close();
		String response[]= restful.split(":\"");
		String token[]= response[1].split("\"");
		String jsonToken= token[0];

		try {
			URL posturl = new URL("http://10.0.1.86/tatoc/advanced/rest/service/register");
			HttpURLConnection postconn = (HttpURLConnection) posturl.openConnection();
			postconn.setDoOutput(true);
			postconn.setRequestMethod("POST");

			postconn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String input = "id="+sessionArr[1]+"& signature="+jsonToken+"&allow_access=1";

			DataOutputStream wr = new DataOutputStream(postconn.getOutputStream());
			wr.writeBytes(input);
			wr.flush();
			wr.close();
			postconn.getResponseCode();
			postconn.disconnect();
			Thread.sleep(3000);
			element("proceed").click();     
		}
		catch(Exception e) {
			System.out.println("exception: "+ e);
		}
	}
}
