import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> arr = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        int back = 0;

        for (int i = 0; i < N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "push":
                    back = Integer.parseInt(st.nextToken());
                    arr.offer(back);
                    break;

                case "pop":
                    if (arr.size() == 0){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arr.poll()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(arr.size()).append("\n");
                    break;

                case "empty":
                    if (arr.size() == 0){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (arr.size() == 0){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arr.peek()).append("\n");
                    }
                    break;

                case "back":
                    if (arr.size() == 0){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(back).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);

    }
}
