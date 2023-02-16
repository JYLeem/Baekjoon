import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        sb.append(gcd(N, M)).append("\n");
        sb.append(lcm(N, M) / gcd(N, M)).append("\n");

        System.out.println(sb);

    }

    public static int lcm (int x, int y) { 
        return Math.abs(x * y);

    }

    public static int gcd (int x, int y){
        int rem = 0;

        while (true){
            if (x > y){
                rem = x % y;
                x = rem;
                if (x == 0){
                    return y;
                }
            }
            else {
                rem = y % x;
                y = rem;
                if (y == 0){
                    return x;
                }
            }
        }
    }
}
