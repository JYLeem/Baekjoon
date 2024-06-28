import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] clothes = new int[6];
        int ans_clothes = 0;

        for (int i = 0; i < 6; i++){
            clothes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for (int i : clothes){
            if (i % T != 0){
                ans_clothes += i / T + 1;
            } else {
                ans_clothes += i / T;
            }
        }

        System.out.println(ans_clothes);
        System.out.println(N / P + " " + N % P);
    }
}
