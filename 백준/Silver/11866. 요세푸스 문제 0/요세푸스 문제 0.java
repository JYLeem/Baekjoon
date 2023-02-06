import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        LinkedList<Integer> arr = new LinkedList<Integer>();


        for (int i = 1; i <= N; ++i){
            arr.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int k = 0;

        while (N > 1){
            k = (k + (T-1)) % N;
            sb.append(arr.remove(k)).append(", ");
            N--;

        }

        sb.append(arr.remove()).append('>');
        System.out.println(sb);
    }
}
