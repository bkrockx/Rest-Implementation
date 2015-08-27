package callUrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;



public class URLRestClient {
	
	public static void main(String[] args){
		
		try{
			URL targetUrl = new URL("http://localhost:8080/restApp/book/list");
			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			
			final String userpass = "aa" + ":" + "aa";
			final String basicAuth = "Basic " + Base64.encodeBase64String(userpass.getBytes());
			//httpConnection.setRequestProperty("Authorization",basicAuth);
			//httpConnection.setRequestMethod("POST");
			
			//httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//httpConnection.setRequestProperty("Content-Language", "en-US");
			//httpConnection.setUseCaches(false);
			//httpConnection.setDoInput(true);
			//httpConnection.setDoOutput(true);
			
			Authenticator.setDefault (new MyAuthenticator ());

			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/json");
			
			if(httpConnection.getResponseCode()!=200){
				throw new RuntimeException("Error code : "+ httpConnection.getResponseCode());
			}
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			
			String output;
			while((output=br.readLine())!=null){
				System.out.println(output);
			}
			
			httpConnection.connect();
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
