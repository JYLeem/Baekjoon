import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> trees = new ArrayList<>();

        for (int i = 0; i < K; ++i){
            trees.add(Integer.parseInt(br.readLine()));
        }
        trees.sort(Comparator.reverseOrder());
        long min = 0;
        long max = trees.get(0);
        max++;
        /*
            1.
            long max = trees.get(0) + 1

            2.
            long max = trees.get(0)
            max++;

            1과 2의 차이점이 무엇일까 ? 도저히 모르겠네....

        */
        System.out.println(max);
        long mid;

        while (min < max){
            long total = 0;
            mid = (min + max) / 2;

            for (int j = 0; j < K; ++j){
                total += trees.get(j) / mid;
            }
            if (total < N){
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}

