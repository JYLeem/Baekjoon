import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Divide and conquer로 하자.

    탈출 조건: n x n 이 모두 0 || 1 일 때 탈출
    Divide: 4등분 후 계속 N/2 로 쪼갠다.
    예외 처리: null

*/

public class Main {
    static int[][] matrix;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++){
            String temp = br.readLine();
            String[] s = temp.split("\\s+");
            for (int k = 0; k < N; k++){
                matrix[i][k] = Integer.parseInt(s[k]);
            }
        }

        part(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
    public static void part (int x, int y, int size){
        if (colorCheck(x, y, size)){
            if (matrix[x][y] == 1){
                blue++;
            } else white++;
            return;
        }
        int temp = size/2;

        part(x, y, temp);
        part(x, y+temp, temp);
        part(x + temp, y, temp);
        part(x+temp, y+temp, temp);
    }

    public static boolean colorCheck(int x, int y, int size){
        int temp = matrix[x][y];

        for (int i = x; i < x + size; i++){
            for (int k = y; k < y + size; k++){
                if (matrix[i][k] != temp){
                    return false;
                }
            }
        }

        return true;
    }
}
