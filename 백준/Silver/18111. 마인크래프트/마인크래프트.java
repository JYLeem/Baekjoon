import java.util.*;
import java.io.*;
	
public class Main {
	static int arr[][];
	static int result[] = new int[2];
	
	static int time = Integer.MAX_VALUE;
	static int height;
	static int block;
	static int N, M, B;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		B = Integer.parseInt(st.nextToken()); // 가지고있는 블록의 갯수
	
		arr = new int [N][M];		
		int max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
	
				max = Math.max(max, arr[i][j]);
			}
		}
	
		brute_force(max);
	
		System.out.println(time + " " + height);
	} // End of main
	
	static void brute_force(int max) {
	
		// arr전체를 탐색해서 각 블럭의 갯수를 맞춰보며, 시간을 계산
		// 각 시간의 최소값으로 갱신.
		for(int i=0; i<=max; i++) {
			result = excavation(i); 
	
			if(time > result[0]) {
				time = result[0];
				height = result[1];
			}
            // 시간이 같을 경우, 높이가 더 높은것을 채택한다.
			else if(time == result[0] && height < result[1]) {
				time = result[0];
				height = result[1];
			}
	
		}
	} // End of brute_force
	
	// 시간, 높이 반환 
	static int[] excavation(int height) {
		int block = B;
		int time = 0;
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int value = arr[i][j];
	
				// value기준으로 맞추려고 하는 높이(height)가 더 낮은 경우
				// 즉, 블럭을 깎아야 하는 경우
				if(value == height) {
					continue;
				}
				
				if(value > height) {
					time += (value - height)*2;
					block += (value - height);
				}
                // value기준으로 맞추려고 하는 높이(height)가 더 높은 경우
				// 즉, 블럭을 쌓아야하는 경우
				else {
					time += height - value;
					block -= (height - value);
				}
			}
		}
		
		// 남은 블럭의 갯수가 0 미만이면 불가능으로 판단. 최고치를 반환.
		if(block < 0) {
			result[0] = 999999999;
			return result;
		}
		
		result[0] = time;
		result[1] = height;
		
		return result;
	} // End of excatvation
} // End of class