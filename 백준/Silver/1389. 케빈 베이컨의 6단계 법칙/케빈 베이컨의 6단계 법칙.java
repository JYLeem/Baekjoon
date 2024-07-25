import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] mat;
    static boolean[][] visited;
    static final int MAX = 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        mat = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                mat[i][j] = MAX;
                if (i == j) mat[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            mat[x][y] = 1;
            mat[y][x] = 1;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                    mat[j][k] = Math.min(mat[j][k], mat[j][i]+mat[i][k]);
                }
            }
        }

        int temp = MAX;
        int ans = 0;

        for (int i = 0; i < N; i++){
            int total = 0;
            for (int j = 0; j < N; j++){
                total += mat[i][j];
            }

            if (temp > total){
                temp = total;
                ans = i;
            }
        }

        System.out.println(ans + 1);

    }
}
