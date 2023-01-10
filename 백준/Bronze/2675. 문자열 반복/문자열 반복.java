import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());


        for (int k = 0; k < count; ++k){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            for (int i = 0; i < name.length(); ++i) {
                for (int j = 0; j < num; ++j) {
                    System.out.print(name.charAt(i));
                }
            }
            System.out.println();

        }
    }
}
