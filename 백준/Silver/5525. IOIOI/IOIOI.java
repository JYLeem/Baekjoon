import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int ans = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        for (int i = 0; i < M - 1; i++) {
            if (S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && i + 2 < M && S.charAt(i + 2) == 'I') {
                count++;
                if (count == N) {
                    ans++;
                    count--; 
                }
                i++; 
            } else {
                count = 0; 
            }
        }
        System.out.println(ans);
    }
}

/* 
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int ans = 0;

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            String S = br.readLine();

            for (int i = 0; i < N; i++){
                sb.append("IO");
            }
            sb.append("I");

            String pat = sb.toString();

            int i = 0;

            while (true){
                int jump = S.indexOf(pat, i);
            
                if (jump != -1){
                    ans++;
                    i = jump + 2;
                } else {
                    break;
                }
            }


            System.out.println(ans);
        }

    }
*/

