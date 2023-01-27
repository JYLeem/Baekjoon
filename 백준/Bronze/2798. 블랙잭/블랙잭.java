import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int min = Integer.MAX_VALUE;

        int []arr = new int [N];
        int fin = 0;
        int ans = 0;


        for (int i = 0; i < N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int j = 0; j < N-2; ++j){
            for (int k = j+1; k < N-1 ; ++k){
                for (int z = k+1; z < N; ++z){
                    ans = arr[j] + arr[k] + arr[z];
                    if (M == ans) {fin = ans; break;}
                    else if (ans > fin && (ans < M)){
                        fin = ans;
                    }
                }
            }
        }
        System.out.println(fin);
    }
}
