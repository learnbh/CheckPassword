package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPasswordTest {

    String passwordEqual;
    String passwordWrong1;
    String passwordCorrect;

    @BeforeEach
    void setUp() {
        passwordEqual = "Password1";
        passwordWrong1 = "assword";
        passwordCorrect = "Wort8_Pass";
    }

    @Test
    void length_Value_Wort81Pass_shouldReturnTrue_forExpectedLength8(){
        assertTrue(new CheckPassword(passwordCorrect).length(8));
    }
    @Test
    void length_Value_assword_shouldReturnFalse_forExpectedLength8() {
        assertFalse(new CheckPassword(passwordWrong1).length(8));
    }

    @Test
    void containsNumber_shouldReturnTrue_forWord_Password1() {
        assertTrue(new CheckPassword(passwordEqual).containsNumber());
    }

    @Test
    void containsNumber_shouldReturnFalse_forWord_assword() {
        assertFalse(new CheckPassword(passwordWrong1).containsNumber());
    }

    @Test
    void containsUpperAndLowerLetters_ShouldReturnTrue_forWord_Password1() {
        assertTrue(new CheckPassword(passwordEqual).containsUpperAndLowerLetters());
    }

    @Test
    void containsUpperAndLowerLetters_ShouldReturnFalse_forWord_assword() {
        assertFalse(new CheckPassword(passwordWrong1).containsUpperAndLowerLetters());
    }
    @Test
    void containsUpperAndLowerLetters_ShouldReturnFalse_forWord_PASSWORD1() {
        assertFalse(new CheckPassword("PASSWORD1").containsUpperAndLowerLetters());
    }

    @Test
    void isNotLike_ShouldReturnTrue_forWord_Password1() {
        assertTrue(new CheckPassword(passwordWrong1).isNotLike());
    }
    @Test
    void isNotLike_ShouldReturnFalse_forWord_Password1() {
        assertFalse(new CheckPassword(passwordEqual).isNotLike());
    }

    @Test
    void containsSpecialCaracters_ShouldReturnTrue_forWord_Wort8_Pass() {
        assertTrue(new CheckPassword(passwordCorrect).containsSpecialCaracters());
    }
    @Test
    void containsSpecialCaracters_ShouldReturnFalse_forWord_assword() {
        assertFalse(new CheckPassword(passwordWrong1).containsSpecialCaracters());
    }
}