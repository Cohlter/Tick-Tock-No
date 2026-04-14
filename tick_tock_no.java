import java.util.Scanner;

public class tick_tock_no {

    public static boolean win = false;

    // public static char[] filed;

    //print board

    public static void printBoard(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(" " + board[i][j]);
            }
            System.out.println("");
        }

    }

    // gets the player's input

    public static char player_spot() {

        if (win == true) {
            return 'Z';
        }

        System.out.println("You are playing X.");
        System.out.print("What spot would you like to place it? ");

        Scanner user = new Scanner(System.in);

        char no = user.next().charAt(0);

        if (win == true) {
            user.close();
        }

        // filed.

        return no;

    }

    // gets the enemy's spot

    public static char enemy_spot(char[][] board) {

        int value = (int) Math.round(Math.random()*10);
        char enemy = Integer.toString(value).charAt(0);
        return enemy;

    }

    // places the player's and enemy's spots in the array


    public static void place(char[][] board, char spot, int turn) {

        if (win == true) {
            return;
        }

        char marker;
        if (turn % 2 != 0) {
            marker = 'X';
        } else {
            marker = 'O';
        }

        int rows = board.length;
        int cols = board[0].length;


        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (board[i][j] == spot) {
                    board [i][j] = marker;
                }
            }

        }

    }

    // 

    public static void check_winner(char[][] board){

        if (board[0][0] == board [0][1] &&  board [0][1] == board [0][2]) { // rows
            win = true;
        } else if (board[1][0] == board [1][1] &&  board [1][1] == board [1][2]) {
            win = true;
        } else if (board[2][0] == board [2][1] &&  board [2][1] == board [2][2]) {
            win = true;
        } else if (board[0][0] == board [1][0] &&  board [1][0] == board [2][0]) { // columns
            win = true;
        } else if (board[0][1] == board [1][1] &&  board [1][1] == board [2][1]) {
            win = true;
        } else if (board[0][2] == board [1][2] &&  board [1][2] == board [2][2]) {
            win = true;
        } else if (board[0][0] == board [1][1] &&  board [1][1] == board [2][2]) { // diagonals
            win = true;
        } else if (board[0][2] == board [1][1] &&  board [1][1] == board [2][0]) {
            win = true;
        }

    }

    public static void main(String[] args) {
        char[][] board = {
            {'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}
        };

        int turn = 0;

        while (win == false) {

            printBoard(board);

            check_winner(board);

            turn++;
            place(board, player_spot(), turn);

            turn++;
            place(board, enemy_spot(board), turn);
        }

        System.out.println("You win!");

    }
    
}