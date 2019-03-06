package slipmaster.com.vert_client_exam;


import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import slipmaster.com.vert_client_exam.entity.Movie;
import slipmaster.com.vert_client_exam.kickside.DateMaker;

public class Client 
{
    public static void main( String[] args )
    {
     
    	
    	Vertx vertx = Vertx.vertx();
    	
    	WebClient client = WebClient.create(vertx);
    	
    	
    	
    	/**
    	 * Creating New Movie 
    	 *  Sending New Object 
    	 *
    	 */
    	
    	client.post(8091, "localhost", "/add").sendJson(new Movie("Titanic",false,DateMaker.dateHelper(2019, 03, 31),"20:30"), response -> {
    		
    		if(response.succeeded()) {
    			
    			HttpResponse<Buffer> httpResponse = response.result();
    			
    			System.out.println("Response 1 " + httpResponse.bodyAsString());
    			
    		} else {
    			
    			System.out.println("Response Error " + response.cause().getMessage());
    		}
    		
    	});
    	
    	
         client.post(8091, "localhost", "/add").sendJson(new Movie("American Pie",false,DateMaker.dateHelper(2019, 03, 31),"20:30"), response -> {
    		
    		if(response.succeeded()) {
    			
    			HttpResponse<Buffer> httpResponse = response.result();
    			
    			System.out.println("Response 2 " + httpResponse.bodyAsString());
    			
    		} else {
    			
    			System.out.println("Response Error " + response.cause().getMessage());
    		}
    		
    	});
    	
    	
    	
    	
    	/**
    	 * 
    	 * 
    	 */
    	
    	client.get(8091, "localhost", "/get").send(response -> {
    		
             if(response.succeeded()) {
    			
    			HttpResponse<Buffer> httpResponse = response.result();
    			
    			System.out.println("Response 3 " + httpResponse.bodyAsString());
    			
    		} else {
    			
    			System.out.println("Response Error " + response.cause().getMessage());
    		}
    		
    		
    	});
    	
    	
    	/**
    	 * 
    	 * 
    	 */
    	
    	client.get(8091, "localhost", "/get/:name").setQueryParam("name", "Titanic").send(response -> {
    		
             if(response.succeeded()) {
    			
    			HttpResponse<Buffer> httpResponse = response.result();
    			
    			System.out.println("Response By Movie Name " + httpResponse.bodyAsString());
    			
    		} else {
    			
    			System.out.println("Response Error " + response.cause().getMessage());
    		}
    		
    		
    	});
    	
    	
    	
    }
}
