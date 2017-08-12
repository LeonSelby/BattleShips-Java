package com.company;

public enum Grade {
    S,
    A,
    B,
    C,
    D;

    Grade() {}

    void listOfGrades() {
        Grade[] grades = values();
        int len = grades.length;

        for(int i = 0; i < len; i++) {
            Grade listOfGrades = grades[i];
            System.out.printf("%s) \n",listOfGrades);
        }
    }
}
