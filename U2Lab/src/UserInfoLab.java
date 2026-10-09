import java.util.Scanner;

public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        Scanner scan = new Scanner(System.in);

        // Ask the user to enter their first and last name and pass these
        System.out.print("First name: ");
        String firstName = scan.nextLine();
        System.out.print("last name: ");
        String lastName = scan.nextLine();
        generateUsername(firstName, lastName);
        System.out.println("Username: " + generateUsername(firstName, lastName));
        System.out.print("Password: ");
        String password = scan.nextLine();
        if(validatePassword(password)){
            System.out.print("Credit card number: ");
            String creditCardNumber = scan.nextLine();
            String masked = maskCreditCard(creditCardNumber);
            System.out.print("Credit card: " + masked);
        }

        // values to the generateUsername method and save the returned result.

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        String first = "";
        String last = "";
        if (firstName.length() < 3) {
            first = firstName;
        } else {
            first = firstName.substring(0, 3);
        }

        if (lastName.length() < 3) {
            last = lastName;
        } else {
            last = lastName.substring(0, 3);
        }

        return (first + last);

    }

    public static boolean validatePassword(String password) {
        // Fill in this method and return true/false if the password is valid
        boolean hasUppercase = false;
        if (password.length() < 8) {
            System.out.println("Not 8 characters");
        }
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                hasUppercase = true;
            }
        }

        if (!hasUppercase) {
            System.out.println("No uppercase");
        }

        if (!containsDigit(password)) {
            System.out.print("No digits");
        }

        if (password.length() < 8 || !hasUppercase || !containsDigit(password)) {
            return false;
        }
        return true;
    }

    public static String maskCreditCard(String creditCardNumber) {
        // Fill in this method and if the credit card is valid, return a masked CC
        if (creditCardNumber.length() == 16 && allDigits(creditCardNumber)) {
            String result = "**** **** **** ";
            result += creditCardNumber.substring(12, 16);
            return result;
        } else{
            return "N/A";
        }
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
