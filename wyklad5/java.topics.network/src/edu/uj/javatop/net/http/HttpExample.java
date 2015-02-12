package edu.uj.javatop.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class HttpExample {

	private static final SimpleDateFormat TIME_ONLY = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	
    public static void main(String[] args) throws IOException {
        
    	Scanner input = new Scanner(System.in);
	    System.out.println("Wybierz jednostki w ktorych chcesz wyswietlac temperature(0:metryczne,1:Faranheit)");

		int tempJedn = input.nextInt();
    	String jednostkiTemp;
    	
		if(tempJedn == 0){
    		jednostkiTemp = "metric";
    	}else{
    		jednostkiTemp = "imperial";
    	}
    		
    	URL url = null;
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Krakow,pl&units="+jednostkiTemp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        
        URLConnection urlConn = null;
        try {
            urlConn = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        InputStream is = urlConn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        
        String line;
        StringBuilder resp = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            resp.append(line);
        }
        reader.close();
        workOnResponse(resp.toString());
    }
    
    
    private static void workOnResponse(String response) {
		p("JSON: "+response);
		
		JSONObject ro = new JSONObject(response);
		
		JSONObject sys = ro.getJSONObject("sys");
		Date sunrise = new Date(sys.getLong("sunrise")*1000L);
		Date sunset = new Date(sys.getLong("sunset")*1000L);

		JSONArray weather = ro.getJSONArray("weather");
		String main = weather.getJSONObject(0).getString("main");
		
		JSONObject mainJson = ro.getJSONObject("main");
		int temp = mainJson.getInt("temp");
		//String icon = 
		
		
		p("Sunrise: " + TIME_ONLY.format(sunrise));
		p("Sunset: " + TIME_ONLY.format(sunset));
		p("General wheather is: "+main);
		p("Temperature is: "+temp);
		
	}
    
    
    private static void p(Object o){
    	System.out.println(o.toString());
    }

}
