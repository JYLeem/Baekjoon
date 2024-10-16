import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Long[] ans = new Long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ans[0] = 0L;
        ans[1] = 1L;
        ans[2] = 1L;
        ans[3] = 1L;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            sb.append(dp(Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.println(sb);
    }

    private static long dp(int N){
        if (ans[N] == null){
            ans[N] = dp(N-2) + dp(N-3);
        }

        return ans[N];
    }
}
