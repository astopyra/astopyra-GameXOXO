package com.kodilla.gamexoxo;

import java.util.Scanner;

public class NextMove {

    private int rowNumber, columnNumber;
    Scanner scanner = new Scanner(System.in);

    public void loadNextMove(GameVersion version) throws FieldAlreadyTakenException {
        boolean done = false;
        do {
            try {
                System.out.print("Podaj nr wiersza (0-" + (version.getBoardSize()-1) + "): ");
                rowNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Podaj nr kolumny (0-" + (version.getBoardSize()-1) + "): ");
                columnNumber = Integer.parseInt(scanner.nextLine());
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("Podaj cyfre 0-" + version.getBoardSize());
            }

        } while(!done || rowNumber> version.getBoardSize()-1 || rowNumber<0);
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
