import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            int check = 0;
            int check1 = 0;
            int con = 0;
            String line = br.readLine();
            Stack<String> stack = new Stack<>();
            if (line.equals(".")) break;
            else if (!(line.contains("(") || line.contains("[") || line.contains(")") || line.contains("]"))) {
                sb.append("yes").append("\n");
            } else {
                for (int j = 0; j < line.length(); ++j) {
                    if (line.charAt(j) == '('){
                        stack.push("(");
                        check++;
                    }
                    else if (line.charAt(j) == '[') {
                        stack.push("[");
                        check1++;
                    }
                    else if (line.charAt(j) == ')'){
                        if (check == 0) con++;
                        else {
                            check--;
                            if (!Objects.equals(stack.pop(), "(")) con++;
                        }
                    }
                    else if (line.charAt(j) == ']') {
                        if (check1 == 0) con++;
                        else {
                            check1--;
                            if (!Objects.equals(stack.pop(), "[")) con++;
                        }
                    }
                }
                if ((check != 0) || (con != 0) || (check1 != 0)){
                    sb.append("no").append("\n");
                } else sb.append("yes").append("\n");
            }
        }
        System.out.println(sb);
    }
}
