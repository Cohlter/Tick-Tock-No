public class tick_tock_no {

    
    
}

public static void main(String[] args) {
    int rows = 3;
    int cols = 3;
    int[][] nine = new int[rows][cols];
    int value = 0;

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            value++;
            nine[i][j] = value;
            System.out.println(nine[i][j]);
        }
    }

}