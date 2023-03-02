import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        System.out.println(fibonacci(N));
    }

    static int fibonacci(int N){
        if (N == 1) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if (dp[N] > 0) return dp[N];
        if (N > 2) {
            dp[N] = (fibonacci(N - 1) + fibonacci(N - 2)) % 10007;
        }
        return dp[N];
    }
}
