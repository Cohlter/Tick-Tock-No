import java.util.Scanner;

public class tick_tock_no {

    public static boolean win = false;

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

    public static char game_loop() {

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

        return no;

    }

    public static void place(char[][] board, char place) {

        if (win == true) {
            return;
        }

        // player

        int rows = board.length;
        int cols = board[0].length;

        // int enemy = -1;

        // while (enemy <= 0) 
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (board[i][j] == place) {
                    board [i][j] = 'X';
                }
            }

        }

        // enemy

        int value = (int) Math.round(Math.random()*10);
        char enemy = Integer.toString(value).charAt(0);

        System.out.println(enemy);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (board[i][j] == enemy) {
                    board [i][j] = 'O';
                }
            }

        }

    }

    public static void check_winner(char[][] board){

        if (board[0][0] == board [0][1] &&  board [0][1] == board [0][2]) {
            win = true;
        }

    }

    public static void main(String[] args) {
        char[][] board = {
            {'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}
        };

        while (win == false) {

            printBoard(board);

            check_winner(board);

            place(board, game_loop());

        }

        System.out.println("You win!");

    }
    
}