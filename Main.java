package tictactoe;

import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);

    static boolean isNumber = true;
    static boolean end = false;
    static int Xs = 0;
    static int Os = 0;

    public static void main(String[] args) {
        char[][] ticTacToe = new char[3][3];
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe.length; j++) {
                ticTacToe[i][j] = ' ';
            }
        }
        showField(ticTacToe);
        int isLastX = 0;
        while (!end) {
                System.out.print("Enter the coordinates: ");
                String v = sc.next();
                String l = sc.next();
                isNum(v);
                isNum(l);
                if (isNumber == true) {
                    int vertical = Integer.parseInt(v) - 1;
                    int level = Integer.parseInt(l) - 1;
                    if (vertical < 0 || vertical > 2 ||
                            level < 0 || level > 2) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (ticTacToe[vertical][level] == 'X' || ticTacToe[vertical][level] == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (isLastX == 0) {
                            ticTacToe[vertical][level] = 'X';
                            isLastX++;
                            Xs++;
                        } else {
                            ticTacToe[vertical][level] = 'O';
                            isLastX = 0;
                            Os++;
                        }
                        showField(ticTacToe);
                        isWins(ticTacToe);
                    }
                } else {
                    System.out.println("You should enter numbers!");
                }
            }
        }

    private static void showField(char[][] massive) {
        System.out.println("---------");
        for (int i = 0; i < massive.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < massive[i].length; j++) {
                System.out.print(massive[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void isWins(char[][] mass) {
        int sumDL = 0;
        int sumDR = 0;
        int xWin = 0;
        int oWin = 0;
        for (int i = 0; i < mass.length; i++) {
            int sumG = 0;
            int sumV = 0;
            sumDL += mass[i][i];
            sumDR += mass[mass.length - 1 - i][i];
            for (int j = 0; j < mass[i].length; j++) {
                sumG += mass[i][j];
                sumV += mass[j][i];
            }
            if (sumG == 264 || sumV == 264 || sumDL == 264 || sumDR == 264) {
                xWin = 1;
            }
            if (sumG == 237 || sumV == 237 || sumDL == 237 || sumDR == 237) {
                oWin = 1;
            }
        }
        if (xWin == 1 && oWin != 1) {
            System.out.println("X wins");
            end = true;
        } else if (oWin == 1 && xWin != 1) {
            System.out.println("O wins");
            end = true;
        }
          else if ((Math.abs(Xs - Os) > 1 || Math.abs(Os - Xs) > 1) || xWin == 1 && oWin == 1) {
            System.out.println("Impossible");
            end = true;
        } else if (Xs + Os == 9) {
            System.out.println("Draw");
            end = true;
        }
    }

    private static boolean isNum (String str) {
            try {
                Integer.parseInt(str);
            } catch (Exception e) {
                return isNumber = false;
            }
            return isNumber = true;
        }
}
