import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[50001];
        dp[1] = 1;

        for (int z = 2; z <= N; ++z){
            dp[z] = 5;
        }

        for (int i = 2; i <= N; ++i){
            for (int j = 1; j*j <= i; ++j){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        System.out.println(dp[N]);
    }
}
