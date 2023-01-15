import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; ++i) {
            int check = 0;
            int con = 0;
            String test = br.readLine();
            for (int j = 0; j < test.length(); ++j) {
                if (test.charAt(j) == '(') {
                    check++;
                } else {
                    check--;
                    if (check == -1) con++;
                }
            }
            if ((check != 0) || (con != 0)){
                sb.append("NO").append("\n");
            } else sb.append("YES").append("\n");
        }
        System.out.println(sb);
    }
}
