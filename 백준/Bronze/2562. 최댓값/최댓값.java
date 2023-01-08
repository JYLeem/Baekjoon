import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 9; i++){
            int init = Integer.parseInt(br.readLine());
            arr.add(i, init);
            if (max < init) max = init;
        }
        int place = arr.indexOf(max) + 1;
        System.out.println(max + "\n" + place);
    }
}
