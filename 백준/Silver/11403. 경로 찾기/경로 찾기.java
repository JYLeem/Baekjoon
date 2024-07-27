import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] mat;
    static int MAX = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
                if (i == j) mat[i][j] = 0;
            }
        }
        
        for (int k = 0; k < N; k++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(mat[i][k] == 1 && mat[k][j] == 1) mat[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }


    }
}
