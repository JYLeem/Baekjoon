import java.io.IOException;


public class Main {
    public static void main(String [] args) throws IOException {
        int [] alpha = new int[26];

        int c = System.in.read();

        while ('A' <= c){
            if (c <= 'Z'){
                alpha[c - 'A']++;
            }
            else if (c <= 'z'){
                alpha[c - 'a']++;
            }
            c = System.in.read();
        }

        int count = -1;
        int ch = -2;

        for (int i = 0; i < 26; i++){
            if (count < alpha[i]){
                count = alpha[i];
                ch = i;
            } else if (count == alpha[i]){
                ch = -2;
            }
        }
        System.out.println((char)(ch + 'A'));
    }
}
