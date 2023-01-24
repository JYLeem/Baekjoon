import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i =0; i < T; ++i){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int [][] apt = new int[k+1][n];

            for (int j = 0; j <= k; ++j){
                int ppl = 0;
                for (int x = 0; x < n; ++x){
                    if (j == 0){
                        apt[j][x] = x + 1;
                    }
                    else {
                        ppl += apt[j-1][x];
                        apt[j][x] = ppl;
                    }
                }
            }
            sb.append(apt[k][n-1]).append("\n");
        }
        System.out.println(sb);
    }
}
