import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mult = 1;

        for (int i = 0; i < 3; i++){
            int numbers = Integer.parseInt(br.readLine());
            mult *= numbers;
        }

        int [] arr = new int [10];

        while (mult != 0){
            arr[mult % 10]++;
            mult /= 10;
        }
        for (int result : arr){
            System.out.println(result);
        }
    }
}
