import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        mat = new int[N][3];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++){
            mat[i][0] += Math.min(mat[i-1][1], mat[i-1][2]);
            mat[i][1] += Math.min(mat[i-1][0], mat[i-1][2]);
            mat[i][2] += Math.min(mat[i-1][0], mat[i-1][1]);
        }

        System.out.println( Math.min( Math.min(mat[N-1][0], mat[N-1][1]), mat[N-1][2] ));
    }
}
