import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] mat;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(i, j, mat[i][j], 1);
                visited[i][j] = false;
                // ㅗ 모양을 위한 추가 검사
                checkOtherShapes(i, j);
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int x, int y, int sum, int count) {
        // 네 개의 칸을 채우면 최대값을 갱신하고 종료
        if (count == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fx < 0 || fx >= N || fy < 0 || fy >= M) {
                continue;
            }

            if (!visited[fx][fy]) {
                visited[fx][fy] = true;
                dfs(fx, fy, sum + mat[fx][fy], count + 1);
                visited[fx][fy] = false;
            }
        }
    }

    // ㅗ, ㅜ, ㅓ, ㅏ 모양을 체크하기 위한 함수
    public static void checkOtherShapes(int x, int y) {
        if (x >= 0 && x < N - 2 && y >= 0 && y < M - 1) {
            int sum = mat[x][y] + mat[x + 1][y] + mat[x + 2][y] + mat[x + 1][y + 1];
            ans = Math.max(ans, sum);
        }
        if (x >= 0 && x < N - 2 && y >= 1 && y < M) {
            int sum = mat[x][y] + mat[x + 1][y] + mat[x + 2][y] + mat[x + 1][y - 1];
            ans = Math.max(ans, sum);
        }
        if (x >= 1 && x < N && y >= 0 && y < M - 2) {
            int sum = mat[x][y] + mat[x][y + 1] + mat[x][y + 2] + mat[x - 1][y + 1];
            ans = Math.max(ans, sum);
        }
        if (x >= 0 && x < N - 1 && y >= 0 && y < M - 2) {
            int sum = mat[x][y] + mat[x][y + 1] + mat[x][y + 2] + mat[x + 1][y + 1];
            ans = Math.max(ans, sum);
        }
    }
}
