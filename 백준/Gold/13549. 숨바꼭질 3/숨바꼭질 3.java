import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[100001];
        visited = new boolean[100001];

        System.out.println(bfs(N, K));
    }

    private static int bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()){
            int current = q.poll();

            if (current == end) {
                return map[current];
            }

            // 순간이동 (2배)
            if (current * 2 <= 100000 && !visited[current * 2]) {
                q.add(current * 2);
                visited[current * 2] = true;
                map[current * 2] = map[current];
            }

            // -1 이동
            if (current - 1 >= 0 && !visited[current - 1]) {
                q.add(current - 1);
                visited[current - 1] = true;
                map[current - 1] = map[current] + 1;
            }

            // +1 이동
            if (current + 1 <= 100000 && !visited[current + 1]) {
                q.add(current + 1);
                visited[current + 1] = true;
                map[current + 1] = map[current] + 1;
            }
        }
        return -1;
    }
}
