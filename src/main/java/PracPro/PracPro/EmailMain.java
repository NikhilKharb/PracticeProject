package PracPro.PracPro;

import java.util.ArrayList;
import java.util.List;

public class EmailMain {

	public static void main(String[] args) {
		
		ArrayList<String> emails = new ArrayList<String>();
		emails.add("john.doe@example.com");
		emails.add("gohn.doe@example.com");
		emails.add("user+filter@gmail.com");
		emails.add("@missinglocalpart.com");
		emails.add("user@domain");
		emails.add("user@domain");
		emails.add("alice.smith@mail.sub.domain.com");
		
		
for(String email:emails) {
	boolean result =isValidEmail(email);
	System.out.println(result);
}
		
		
		
		
	}
	public static boolean isValidEmail(String email) {
		   // String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+$"; // Simplified regex

		String emailRegex = "^[a-zA-Z0-9._+%-]+@[a-zA-Z0-9.-_]+\\.[a-zA-Z0-9.+_-]+$";
		    return email != null && email.matches(emailRegex);

		}

}
