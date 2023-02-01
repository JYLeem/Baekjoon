import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int [] arr = new int [20000002];

        for (int i = 0; i < N; ++i){
            int k = Integer.parseInt(st.nextToken());
            if (k < 0){
                arr[-k + 10000000]++;
            } else arr[k]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < M; ++j){
            int p = Integer.parseInt(st.nextToken());
            if (p < 0){
                sb.append(arr[-p + 10000000]).append("\n");
            } else sb.append(arr[p]).append("\n");
        }
        System.out.println(sb);
    }
}
