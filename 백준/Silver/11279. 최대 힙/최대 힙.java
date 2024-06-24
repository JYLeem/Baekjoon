import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> ans = new LinkedList<>();

        for (int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0){
                if (heap.isEmpty()) ans.add(0);
                else ans.add(heap.poll());
            } else {
                heap.add(tmp);
            }
        }
        for (int val : ans){
            System.out.println(val);
        }
    }
}
