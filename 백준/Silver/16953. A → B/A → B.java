import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int count = 1;
        while (M != N) {
            if (M < N) {
                count = -1;
                break;
            }
            if (M % 10 == 1) {
                M /= 10;
            } else if (M % 2 == 0) {
                M /= 2;
            } else {
                count = -1;
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}
