import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String number = br.readLine();
            int count = number.length();
            boolean flag = true;

            if (number.equals("0")) break;
            else {
                for (int i = 0; i < count/2; ++i){
                    if (number.charAt(i) != number.charAt(count-1-i)){
                        flag = false;
                        break;
                    }
                }
                if (flag) sb.append("yes").append("\n");
                else sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}
