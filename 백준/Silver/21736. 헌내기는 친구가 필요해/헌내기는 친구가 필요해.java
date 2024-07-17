import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static char[][] mat;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<>();
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            String tmp = br.readLine();
            for (int j = 0; j < M; j++){
                mat[i][j] = tmp.charAt(j);
                if (mat[i][j] == 'X'){
                    visited[i][j] = true;
                }
                if (mat[i][j] == 'I'){
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        int ans = bfs();
        if (ans == 0){
            System.out.println("TT");
        }
        else {
            System.out.println(ans);
        }
    }

    public static int bfs(){
        int count = 0;

        while (!q.isEmpty()) {
            Point temp = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if (!visited[nx][ny]){
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        if (mat[nx][ny] == 'P'){
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}