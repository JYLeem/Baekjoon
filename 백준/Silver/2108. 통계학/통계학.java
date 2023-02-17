import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int total = 0;
        int k = 0;

        for (int i = 0; i < N; ++i){
            k = Integer.parseInt(br.readLine());
            arr.add(k);
            total += k;
        }

        arr.sort(Comparator.naturalOrder());

        int result = 0;
        int numfin = 0;
        int count = 1;
        boolean stats = true;

        if (N == 1){ // N이 1일 땐 그냥 반환
            numfin = arr.get(0);
        } else {
            for (int i = 1; i < N ; ++i){
                if (Objects.equals(arr.get(i - 1), arr.get(i))){ // 앞 뒤 수가 같을때 count++
                    count++;
                }
                if ((!Objects.equals(arr.get(i - 1), arr.get(i))) || (i == (N-1))) { // 앞 뒤 수가 다르거나 배열 끝났을 시
                    if (count > result) {
                        result = count;
                        numfin = arr.get(i-1);
                        stats = true;
                    }
                    else if ((count == result) && (stats)){
                        numfin = arr.get(i-1);
                        stats = false;
                    }
                    count = 1;
                }
            }
        }

        sb.append((int)Math.round((double)total/N)).append("\n"); // 1. 산술평균
        sb.append(arr.get(N/2)).append("\n"); // 2. 중앙값
        sb.append(numfin).append("\n"); // 3. 최빈값
        sb.append(arr.get(N-1) - arr.get(0)); // 4. 범위
        System.out.println(sb);

    }
}
