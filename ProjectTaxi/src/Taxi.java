import java.util.*;
import java.math.BigInteger;
import java.sql.*;

public class Taxi {

//	

	public static void Login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your phone number for Login : ");
		long l = sc.nextLong();
		System.out.print("Enter your password : ");
		String psw = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			Statement stmt = con.createStatement();
			String q = "use project";

			stmt.executeUpdate(q);
			String query = "select passcode from taxi where phonenumber = " + l;

			ResultSet rs = stmt.executeQuery(query);

			String password = "";
			while (rs.next()) {
				password = rs.getString("passcode");
			}
			if (password.equals(psw)) {
				System.out.println("Logged in successfully\n\n");
				Mainmenu(sc,l,con,stmt,rs);
			} else {
				System.out.println("Invalid Login !!!\n");
				System.out.print("Retry [Y/N] : ");
				char ch=Character.toLowerCase(sc.next().charAt(0));
				if(ch=='y') {
					Login();
				}else {
					System.out.println("Applaication Closed");
				}
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println("error occured");

		}

	}

	public static void createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name : ");
		String name = sc.nextLine();
		
		if (name.length() > 2 && name.length() <= 30) {
		} else {
			System.out.println("Enter your name from 2 characters to 30 characters");
			createAccount();
		}
		
		System.out.print("Enter your Phone number : ");
		
		long phno = sc.nextLong();
		String s = "" + phno;
		
		
		while (s.length() != 10) {
			System.out.println("Enter proper phone number : ");
			System.out.println();
			phno = sc.nextLong();
			s = "" + phno;
		}
		
		System.out.print("Enter your age : ");
		int age = sc.nextInt();
		System.out.print("Enter your password : ");
		String psw = sc.next();

		String arr[] = new String[4];
		arr[0] = name;
		arr[1] = s;
		arr[2] = "" + age;
		arr[3] = psw;
		store(arr);
	}

	public static void store(String args[]) {

		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("use project");

			String name = args[0];
			int age = Integer.parseInt(args[2]);
			String pwd = args[3];
			String phno = args[1];

			while (true) {
				ResultSet r = stmt.executeQuery("select * from taxi where phonenumber = " + phno);
				if (find(r, phno) == true)
					break;
				System.out.println("Please enter your phone number properly");
				System.out.print("Enter Your phone number Again : ");
				phno = sc.next();
			}
			String sql = "insert into taxi values(" + phno + ",'" + name + "'," + age + ",'" + pwd + "')";
//System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.executeUpdate("insert into taxisavings values ("+phno+","+"0.0)");
			System.out.println("Account created Successfully\n");
			Login();

//			 sql = ("SELECT * FROM student");
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) { 
//			 int id = rs.getInt("id"); 
//			 System.out.println(id);
//			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error occured");

		}

	}

	public static boolean find(Object r, String phno) {
		String p = "" + phno;
		if (p.length() == 10) {
			try {
				if (!((ResultSet) r).isBeforeFirst()) {
					return true;

				} else {
					System.out.println("pone number is already existed \n\n");
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	static void Mainmenu(Scanner sc, long l, Connection con, Statement stmt, ResultSet rs) {
		System.out.println("Book your Ride --> [B]");
		System.out.println("Check your Taxi Wallet Balance --> [W]");
		char a = sc.next().charAt(0);
		if (a == 'B' || a == 'b') {
			Ride r = new Ride(l,con,stmt,rs,a);
			

		} else {
			a=Character.toLowerCase(a);
			Savings saving = new Savings(l, con, stmt, rs, a);

		}
	}

	

}
