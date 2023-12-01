# Password_Generator
This project is a Java Console Application to generate random passwords and perform password strength checks.

## Introduction
I decided to build this project during the Winter Break of my second year after taking the Object-Oriented Effective Java Programming course.
I wanted to build something interesting with Java to practice and see what I could do on my own.
I got the idea of creating a random password generator.

While working on it, I decided to include a password strength checker feature that checks the overall strength of the entered password. 
I was pretty happy with how it turned out, but I realized that it was not very straightforward to use for someone who does not know how 
it is supposed to work. So, I decided to create a GUI for the application for the next step.

## Functionalites

##1: Generating a password:

-The generator asking "Yes" or "No" type of questions for the upper-case , lower-case, number, special symbols are added in the password.
-Also it is asking for the password length because some are enter specific length of the password
-The Alphabet class is used to the generating a string based on the user's answers, which is a string 
containing the shisen character.
-The randomly pick the character form the string this string return by the Alpabet. The randomly pick the character
is the possible for Random built-in class in the java.
-The randomly generated password is displayed on the console.

##2: Checking the password Strength
-First take input by the user.
-The strength check is based on the following conditions:
-The password uses upper-case letters.
-The password uses lower-case letters.
-The password uses number letters.
-The password uses special symbols letters.
-The length of the password is 8 or more then and less then the 16.(8 <= password >= 16)
-Each condition contains one marks 
-The strength is dependents on the how many conditions are passes.

##3 : Displaying Useful Information:

This is a minor feature that displays information for the user on the console about password making 
techniques and password security.

##4 : Quite

This feature simple meaning is the password generator is turn off..... 
