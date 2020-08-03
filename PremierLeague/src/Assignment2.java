//package premierLeague;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Assignment2 
{
	public static void main( String[] args )
	{
		System.out.println("!! Management of a premiership table for an Australian Rules football league !!");
		Table t = new Table();		
		Controller c = new Controller(t);
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
			boolean isValid = true;
			while(isValid) {
			// Reading data using readLine 
			try{
				String name = reader.readLine(); 
				name = name.trim();
				String[] splited = name.split("\\s+");
				 
				//System.out.println(name); 
				if("9".equals(name)) {
					isValid = false;
				}
				c.commandLoop(splited);
				}catch(Exception e) {
					System.out.println("Invalid input"); 
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
