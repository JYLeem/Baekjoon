import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> list = new HashMap<Integer, String>();
        HashMap<String, Integer> list2 = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; ++i){
            String element = br.readLine();
            list.put(i, element);
            list2.put(element, i);
        }

        for (int j = 0; j < K; ++j){
            String test = br.readLine();
            if (test.charAt(0) >= '0' && test.charAt(0) <= '9'){
                sb.append(list.get(Integer.parseInt(test))).append("\n");
            } else {
                sb.append(list2.get(test)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
