import java.io.*;

// https://wonit.tistory.com/540   // <- 참고함

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmb = br.readLine().split(" ");
        int n = Integer.parseInt(nmb[0]);
        int m = Integer.parseInt(nmb[1]);
        int b = Integer.parseInt(nmb[2]);

        int[][] ground = new int[n][m];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < ground.length; i++) {

            String[] groundRow = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(groundRow[j]);
                ground[i][j] = value;

                max = Math.max(max, value);
                min = Math.min(min, value);
            }
        }

        int answerSeconds = Integer.MAX_VALUE; // 시간
        int answerHeight = -1; // 층

        for (int i = min; i <= max; i++) { // 최소층 부터 최대층 까지

            int seconds = 0;
            int inventory = b;

            for (int j = 0; j < ground.length; j++) {
                for (int k = 0; k < ground[j].length; k++) {
                    int diff = ground[j][k] - i;

                    if(diff > 0) { // 제거해야 함
                        seconds += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    }else if(diff < 0){ // 추가해야 함
                        seconds += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if(inventory >= 0) {
                if(seconds <= answerSeconds) { // == 가 포함되어야 함 ㅇ그렇지 않으면 최대 높이를 판별 하지 못함
                    answerSeconds = seconds;
                    answerHeight = i;
                }
            }
        }

        bw.write(answerSeconds + " " + answerHeight);

        bw.flush();
        bw.close();
    }
}


/*
내가 짜본 코드들
1.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class p18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br. readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        List<Integer> val = new ArrayList<>();

        for (int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j){
                val.add(Integer.parseInt(st.nextToken()));
            }
        }
        val.sort(Comparator.naturalOrder());
        int min = val.get(0);
        int max = val.get(N*M -1);

        int time = Integer.MAX_VALUE;
        int height = 0;

        for (int i = min; i <= max; ++i){
            int box = B;
            int time_init = 0;

            for (int j = 0; j < M * N; ++j){
                int diff = val.get(j) - i;
                if (diff > 0){
                    time_init +=  diff * 2;
                    box += diff;
                }
                else if (diff < 0){
                    time_init -= diff;
                    box += diff;
                }
            }
            if (box >= 0 ) {
                if (time_init <= time){
                    time = time_init; height = i;
                }
            }

        }
        System.out.println(time + " " + height);
    }
}


2,
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br. readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int total_num = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j){
                total_num += Integer.parseInt(st.nextToken());
            }
        }
        final int total = total_num;

        if (total / (N * M) == 0){

            int calc_rmv;
            int calc_ins;

            if(total + B <= 256) {
                calc_rmv = 2 * total;
            } else calc_rmv = 257;

            if (0 <= -total + B){
                calc_ins = N * M - total;
            } else calc_ins = 257;

            if(calc_ins < calc_rmv) sb.append(calc_ins).append(" ").append(1);
            else sb.append(calc_rmv).append(" ").append(0);

        } else {
            total_num %= (total / (N * M));
            int calc_rmv;
            int calc_ins;
            int total_rmv = 0;
            int total_ins = 0;

            if(total_num + B <= 256) {
                calc_rmv = 2 * total_num;
                total_rmv = (total - total_num) / (N * M);
            } else calc_rmv = 999999;


            int ins = total_num - M * N;
            if (0 <= ins + B){
                calc_ins = -ins;
                total_ins = (total + calc_ins) / (N * M);

            } else calc_ins = 999999;

            if(calc_ins < calc_rmv) sb.append(calc_ins).append(" ").append(total_ins);
            else sb.append(calc_rmv).append(" ").append(total_rmv);
        }

        System.out.println(sb);
    }
}
*/

