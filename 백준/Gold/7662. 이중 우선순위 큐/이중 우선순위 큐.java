import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();
            int size = 0;

            int Q = Integer.parseInt(br.readLine());

            for (int k = 0; k < Q; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    minHeap.add(num);
                    maxHeap.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    size++;
                } else if (order.equals("D")) {
                    if (size == 0) {
                        continue;
                    }
                    if (num == 1) {
                        while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
                            maxHeap.poll();
                        }
                        if (!maxHeap.isEmpty()) {
                            int max = maxHeap.poll();
                            map.put(max, map.get(max) - 1);
                            size--;
                        }
                    } else {
                        while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
                            minHeap.poll();
                        }
                        if (!minHeap.isEmpty()) {
                            int min = minHeap.poll();
                            map.put(min, map.get(min) - 1);
                            size--;
                        }
                    }
                }
            }

            while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
                minHeap.poll();
            }

            if (size == 0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
