import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuilder sb = new StringBuilder();

        int[]arr = new int[26];

        for (int i = 0; i < 26; ++i){
            arr[i] = -1;
        }

        for (int j = 0; j < word.length(); ++j){
            if (arr[word.charAt(j) - 'a'] == -1) {
                arr[word.charAt(j) - 'a'] = j;
            }
        }

        for (int k = 0; k < 26; ++k){
            sb.append(arr[k]).append(" ");
        }

        System.out.println(sb);
    }
}
