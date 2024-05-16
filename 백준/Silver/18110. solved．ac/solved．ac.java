import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] list = new int[N];
        int result = 0;
        int trimmedNumber = (int)Math.round(N * 0.15);
        for (int i = 0; i < N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);

        for (int i = trimmedNumber; (i + trimmedNumber) < N; i++){
            result += list[i];
        }
        double mean = (double) result / (N-trimmedNumber * 2);
        result = (int)Math.round(mean);

        System.out.println(result);
    }
}
