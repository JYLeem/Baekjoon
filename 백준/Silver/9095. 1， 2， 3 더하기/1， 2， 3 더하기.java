import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//최세민씨 코드 보고함!

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i){
            sb.append(machine(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.println(sb);
    }

    public static int machine(int a) {
        if (a <= 0){
            return 1;
        }
        int num = 0;
        if (a >= 3) {
            num += machine(a-3);
        }
        if (a >= 2){
            num += machine(a-2);
        }
        num += machine(a-1);

        return num;
    }
}
