import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        int i = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()){
            arr[i] = (Integer.parseInt(st.nextToken()));
            ++i;
        }

        Arrays.sort(arr);

        br.readLine();

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0 ) {
                sb.append(1).append("\n");
            } else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}
