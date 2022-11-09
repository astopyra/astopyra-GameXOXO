package com.kodilla.gamexoxo;

import java.util.Scanner;

public class UserCommands {
    private String namePlayer1;
    private String namePlayer2;
    private int rowNumber, columnNumber;
    Scanner scan = new Scanner(System.in);



    public void nextMove() throws FieldAlreadyTakenException {
        boolean done = false;
        do {
            try {
                System.out.print("Podaj nr wiersza (0, 1 lub 2): ");
                rowNumber = Integer.parseInt(scan.nextLine());
                System.out.print("Podaj nr kolumny (0, 1 lub 2): ");
                columnNumber = Integer.parseInt(scan.nextLine());
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("Podaj cyfre 0, 1 lub 2");
            }

        } while(!done || rowNumber>2 || rowNumber<0);
    }

    public void setNames(){
        System.out.print("Player 1 podaj imie: ");
        namePlayer1 = scan.nextLine();
        System.out.print("Player 2 podaj imie: ");
        namePlayer2 = scan.nextLine();
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public String getNamePlayer1() {
        return namePlayer1;
    }

    public String getNamePlayer2() {
        return namePlayer2;
    }
}
