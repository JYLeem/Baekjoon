import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] board = new int[101];
    static int[] visited = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 101; i++){
            board[i] = i;
        }

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    private static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 0;

        while (true) {
            int temp = q.poll();

            for (int i = 1; i < 7; i++){
                int newNode = temp + i;

                if (newNode > 100) continue;

                if (visited[board[newNode]]== 0){
                    q.offer(board[newNode]);
                    visited[board[newNode]] = visited[temp]+1;
                } 

                if (board[newNode] == 100) {
                    return visited[100];
                }
            }
        }
    }
}
