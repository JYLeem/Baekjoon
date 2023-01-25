import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = 1;
        int i = 0;

        while (true){
            if(N <= k){
                System.out.println(i+1);
                break;
            }
            else {
                i++;
                k = k + 6 * i;
            }
        }
    }
}
