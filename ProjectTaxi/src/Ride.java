import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Ride {
	
	public Ride(long l, Connection con, Statement stmt, ResultSet rs, char a) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your pickup location");
		String pickup = sc.nextLine();
		System.out.println("Enter Your Destination location");
		String dest = sc.nextLine();
		
		Random rnd = new Random();
		int n = rnd.nextInt(100, 1000);
		
		System.out.println("Your taxi fair is = " + n);
		System.out.println("Confirm your Taxi [y/n]");
		char response = sc.next().charAt(0);
		
		if (response == 'y') {
			System.out.println("Your booking is confirmed");
			Savings save=new Savings(l,con,stmt,rs,n);
			
		} else if (response == 'n') {
			System.out.println("Your booking is canceled");
		} else {
			System.out.println("Enter valid input");
		}
	}
}
