import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tree_no = Integer.parseInt(st.nextToken());
        int tree_req = Integer.parseInt(st.nextToken());

        List<Integer> trees = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < tree_no; ++i){
            trees.add(Integer.parseInt(st.nextToken()));
        }
        int min = 0;
        int max = Collections.max(trees);
        int mid = 0;

        while (min < max) {
            long result = 0;
            mid = (min + max) / 2;

            for (int j : trees) {
                if (j - mid > 0) result += j - mid;
            }

            if (result < tree_req) max = mid;
            else min = mid + 1;

        }
        System.out.println(min - 1);
    }
}
