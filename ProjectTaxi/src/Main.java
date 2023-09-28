import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to TaxiTaxi\n");
		response();
	}

	public static void response() {
		Taxi ex = new Taxi();
		Scanner sc = new Scanner(System.in);
		System.out.println("Login -> [L]");
		System.out.println("Create Account -> [C]");
		char value = sc.next().charAt(0);
		if (value == 'L' || value == 'l') {
			ex.Login();
		} else if (value == 'C' || value == 'c') {
			ex.createAccount();
		} else {
			System.out.println("Enter correct value !!!!\n\n");
			response();
		}
	}
}
