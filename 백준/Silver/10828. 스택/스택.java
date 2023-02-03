import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> arr = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            switch (cmd) {
                case "push" :
                    arr.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (arr.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    } else {
                        sb.append(arr.pop()).append("\n");
                        break;
                    }
                case "size":
                    sb.append(arr.size()).append("\n");
                    break;
                case "empty":
                    if (arr.isEmpty()){
                        sb.append(1).append("\n");
                        break;
                    } else {
                        sb.append(0).append("\n");
                        break;
                    }
                case "top":
                    if (arr.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    } else {
                        sb.append(arr.peek()).append("\n");
                        break;
                    }
            }
        }
        System.out.println(sb);
    }
}
