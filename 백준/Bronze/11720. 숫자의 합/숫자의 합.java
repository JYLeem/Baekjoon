import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String nums = br.readLine();
        int result = 0;

        for (int i = 0; i < nums.length(); ++i){
            result += nums.charAt(i) - 48;
        }
        System.out.println(result);

    }
}
