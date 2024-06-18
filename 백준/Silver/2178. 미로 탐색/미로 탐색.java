import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] mat;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        String[] dimensions = temp.split(" ");
        N = Integer.parseInt(dimensions[0]);
        M = Integer.parseInt(dimensions[1]);

        mat = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                mat[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        bfs(0, 0);
        System.out.println(mat[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point currentPoint = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (mat[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;

                q.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;

                mat[nextX][nextY] = mat[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
}
