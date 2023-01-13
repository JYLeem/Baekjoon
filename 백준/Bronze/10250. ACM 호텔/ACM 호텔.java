import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int room_no = (N / H + 1);
            int floor = N % H;
            int result = 0;

            if (floor == 0) result = H * 100 + room_no - 1;
            else result = floor * 100 + room_no;

            sb.append((int)result).append("\n");

        }
        System.out.println(sb);

    }
}

