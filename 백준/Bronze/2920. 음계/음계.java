import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String result = null;

        int [] arr = new int[8];

        for (int i = 0; i < 8; ++i){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        for (int j = 0; j < 7; ++j){
            if (arr[j] + 1 == arr[j+1]){
                result = "ascending";
            } else if (arr[j] - 1 == arr[j+1]){
                result = "descending";
            } else {
                result = "mixed";
                break;
            }
        }
        System.out.println(result);

    }
}
