package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CheckPassword checkFalse = new CheckPassword("assword");
        CheckPassword checkTrue = new CheckPassword("ass!word");
        checkFalse.containsSpecialCaracters();
        checkTrue.containsSpecialCaracters();
    }

}