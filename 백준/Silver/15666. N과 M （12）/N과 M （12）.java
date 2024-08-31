import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); 
        backTracking(N, M, 0, 0);
    }

    private static void backTracking(int N, int M, int depth, int start){
        if (M == depth){
            for (int i = 0; i < M; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        int last = 0;
        for (int i = start; i < N; i++){
            if (last != arr[i]) { 
                ans[depth] = arr[i];
                last = arr[i];
                backTracking(N, M, depth + 1, i);
            }
        }
    }
}
