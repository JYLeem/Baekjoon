import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
    static int[][] mat;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] ans;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue <Integer> ans = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        mat = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            String temp = br.readLine();
            for (int j = 0; j < N; j++){
                mat[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if ((mat[i][j] != 0) && !visited[i][j]){
                    ans.add(bfs(i, j));
                }
            }
        }
        int size = ans.size();

        System.out.println(size);

        for (int i = 0; i < size; i++){
            System.out.println(ans.poll());
        }
    }
    
    public static int bfs(int x, int y){
        int count = 1;
        Queue <Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++){
                int tempX = tmp.x + dx[i];
                int tempY = tmp.y + dy[i];

                if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < N) {
                    if (mat[tempX][tempY] == 1 && !visited[tempX][tempY]){
                        q.add(new Point(tempX, tempY));
                        visited[tempX][tempY] = true;
                        count++;
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