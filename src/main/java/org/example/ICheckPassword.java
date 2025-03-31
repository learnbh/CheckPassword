package org.example;

public interface ICheckPassword {

    boolean length(int len);
    boolean containsNumber();
    boolean containsUpperAndLowerLetters();
    boolean isNotLike();
}
