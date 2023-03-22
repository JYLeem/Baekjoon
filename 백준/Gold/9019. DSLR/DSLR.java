import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N ; ++i){
            StringTokenizer st;
            String ans [] = new String[10000];
            boolean visited [] = new boolean[10000];
            Queue <Integer> ls = new LinkedList<>();
            Arrays.fill(ans, "");

            st = new StringTokenizer(br.readLine(), " ");
            int pre = Integer.parseInt(st.nextToken());
            int aft = Integer.parseInt(st.nextToken());

            visited[pre] = true;
            ls.add(pre);

            while (!ls.isEmpty() && !visited[aft]){
                int temp = ls.poll();

                int D = (temp * 2) % 10000;
                int S = (temp == 0) ? 9999 : temp -1;
                int L = (temp % 1000) * 10 + temp / 1000;
                int R = (temp % 10) * 1000 + temp / 10;

                if(!visited[D]){
                    ls.add(D);
                    visited[D] = true;
                    ans[D] = ans[temp] + "D";
                }
                if(!visited[S]){
                    ls.add(S);
                    visited[S] = true;
                    ans[S] = ans[temp] + "S";
                }
                if(!visited[L]){
                    ls.add(L);
                    visited[L] = true;
                    ans[L] = ans[temp] + "L";
                }
                if(!visited[R]){
                    ls.add(R);
                    visited[R] = true;
                    ans[R] = ans[temp] + "R";
                }
            }
            System.out.println(ans[aft]);
        }
    }
}
