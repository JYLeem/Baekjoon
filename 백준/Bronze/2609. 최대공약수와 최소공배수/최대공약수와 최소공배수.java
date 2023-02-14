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
        int gcd = gcd(N, M);
        System.out.println(gcd + "\n" + (M*N) /gcd);
    }

    public static int gcd (int x, int y){
        if (y == 0) return x;
        return gcd(y, x%y);
    }
}
