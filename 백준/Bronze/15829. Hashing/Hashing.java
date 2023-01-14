import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long result = 0;


        if (L == 1){
            result = (s.charAt(0) - 'a' + 1);

        } else {
            for (int i = 0; i < L/2; ++i){
                result += (s.charAt(i) - 'a' + 1) * (Math.pow(31, i));
            }
            for (int j = L/2+1; j <= L; ++j) {
                result += (s.charAt(j - 1) - 'a' + 1) * (Math.pow(31, j - 1));
            }
        }
        System.out.println(result);
    }
}
