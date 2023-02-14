import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> DQ = new LinkedList<>();

        for (int i = 1; i <= N; ++i){
            DQ.add(i);
        }

        while (true){
            if (DQ.size() == 1) break;
            DQ.pop();
            DQ.addLast(DQ.pop());
        }
        System.out.println(DQ.getFirst());
    }
}
