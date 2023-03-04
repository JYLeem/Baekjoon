import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static Deque<Integer> deq = new LinkedList<>();
    public static boolean stats = true;



    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; ++i){
            stats = true;
            boolean error = true;
            String p = br.readLine();
            int count = Integer.parseInt(br.readLine());
            deq = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            int order_num = p.length();

            for (int j = 0; j < count; ++j){
                deq.add(Integer.parseInt(st.nextToken()));
            }

            for (int k = 0; k < order_num; ++k){
                if (p.charAt(k) == 'R'){
                    stats = !stats;
                } else if (p.charAt(k) == 'D'){
                    if (!stats){
                        if (deq.pollLast() == null) {
                            sb.append("error").append("\n");
                            error = false;
                            break;
                        }
                    } else {
                        if (deq.pollFirst() == null){
                            sb.append("error").append("\n");
                            error = false;
                            break;
                        }
                    }
                }
            }
            if (error){
                answer();
            }
        }
        System.out.println(sb);
    }

    static void answer () {
        if (deq.isEmpty()){
            sb.append("[]").append("\n");
        } else {
            sb.append("[");
            int size_deq = deq.size();
            if (stats){
                for (int t = 0; t < size_deq - 1; ++t){
                    sb.append(deq.pollFirst()).append(',');
                }
            } else {
                for (int t = 0; t < size_deq - 1; ++t) {
                    sb.append(deq.pollLast()).append(',');
                }
            }
            sb.append(deq.pop()).append("]\n");
        }
    }
}


