import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; ++i){
            arr.add(Integer.parseInt(br.readLine()));
        }
        arr.sort(Comparator.naturalOrder());

        for (int j = 0; j < N; ++j) {
            sb.append(arr.get(j)).append("\n");
        }
        System.out.println(sb);
    }
}
