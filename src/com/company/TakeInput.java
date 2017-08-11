package com.company;

import com.company.Ships.Ship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeInput {

    static Scanner sc = new Scanner(System.in);

    //Input
    static String takeNextLine() {
        return sc.nextLine();
    }

    static int takeNextInt() {
        boolean badInput = true;
        int tmp = 0;

        while (badInput) {
            try {
                tmp = Integer.parseInt(sc.nextLine());
                badInput = false;
            } catch (InputMismatchException var3) {
                needIntPlease();
            } catch (NumberFormatException var4) {
                needIntPlease();
            }
        }
        return tmp;
    }

    static public int requestInput(String question) {
        System.out.println(question);
        int ans = takeNextInt();
        return ans;
    }

    //Questions

    static public String askIfAiGame(){
        return "Do you want to play vs the AI? 1 for Yes, 0 for No.";
    }

    static public String askForBoardSize() {
        return "How many rows and columns would you like the board to have?\n Please enter a number.";
    }

    static public String askForGuess(String colOrRow) {
        return "Which " + colOrRow + " do you want to try?";
    }

    static public String askForShipAmount() {
        return "How many ships do you want each player to have?";
    }

    static public String askForShipSize(boolean isFirst) {
        String tmp;
        if (isFirst) {
            tmp = "What size ship would you like?";
        } else {
            tmp = "What size ship would you like next?";
        }
        return tmp;
    }

    static public String askForShipSizeLast(){
        return "What size ship would you like last?";
    }

    //Statements
    static public String welcomeMessage() {
        return "Welcome to QA Battleships!";
    }

    static public String guessResponse(String hitOrMiss) {
        return "That was a " + hitOrMiss + "!";
    }

    static public String youSunk(Ship ship) {
        return "You sunk " + ship.getM_name() + "!";
    }

    static public String resultString(String p12orAI) {
        String tmp;
        if (p12orAI.equalsIgnoreCase("1")) {
            tmp = "Player one wins!";
        } else if (p12orAI.equalsIgnoreCase("2")) {
            tmp = "Player two wins!";
        } else {
            tmp = "The computer wins, better luck next time!";
        }
        return tmp;
    }

    static public String stateGrade(Grade grade) {
        String tmp;
        if (grade == Grade.S) {
            tmp = "You earned a " + grade + " ranking! That's a perfect score!";
        } else {
            tmp = "You earned a " + grade + " ranking!";
        }


        return tmp;
    }

    //Errors
    static private void needIntPlease() {
        System.out.println("We're sorry! Please input a number!");
    }
    static public void intToHigh(){
        System.out.println("We're sorry that number is too high!");
    }

}
