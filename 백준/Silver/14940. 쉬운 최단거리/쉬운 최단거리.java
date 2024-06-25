import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] bfs;
    static boolean[][] visited;
    static int[][] ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bfs = new int[N][M];
        visited = new boolean[N][M];
        ans = new int[N][M];
        int x = 0, y = 0;

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++){
                bfs[i][j] = Integer.parseInt(st.nextToken());

                if (bfs[i][j] == 2){
                    x = i;
                    y = j;
                }
                else if (bfs[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        }

        bfs(x,y, N, M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    ans[i][j] = -1;
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void bfs(int x, int y, int N, int M){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()){
            int tmp[] = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && bfs[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        ans[nx][ny] = ans[tmp[0]][tmp[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
