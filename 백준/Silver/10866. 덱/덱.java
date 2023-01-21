import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> arr = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();
            if (order.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                arr.addFirst(x);
            }
            else if (order.equals("push_back")){
                int x = Integer.parseInt(st.nextToken());
                arr.addLast(x);
            }
            else if (order.equals("pop_front")){
                if (arr.size() == 0){
                    sb.append("-1").append('\n');
                } else sb.append(arr.pollFirst()).append('\n');
            }
            else if (order.equals("pop_back")){
                if (arr.size() == 0){
                    sb.append("-1").append('\n');
                } else {
                    sb.append(arr.pollLast()).append('\n');
                }
            }
            else if (order.equals("size")){
                sb.append(arr.size()).append('\n');
            }
            else if (order.equals("empty")){
                if (arr.size() == 0){
                    sb.append("1").append('\n');
                } else sb.append("0").append('\n');
            }
            else if (order.equals("front")){
                if (arr.size() == 0){
                    sb.append("-1").append('\n');
                } else sb.append(arr.getFirst()).append('\n');

            }
            else if (order.equals("back")){
                if (arr.size() == 0){
                    sb.append("-1").append('\n');
                } else sb.append(arr.getLast()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
