import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] arr = new int[3];

        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; ++i){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (arr[0]+arr[1]+arr[2] == 0) break;
            Arrays.sort(arr);
            if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }
}
