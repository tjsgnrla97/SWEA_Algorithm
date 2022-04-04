package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int tc, N, ans;
	static int[] arr;
	static int[] C;
	public static void main(String[] args) throws NumberFormatException, IOException {
		tc = Integer.parseInt(in.readLine());
		for(int T=1; T<=tc; T++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			C = new int[N];
			stk = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(stk.nextToken());
			}
			ans=0;
			for(int i=0; i<N; i++) {
				int temp = Arrays.binarySearch(C, 0, ans, arr[i]);
				temp = Math.abs(temp)-1;
				C[temp]=arr[i];
				if(ans==temp) ans++;
			}
			sb.append("#").append(T).append(" ").append(ans).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}

}
