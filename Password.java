package com.PasswordGenerator;

public class Password {
    StringBuffer value;
    int length;
    public Password(StringBuffer password) {
        value = password;
        length = password.length();
    }
    //it used to print the object of the Password class
    @Override
    public String toString() {
        return value.toString();
    }

    public String calculateScore() {
        int  score = this.passwordStrength();

        //rank-1 password
        if(score == 6) return "Unlock the power of a top-notch password! Check out the Useful Information section to ensure it not only meets but exceeds all the guidelines!";
        //rank-2 password
        else if (score >= 4) return "While your password is good, let's aim for even greater strength. Let's make it unbreakable!";
        //rank-3 password
        else if (score >= 3) return "Your password is okay, but we're aiming for excellence. Let's level up together!";
        //rank-3 password
        else return "Time for a security upgrade! Your password might be weak, but we're here to help you find a fortress of protection. Let's create something robust together!";


    }

    private int passwordStrength() {
        StringBuffer passwordStr = this.value;

        boolean usedUpperCase = false;
        boolean usedLowerCase = false;
        boolean usedNumber = false;
        boolean usedSpecialSymbols = false;

        //characterType//1->upper-case//2->lower-case//3->number//4->special-symbols
        int characterType;
        int score = 0;

        for(int i = 0; i < passwordStr.length(); i++) {
            char currentCharacter = passwordStr.charAt(i);
            characterType = this.findCharacterType(currentCharacter);

            if(characterType == 1) usedUpperCase = true;

            if (characterType == 2) usedLowerCase = true;

            if (characterType == 3) usedNumber = true;

            if (characterType == 4) usedSpecialSymbols = true;
        }

        if (usedUpperCase) score += 1;

        if (usedLowerCase) score += 1;

        if (usedNumber) score += 1;

        if(passwordStr.length() >= 8) score += 1;

        if (passwordStr.length() >= 16) score += 1;

        return score;
    }

    private int findCharacterType(char currentCharacter) {
        int CharacterType;

        //character is Upper-case Letter //A-Z //65-90
        if ((int)currentCharacter >= 65 && (int)currentCharacter <= 90) {
            CharacterType = 1;
        }

        //character is Lower-case Letter //a-b //97-122
        else if((int)currentCharacter >= 97 && (int)currentCharacter <= 122) {
            CharacterType = 2;
        }

        //character is number //0-9 //48 – 57
        else if ((int)currentCharacter >= 48 && (int)currentCharacter <= 57) {
            CharacterType = 3;
        }

        //character is special symbols
        else {
            CharacterType = 4;
        }
        return CharacterType;
    }
}
