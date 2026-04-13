import java.util.Scanner;

public class tick_tock_no {

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

        System.out.println("You are playing X.");
        System.out.print("What spot would you like to place it? ");

        Scanner user = new Scanner(System.in);

        char no = user.next().charAt(0);

        user.close();

        return no;

    }

    public static void place(char[][] board, char place) {

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (board[i][j] == place) {
                    board [i][j] = 'X';
                }
            }

        }

    }

    public static void main(String[] args) {
        char[][] board = {
            {'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}
        };

        printBoard(board);

        place(board, game_loop());

        printBoard(board);
    }
    
}