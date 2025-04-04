package org.example;

import java.util.Random;
import java.util.regex.Pattern;

public class CheckPassword implements ICheckPassword{

    private String password;
    public String[] forbiddenPasswords = {"Password1", "Pa2345678", "Pa654321", "passWort1", "1Abcdefgh", "1Hgfedcba"};


    public CheckPassword() {
        this.generatePassword();
    }

    public CheckPassword(String password) {
        this.setPassword(password);
    }

    @Override
    public boolean containsNumber() {
        Pattern pattern = Pattern.compile("[0-9]+");
        return (pattern.matcher(this.getPassword()).find());
    }

    @Override
    public boolean length(int len) {
        return getPassword().length() >= len;
    }
    public boolean containsUpperAndLowerLetters() {
        Pattern pattern = Pattern.compile("[A-Z]+[a-z]+");
        return (pattern.matcher(this.getPassword()).find());
    }

    @Override
    public boolean isNotLike() {
        for(String p : forbiddenPasswords){
            if(this.getPassword().equals(p)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsSpecialCaracters() {
        char[] specialCaracters = this.getPassword().toCharArray();
        for(char c : specialCaracters){
            if(!Character.isLetterOrDigit(c)){
                return true;
            }
        }
        return false;
    }

    public String generatePassword() {
        int length = (int)(Math.random()+8);
        int random;
        char[] letters = new char[length];
        boolean correctPassword = false;
        while(!correctPassword) {
            for (int i = 0; i < length; i++) {
                random = new Random().nextInt(94) + 32;
                letters[i] = (char) random;
            }
            this.setPassword(new String(letters));
            if (this.containsSpecialCaracters() &&
                    this.containsNumber() &&
                    this.containsUpperAndLowerLetters() &&
                    this.isNotLike()&&
                    this.length(8)
            ) {
                correctPassword = true;
            }
        }
        return this.getPassword();
    }

    // Getter and Setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
