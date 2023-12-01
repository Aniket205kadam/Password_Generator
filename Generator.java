package com.PasswordGenerator;

import java.util.Random;
import java.util.Scanner;

public class Generator {
    public static Scanner keyboard;

    //stored the pool string in the alphabet
    public static Alphabet alphabet;

    //one parameter receives by the constructor
    public Generator(Scanner scanner) {
        keyboard = scanner;
    }
    //default constructor
    public Generator() {}

    //four parameter receives by the constructor
    public Generator(boolean upperCaseInclude, boolean lowerCaseInclude, boolean numberInclude, boolean specialSymbolsInclude) {
        alphabet = new Alphabet(upperCaseInclude, lowerCaseInclude, numberInclude, specialSymbolsInclude);
    }

    public void mainLoop() {
        System.out.println();
        System.out.println("Welcome to Ak Password Services :) ");
        System.out.println();
        printMenu();
        String userOption = "-1";

        while(!userOption.equals("4")) {
            //option take as a String
            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                }
                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }
                case "4" -> {
                    printQuitMessage();
                }
                default -> {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands...!");
                    printMenu();
                }
            }

        }
    }

    private void checkPassword() {
        StringBuffer input = new StringBuffer("");

        System.out.println();
        System.out.println("Enter your Password: ");
        System.out.print("--> ");
        //nextLine() //used next() because the password can't contain a space
        input.append(keyboard.next());

        final Password password = new Password(input);

        System.out.println(password.calculateScore());
    }

    //send request for the password
    private void requestPassword() {
        boolean upperCaseInclude = false;
        boolean lowerCaseInclude = false;
        boolean numberInclude = false;
        boolean specialSymbolInclude = false;

        //check at least one character is present in the password
        boolean correctCharacter;
        System.out.println("Hello, welcome to the Password Generator :) answer"
        + " the following questions by Yes or No \n");

        do {
            String input;
            correctCharacter = false;

            //asking for the lower-case character
            do {
                System.out.println("Do you want Lower-case letters \" abcd..\" to be used? ");
                System.out.print("--> ");
                input = keyboard.next();
                passwordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            //when isInclude is return true means the lower-case is includes in the password
            if (isInclude(input)) {
                lowerCaseInclude = true;
            }

            //asking for the upper-case character
            do {
                System.out.println("Do you want Upper-case letters \" ABCD....\" to be used? ");
                System.out.print("--> ");
                input = keyboard.next();
                passwordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            //when isInclude is return true means the upper-case is includes in the password
            if(isInclude(input)) {
                upperCaseInclude = true;
            }

            //asking for the number character
            do {
                System.out.println("Do you want Number \" 1234.. \" to be used? ");
                System.out.print("--> ");
                input = keyboard.next();
                passwordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            //when isInclude is return true means number is includes in the password
            if (isInclude(input)) {
                numberInclude = true;
            }

            //asking for the special symbols character
            do {
                System.out.println("Do you want Special symbols \" !@#$.. \" to bo used? ");
                System.out.print("--> ");
                input = keyboard.next();
                passwordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            //when isInclude is return true means special symbols is includes in the password
            if (isInclude(input)) {
                specialSymbolInclude = true;
            }

            //check at least one answer receives by the user is "yes"
            if (!upperCaseInclude && !lowerCaseInclude && !numberInclude && !specialSymbolInclude) {
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should b Yes");
                correctCharacter = true;

            }

        } while (correctCharacter);

        System.out.println("Great! Now enter the length of the password: ");
        System.out.print("--> ");
        int lengthOfPassword = keyboard.nextInt();

        final Generator generator = new Generator(upperCaseInclude, lowerCaseInclude, numberInclude, specialSymbolInclude);
        final Password password = generator.generatePassword(lengthOfPassword);

        System.out.println("Your generated password -> " + password);
    }

    private Password generatePassword(int lengthOfPassword) {
        Random random = new Random();
        final StringBuffer password = new StringBuffer("");

        for (int i = 0; i < lengthOfPassword; i++) {
            int index = random.nextInt(0, alphabet.getPool().length());
            password.append(alphabet.getPool().charAt(index));
        }
        return new Password(password);
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Creating clear and effective password creation instructions \nis essential to help users generate strong and secure passwords.");
        System.out.println();
        System.out.println("1. Length: Specify a minimum password length.\nFor example, \"Your password must be at least 8 characters long.\"");
        System.out.println("2. Complexity: Encourage a mix of uppercase and lowercase letters, numbers, and special\ncharacters. For example, \"Include at least one uppercase letter, one lowercase letter, one number,\nand one special character (!, @, #, $, etc.).\"");
        System.out.println("3. Avoid Personal Information: Advise users not to use easily guessable information, such as\nnames, birthdays, or common words.");
        System.out.println("4. Unpredictability: Recommend avoiding easily guessable patterns or sequences. For example,\n\"Avoid using sequences like '12345' or common words like 'password'.\"");
        System.out.println("5. Unique Passwords: Emphasize the importance of creating unique passwords for different accounts.\nReusing passwords across multiple sites increases the risk if one account is\ncompromised.");
        System.out.println("6. Regular Updates: Suggest changing passwords periodically. For instance, \"Consider updating\nyour password every 3 to 6 months.\"");
        System.out.println("7. Password Managers: Encourage the use of password management tools to store and generate\ncomplex passwords securely.");
        System.out.println("8. Example: Provide an example of a strong password to guide users. For instance, \"A strong\npassword might look like 'P@ssw0rd123!'.\"");
        System.out.println();
        System.out.println("Here's an example instruction combining these points:");
        System.out.println();
        System.out.println("\"Create a strong and secure password to protect your account:");
        System.out.println();
        System.out.println("our password must be at least 8 characters long.\n" +
                "Include at least one uppercase letter, one lowercase letter, one number, and one special character (!, @, #, $, etc.).\n" +
                "Avoid using easily guessable information like names, birthdays, or common words.\n" +
                "Steer clear of predictable patterns or sequences.\n" +
                "Create a unique password for each of your accounts.\n" +
                "Consider updating your password every 3 to 6 months.\n" +
                "For example, a strong password could be 'P@ssw0rd123!'.");
        System.out.println();
        System.out.println("Thank you for prioritizing the security of your account!\"");

    }

    private boolean isInclude(String input) {
        if (input.equalsIgnoreCase("yes")) {
            return true;
        }
        else {
            return false;
        }
    }

    private void passwordRequestError(String input) {
        if(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
            System.out.println("You have entered something incorrect let's go over it again..");
        }
    }

    //the work of this method is to print the menu for the user
    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.println("Enter the Choice: ");
        System.out.print("--> ");
    }
    private void printQuitMessage() {
        System.out.println();
        System.out.println("Thanks for using our Password Generator!\nStay secure.\n" +
                "Until next time..........");
    }
}
