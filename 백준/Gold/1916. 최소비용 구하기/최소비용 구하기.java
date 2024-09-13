import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine()); 

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curCity = current.city;
            int curCost = current.cost;

            if (curCost > dist[curCity]) continue; 

            for (Node neighbor : graph.get(curCity)) {
                int nextCity = neighbor.city;
                int nextCost = curCost + neighbor.cost;

                if (nextCost < dist[nextCity]) {
                    dist[nextCity] = nextCost;
                    pq.add(new Node(nextCity, nextCost));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
