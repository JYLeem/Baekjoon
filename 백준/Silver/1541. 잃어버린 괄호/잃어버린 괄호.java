/*  계획:

    로직: "-" 제외한 나머지 연산 진행 후 뺄샘 진행.
    StringTokenizer로 토큰화 후 필터링 진행한다.
    전역변수를 통해 변수를 간단히 처리한다. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String equ = br.readLine();
        String [] arr = equ.split("-");
        int answer = add(arr[0]);

        for (int i = 1; i < arr.length; i++){
            answer -= add(arr[i]);
        }
        System.out.println(answer);

    }

    public static int add(String equation) {
        int result = 0;
        String [] addList = equation.split("\\+");
        for (int i = 0; i < addList.length; i++){
            result += Integer.parseInt(addList[i]);
        }

        return result;
    }
}

/*  결과:

    로직: "-" 제외한 나머지 연산 진행 후 뺄샘 진행. (정답)
    StringTokenizer로 토큰화 후 필터링 진행한다. -> 배열 생성 후 .split 을 이용해서 토큰화 진행이 훨씬 수월하다.
    split을 할 경우 "\\+"로 진행해야 한다. 
    전역 변수의 생명주기를 잘 생각해 가며 선언하자!
    파라미터에 Object 를 받을 수 있고, CallByReference 인지 CallByValue를 잘 생각해 가며 받자.
    
*/

// 출처: https://bbangson.tistory.com/39