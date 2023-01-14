import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long result = 0;

        for (int i = 0; i < L; ++i){
            result += (long)(s.charAt(i) - 'a' + 1) * (Math.pow(31, i));
        }
        System.out.println(result);
    }
}
