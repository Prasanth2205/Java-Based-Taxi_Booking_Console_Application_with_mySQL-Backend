import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Savings {
 Savings(long l, Connection con, Statement stmt, ResultSet rs ,char value){
	 Scanner sc=new Scanner(System.in);
	 if(value=='w') {
	try {
	
	rs=stmt.executeQuery("Select savings from taxisavings where phonenumber = "+l);
	
	if(rs.next()) {
	
		String phno=""+rs.getString(1);
		System.out.println("Your Wallet Balance is : Rs."+phno);
		
		System.out.println("Return to main Menu [Y/N]");
		char ch=sc.next().charAt(0);
		if(ch=='Y' || ch=='y') {

			Taxi.Mainmenu(sc, l, con, stmt, rs);
		}
	}
	
}catch(Exception e)
	{
	System.out.print(e);
	}}
	 
	}

	


public Savings(long l, Connection con, Statement stmt, ResultSet rs, int n) {
	// TODO Auto-generated constructor stub
	try {
			 rs=stmt.executeQuery("select savings from taxisavings where phonenumber = "+l);
			 System.out.println("Pay with your TaxiWallet --> [W]");
			 System.out.println("Pay with Cash --> [C]");
			 Scanner sc=new Scanner(System.in);
			 char ch=sc.next().charAt(0);
			 if(ch=='w' || ch=='W')
			 {
				 if(rs.next()) {
				 double d=rs.getDouble(1);
				 System.out.println("Your Booking has confirmed");
				 System.out.println("Your taxi fair now is "+(((double)n)-d));
				 stmt.executeUpdate("update taxisavings set savings="+"0.00"+" where phonenumber = "+l);
				 
				 }
				 
			 }
			 else {
			 if(rs.next()) {
				 double d=rs.getDouble(1);
				 double a=((double)n)/100.0;
				 d=a+d;
				 stmt.executeUpdate("update taxisavings set savings="+d+" where phonenumber = "+l);
				 System.out.println("Your Booking has confirmed !!!");
				 rs=stmt.executeQuery("select savings from taxisavings where phonenumber = "+l);
				 System.out.print("Your wallet balance is :");
				 if(rs.next()) {
					 System.out.print(rs.getDouble(1));
				 }
				 
			 }
			 }
		 }catch(Exception e) {
			 System.out.println(e);
		 }

}
}
