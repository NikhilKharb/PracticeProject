package PracPro.PracPro;

public class debug1 extends Users {

    public static void main(String[] args) {
        // Example usage
        Users user = new Users();
        user.FirstName = "John";  // Assuming fields are accessible
        user.LastName = "Doe";

        debug1 obj = new debug1();
        String fullName = obj.getUserFullName(user);
        System.out.println("Full Name: " + fullName);
    }

    @Override
    public String getUserFullName(Users user) {
        try {
            if (user == null || user.FirstName == null || user.LastName == null) {
                throw new IllegalArgumentException("User or user details cannot be null");
            }

            String FullName = user.FirstName + " " + user.LastName;
            return FullName;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving full name";  // Return a default message in case of error
        }
    }
}
