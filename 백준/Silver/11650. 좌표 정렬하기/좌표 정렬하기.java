import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][]arr = new int [N][2];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for (int j = 0; j < N; ++j){
            sb.append(arr[j][0]).append(" ").append(arr[j][1]).append("\n");
        }

        System.out.println(sb);
    }
}


/**    <시도 1 -_- 0을 생각 안함 ㅠㅠ>
public class p11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringBuilder sb = new StringBuilder();
        int xnum = 1000000;
        int ynum = 100000;

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if (X <= 0) {
                if (Y <= 0) {
                    arr[i] = (long) -X * xnum - Y;} // (-X, -Y)
                else arr[i] = (long) -X * xnum + Y + ynum; // (-X, Y)
            } else {
                if (Y < 0) arr[i] = (long) xnum * 100000 + (long) (X) * xnum - Y ; // (X, -Y)
                else arr[i] = (long) xnum * 100000 + (long) (X) * xnum + Y + ynum; // (X, Y)
            }
        }
        Arrays.sort(arr);

        for (int j = 0; j < N; ++j) {
            if (arr[j] / (ynum * 10) > ynum) { // X
                if (arr[j] % (ynum * 10) > ynum) {
                    sb.append(((arr[j] / xnum) - ynum)).append(" ").append(((arr[j] % xnum) - ynum)).append("\n");} // (X, Y)
                else sb.append((arr[j] / xnum) - ynum).append(" ").append(-(arr[j] % xnum)).append("\n"); // (X, -Y)
            } else { // -X
                if (arr[j] % (ynum * 10) > ynum) {
                    sb.append(-(arr[j] / xnum)).append(" ").append(((arr[j] % xnum) - ynum)).append("\n");} // (-X, Y)
                else {
                    sb.append(-(arr[j] / xnum)).append(" ").append(-(arr[j] % xnum)).append("\n"); // (-X, -Y)
                }
            }



        }
        for (int k = 0; k < N; ++k){
            System.out.println(arr[k]);
        }
    }
}
**/