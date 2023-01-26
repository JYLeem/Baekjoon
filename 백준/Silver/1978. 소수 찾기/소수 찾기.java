import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i){
            int s = Integer.parseInt(st.nextToken());
            boolean flag = true;
            if (s == 2) {count++; continue;}
            else if (s == 1) {
                flag = false;
            }
            else {
                for (int j = 2; j < s; ++j){
                    if (s % j == 0) flag = false;
                }
                if (flag) count++;
            }
        }
        System.out.println(count);
    }
}
