import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [10001];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++){
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int j = 0; j < 10001; ++j){
            while (arr[j] > 0){
                sb.append(j).append("\n");
                arr[j]--;
            }
        }
    System.out.println(sb);
    }
}
