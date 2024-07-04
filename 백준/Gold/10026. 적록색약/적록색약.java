import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] mat;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        mat = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            String temp = br.readLine();
            for (int j = 0; j < N; j++){
                mat[i][j] = temp.charAt(j);
            }
        }

        int normal = countRegions();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(mat[i][j] == 'R'){
                    mat[i][j] = 'G';
                }
            }
        }
        visited = new boolean[N][N];

        int dis = countRegions();

        System.out.println(normal + " " + dis);
    }

    private static int countRegions() {
        int regions = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    norm(i, j);
                    regions++;
                }
            }
        }

        return regions;
    }

    private static void norm(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x,y));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++){
                Point tmp = q.poll();
                visited[tmp.x][tmp.y] = true;
                char prev = mat[tmp.x][tmp.y];

                for (int j = 0; j < 4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if(!visited[nx][ny] && mat[nx][ny] == prev){
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
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
