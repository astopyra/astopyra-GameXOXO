package com.kodilla.gamexoxo;

import java.util.Scanner;

public class NextMove {

    private int rowNumber, columnNumber;
    Scanner scanner = new Scanner(System.in);

    public void loadNextMove(Player player) throws FieldAlreadyTakenException {
        boolean done = false;
        do {
            try {
                System.out.print(player.getName() + " podaj nr wiersza (0, 1 lub 2): ");
                rowNumber = Integer.parseInt(scanner.nextLine());
                System.out.print(player.getName() + " podaj nr kolumny (0, 1 lub 2): ");
                columnNumber = Integer.parseInt(scanner.nextLine());
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("Podaj cyfre 0, 1 lub 2");
            }

        } while(!done || rowNumber>2 || rowNumber<0);
    }



    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}
