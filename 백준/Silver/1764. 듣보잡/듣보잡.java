import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    LinkedList: 삽입, 삭제는 빠르나, Random access 는 느리다.
    ArrayList : 삽입, 삭제는 느리나, Random access 는 빠르다.
    HashSet의 contains 는 O(1), ArrayList, LinkedList는 O(N) 이므로

    HashSet 사용. asn 은 삽입 삭제 해야하므로, LinkedList 사용
    중요 포인트: HashSet을 꼭 사용해야지 시간 복잡도를 만족한다.


 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        HashSet<String> dic = new HashSet<>();
        LinkedList<String> ans = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            dic.add(br.readLine());
        }

        for (int i = 0; i < M; i++){
            String ele = br.readLine();
            if (dic.contains(ele)){
                ans.add(ele);
            }
        }

        int cnt = ans.size();

        Collections.sort(ans);
        
        System.out.println(cnt);
        for (int j = 0; j < cnt; j++){
            System.out.println(ans.get(j));
        }

    }
}
