package com.PasswordGenerator;

public class Alphabet {
    //stored all the upper case letters
    public static final String upperCaseLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
    //stored all the lower case letters
    public static final String lowerCaseLetters = "qwertyuiopasdfghjklzxcvbnm";
    //stored all the number start from the 0 to 9
    public static final String number = "0123456789";
    //stored all the special symbols
    public static final String specialSymbols = "!@#$%^&*()-_=+\\/~?";

    //add all the values
    private static StringBuffer pool = new StringBuffer("");

    public Alphabet(boolean upperCaseInclude, boolean lowerCaseInclude, boolean numberInclude, boolean specialSymbolInclude) {
        //when the user want to add the upper case later in the password
        if (upperCaseInclude) pool.append(upperCaseLetters);

        //when the user want to add the lower case later in the password
        if (lowerCaseInclude) pool.append(lowerCaseLetters);

        //when the user want to add the number in the password
        if (numberInclude) pool.append(number);

        //when the user want to add the special symbols in the password
        if (specialSymbolInclude) pool.append(specialSymbols);
    }

    public String getPool() {
        //convert the StringBuffer object into the String object
        return pool.toString();
    }
}
