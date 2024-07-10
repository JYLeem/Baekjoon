import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap <String, Integer> info = new HashMap<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            info.clear();
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String val = st.nextToken();

                if (info.containsKey(val)){
                    info.put(val, info.get(val) + 1);
                }
                else info.put(val, 1);
            }

            int ans = 1;


            for (int cnt : info.values()){
                ans *= (cnt+1);
            }
            ans--;

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}