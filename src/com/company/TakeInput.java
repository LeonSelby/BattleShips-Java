package com.company;

import com.company.Ships.Ship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeInput {

    Scanner sc = new Scanner(System.in);

    //Input
    String takeNextLine() {
        return sc.nextLine();
    }

    int takeNextInt() {
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

    public int requestInput(String question) {
        System.out.println(question);
        int ans = takeNextInt();
        return ans;
    }

    //Questions

    public String askForBoardSize() {
        return "How many rows and columns could you like the board to have?\n Please enter a number.";
    }

    public String askForGuess(String colOrRow) {
        return "Which " + colOrRow + " do you want to try?";
    }

    public String askForShipAmount() {
        return "How many ships do you want each player to have?";
    }

    public String askForShipSize(boolean isFirst) {
        String tmp;
        if (isFirst) {
            tmp = "What size ship would you like?";
        } else {
            tmp = "What size ship would you like next?";
        }
        return tmp;
    }

    //Statements

    public String welcomeMessage() {
        return "Welcome to QA Battleships!";
    }

    public String guessResponse(String hitOrMiss) {
        return "That was a " + hitOrMiss + "!";
    }

    public String youSunk(Ship ship) {
        return "You sunk " + ship.getM_name() + "!";
    }

    public String resultString(String p12orAI) {
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

    public String stateGrade(Grade grade) {
        String tmp;
        if (grade == Grade.S) {
            tmp = "You earned a " + grade + " ranking! That's a perfect score!";
        } else {
            tmp = "You earned a " + grade + " ranking!";
        }


        return tmp;
    }

    //Errors
    private void needIntPlease() {
        System.out.println("We're sorry! Please input a number!");
    }
}
