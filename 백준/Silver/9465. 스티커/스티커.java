import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int T = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][T];
            int[][] dp = new int[2][T];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < T; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if (T > 1) {
                dp[0][1] = arr[0][1] + dp[1][0];
                dp[1][1] = arr[1][1] + dp[0][0];
            }

            for (int k = 2; k < T; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + arr[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + arr[1][k];
            }

            System.out.println(Math.max(dp[0][T - 1], dp[1][T - 1]));
        }
    }
}