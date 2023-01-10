import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] arr = new int[43];

        for (int i = 1; i <= 10; ++i){
            int num = Integer.parseInt(br.readLine());
            arr[num % 42]++;
        }
        long count = Arrays.stream(arr).filter(i -> i != 0).count();
        System.out.println(count);
    }
}
