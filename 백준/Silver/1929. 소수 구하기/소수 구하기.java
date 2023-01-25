import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [] flag = new int[N+1];
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; ++i){
            flag[i] = i;
        }

        for (int j = 2; j <= N; ++j){
            if (flag[j] == 0){}
            for (int k = j+j; k <= N; k += j){
                flag[k] = 0;
            }
        }
        for (int z = M; z <= N; ++z){
            if (flag[z] != 0) sb.append(flag[z]).append("\n");
        }
        System.out.println(sb);
    }
}
