import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; ++i){
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
        }
        Collections.sort(arr);
        int min = arr.get(0);
        int max = arr.get(N - 1);

        System.out.println(min + " " + max);
    }
}
