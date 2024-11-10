package DAA;
import java.util.*;
public class A6 {
    static Scanner sc = new Scanner(System.in);
    public static void printArr(char[][] arr) {
        System.out.println("\n---------------Chess Board---------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void takeInput(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'x';
            }
        }
    }
    public static boolean nQueens(char Board[][], int i) {
        if(i == Board.length) {
            return true;
        }
        for (int j = 0; j < Board[0].length; j++) {
            if(QueenIsSafe(Board, i, j)) {
                Board[i][j] = 'Q';
                if(nQueens(Board, i+1)) {
                    return true;
                }
                Board[i][j] = 'x';
            }
        }
        return false;
    }
    public static boolean QueenIsSafe(char Board[][], int i, int j) {
        for (int k = 0; k < i; k++) {
            if(Board[k][j] == 'Q') {
                return false;
            }
            if(Board[k][j] == 'Q' && k != j) {
                return false;
            }
        }
        int row = i, col = j;
        while (row > -1 && col > -1) {
            if(Board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        row = i; col = j;
        while (row > -1 && col < Board[0].length) {
            if(Board[row][col] == 'Q') {
                return false;
            }
            row--;
            col++;
        }
        row = i; col = j;
        while (row < Board.length && col > -1) {
            if(Board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        row = i; col = j;
        while (row < Board.length && col < Board[0].length) {
            if(Board[row][col] == 'Q') {
                return false;
            }
            row++;
            col++;
        }
        return true;
    }
    public static void main(String []args) {
        System.out.println();
        System.out.print("\nEnter the value of n : ");
        int n = sc.nextInt();
        char Board[][] = new char[n][n];
        takeInput(Board);
        printArr(Board);
        System.out.println("At which position you want to place the First Queen : ");
        int choice = sc.nextInt();
        Board[0][choice] = 'Q';
        if(nQueens(Board, 1)) {
            printArr(Board);
        } else {
            System.out.println("No possible solution exists.");
        }
    }
}