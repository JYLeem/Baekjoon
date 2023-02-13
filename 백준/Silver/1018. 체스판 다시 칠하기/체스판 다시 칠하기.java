import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/101      >> 참고함! 

public class Main {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new boolean[M][N];

        for (int i = 0; i < M; ++i){
            String s = br.readLine();
            for (int j = 0; j < N; ++j) {
                if (s.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }


        for (int i = 0; i < (M - 7); ++i){
            for (int j = 0; j < (N - 7); ++j){
                search(i, j);
            }
        }
        System.out.println(min);

    }
    public static void search (int x, int y){
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;


        boolean start = arr[x][y];

        for (int i = x; i < end_x; ++i){
            for (int j = y; j < end_y; ++j){
                if (arr[i][j] != start) count++;
                start = !start;
            }
            start = !start;
        }

        count = Math.min(count, 64-count);
        min = Math.min(min, count);


    }
}