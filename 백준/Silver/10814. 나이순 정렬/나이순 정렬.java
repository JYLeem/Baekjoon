import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder[] sb = new StringBuilder[201];

        for (int i = 0 ;i < sb.length; ++i){
            sb[i] = new StringBuilder();
        }

        for (int j = 0; j < N; ++j){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            sb[age].append(age).append(" ").append(name).append("\n");
        }
        StringBuilder list = new StringBuilder();
        for(StringBuilder k : sb) {
            list.append(k);
        }
        System.out.println(list);
    }
}
