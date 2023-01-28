import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://st-lab.tistory.com/98    // 참고함!

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N_init = br.readLine();
        int N_len = N_init.length();

        int N = Integer.parseInt(N_init);
        int ans = 0;


        for (int i = (N - (N_len * 9)); i < N; ++i){
                int num = i;
                int sum = 0;

                while (num != 0){
                    sum += num % 10;
                    num /= 10;
                }

                if (sum + i == N){
                    ans = i;
                    break;
                }
        }
        System.out.println(ans);
    }
}
