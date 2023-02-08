import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> arr = new Stack<>();
        int ans = 0;

        for (int i = 0; i < N; ++i){
            int K = Integer.parseInt(br.readLine());
            if (K == 0){
                arr.pop();
            } else {
                arr.add(K);
            }
        }
        for (int j = 0; j < arr.size(); ++j){
            ans += arr.get(j);
        }

        System.out.println(ans);
    }
}
