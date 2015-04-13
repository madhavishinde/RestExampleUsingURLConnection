package abc;
import java.io.BufferedReader;
//import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
//import java.net.HttpURLConnection;
import java.net.URL;
 


//import javax.net.ssl.HttpsURLConnection;

public class RestApiUsingURLConnection {
	 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		//System.out.println("Hiiii");
		RestApiUsingURLConnection http1 = new RestApiUsingURLConnection();
 
		System.out.println("\nTesting 2 - Send Http POST request");
		http1.sendPost();
 
	}
	
	
	// HTTP POST request
		private void sendPost() throws Exception {
	 
			String url = "http://10.43.1.107:35357/v2.0/tokens";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			//add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			
			String urlParameters = "{\"auth\": {\"tenantName\":\"admin\",\"passwordCredentials\":{\"username\":\"admin\",\"password\":\"OpenstacK123\"}}}";
			// Send post request
			con.setDoOutput(true);
			
			OutputStream os = con.getOutputStream();
	        os.write(urlParameters.getBytes());
	        os.flush();
	
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				//response.append("\n");
				
			}
			in.close();
	 
			
			System.out.println(response.toString());
	 
		}
}