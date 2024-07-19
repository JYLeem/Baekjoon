import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] mat;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<>();
    static int M;
    static int N;
    static int H;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        mat = new int[N][M][H];
        visited = new boolean[N][M][H];

        for (int i = 0; i < H; i++){
            for (int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++){
                    mat[j][k][i] = Integer.parseInt(st.nextToken());
                    if (mat[j][k][i] == -1){
                        visited[j][k][i] = true;
                        count++;
                    }
                    else if (mat[j][k][i] == 1){
                        visited[j][k][i] = true;
                        q.add(new Point(j, k, i));
                        count++;
                    }
                }
            }
        }
        
        int finalAns = bfs();

        if (count == M * N * H){
            System.out.println(finalAns);
        } 
        else {
            System.out.println(-1);
        }

    }

    public static int bfs(){
        int ans = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++){
                Point temp = q.poll();
                for (int i = 0; i < 6; i++){
                    int fx = temp.x + dx[i];
                    int fy = temp.y + dy[i];
                    int fz = temp.z + dz[i];
    
                    if (fx >= 0 && fx < N && fy >= 0 && fy < M && fz >= 0 && fz < H){
                        if (mat[fx][fy][fz] == 0 && !visited[fx][fy][fz]){
                            visited[fx][fy][fz] = true;
                            q.add(new Point(fx, fy, fz));
                            count++;
                        }
                    }
                }
            }
            ans++;
        }
        return ans;
    }

    static class Point {
        int x;
        int y;
        int z;
    
        public Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
