import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue <Point> pq = new PriorityQueue<>();
        LinkedList <Integer> ans = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                if (pq.isEmpty()){
                    ans.add(0);
                }
                else {
                    Point tmp = pq.poll();
                    ans.add(tmp.unit ? -tmp.val : tmp.val);
                }
            }
            else {
                pq.add(new Point(Math.abs(num), num < 0));
            }
        }

        for (int i : ans){
            System.out.println(i);
        }
    }
    static class Point implements Comparable<Point> {
        int val;
        boolean unit;

        public Point(int val, boolean unit){
            this.val = val;
            this.unit = unit;
        }

        @Override
        public int compareTo(Point o){
            if (this.val == o.val) {
                return Boolean.compare(o.unit, this.unit);
            }
            return Integer.compare(this.val, o.val);
        }
    }
}
