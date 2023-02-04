import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int j = 1;
        Stack<Integer> arr= new Stack<>();
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        boolean flag = true;
        int max = 0;

        for (int i = 1; i <= N; ++i){
            int k = Integer.parseInt(br.readLine());
            while (true) {
                if (k  > temp && k > max){
                    arr.push(j);
                    sb.append("+").append("\n");
                    if (j == k) {++j; arr.pop(); sb.append("-").append("\n"); break;}
                    ++j;
                }
                else {
                    if (!arr.contains(k)) {flag = false; break; }
                    else if (arr.peek() != k) {arr.pop(); sb.append("-").append("\n");}
                    else if (arr.peek() == k){arr.pop(); sb.append("-").append("\n"); break;}
                }
            }
            temp = k;
            if (max < k) {max = k;}
        }
        if (flag) System.out.println(sb);
        else System.out.println("NO");
    }
}
