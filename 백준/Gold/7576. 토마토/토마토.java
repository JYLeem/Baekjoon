import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static Queue <Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1){
                    visited[i][j] = true;
                }
                else if (graph[i][j] == 1){
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Point tmp = queue.poll();
                for (int j = 0; j < 4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < N && ny < M && ny >= 0){
                        if(!visited[nx][ny] && graph[nx][ny] == 0){
                            visited[nx][ny] = true;
                            graph[nx][ny] = 1;
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
            }
            if (!queue.isEmpty()) ans++;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (graph[i][j] == 0 ){
                    return -1;
                }
            }
        }

        return ans;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
