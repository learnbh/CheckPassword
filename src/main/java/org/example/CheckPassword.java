package org.example;

import java.util.regex.Pattern;

public class CheckPassword implements ICheckPassword{

    private String password;
    public String[] forbiddenPasswords = {"Password1", "Pa2345678", "Pa654321", "passWort1", "1Abcdefgh", "1Hgfedcba"};

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


// Getter and Setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
