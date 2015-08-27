package callUrl;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import controller.*;
import dao.*;
import model.*;
import service.*;

public class PostURLRestClient {

	public static void main(String[] args){
		try{
			
			URL targetUrl = new URL("http://localhost:8080/restApp/restDemo/add");
			HttpURLConnection httpConnection = (HttpURLConnection)targetUrl.openConnection();
			
			//httpConnection.setRequestProperty("Authorization",basicAuth);
			//httpConnection.setRequestMethod("POST");
			
			//httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//httpConnection.setRequestProperty("Content-Language", "en-US");
			//httpConnection.setUseCaches(false);
			//httpConnection.setDoInput(true);
			//httpConnection.setDoOutput(true);
			
			//Authenticator.setDefault (new MyAuthenticator ());
			
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type","application/json");
			
			String input = "{\"bookName\":\"geo8\"}";
			//String input = "{'bookName':'geo7'}"; 
			
			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();
			
			if(httpConnection.getResponseCode()!=200){
				throw new RuntimeException("Failed : HTTP error code : "						
	                    + httpConnection.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			
			String output;
			while((output = br.readLine())!=null){
				System.out.println(output);
			}
			
			httpConnection.disconnect();
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
