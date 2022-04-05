package d6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {
	
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int T,N,ans;
	static int[] dist;
	static int[][] adjMatrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/sw1263.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			adjMatrix = new int[N][N];
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					adjMatrix[y][x]=Integer.parseInt(stk.nextToken());
					if(y!=x && adjMatrix[y][x]==0) adjMatrix[y][x]=999999999;
				}
			}
			for(int k=0; k<N; k++) {
				for(int y=0; y<N; y++) {
					for(int x=0; x<N; x++) {
						adjMatrix[y][x]=Math.min(adjMatrix[y][x], adjMatrix[k][x]+adjMatrix[y][k]);
					}
				}
			}
			ans=Integer.MAX_VALUE;
			for(int y=0; y<N; y++) {
				int sum=0;
				for(int x=0; x<N; x++) {
					sum+=adjMatrix[y][x];
				}
				ans=Math.min(ans, sum);
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}
