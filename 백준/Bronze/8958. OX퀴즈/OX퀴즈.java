import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int score = 0;
        int acc = 0;

        for (int i = 0; i < num; ++i){
            score = 0;
            acc = 0;
            String ans = br.readLine();
            for (int j = 0; j < ans.length(); ++j){
                if (ans.charAt(j) == 'O'){
                    acc++;
                    score += acc;
                }
                else if (ans.charAt(j) == 'X') {
                    acc = 0;
                }
            }
            System.out.println(score);
        }
    }
}
