import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br_count = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br_count.readLine());

         StringTokenizer st = new StringTokenizer(br_count.readLine(), " ");

         int max = -1;
        double sum = 0.0;

        for (int i = 0; i < count; i++){
            int score = Integer.parseInt(st.nextToken());
            if (score > max){
                max = score;
            }
            sum += score;
        }

        System.out.println(((sum / max) * 100) / count);
    }
}
