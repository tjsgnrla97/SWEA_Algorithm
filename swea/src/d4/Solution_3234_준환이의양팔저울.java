package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
//	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int N,ans;
	static int[] left, right, all;
	static boolean[] isChecked;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/sw3234.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			stk = new StringTokenizer(in.readLine());
			all = new int[N];
			isChecked = new boolean[N];
			for(int i=0; i<N; i++) {
				all[i]=Integer.parseInt(stk.nextToken());
			}
			ans=0;
			solveAns(0,0,0);
			sb.append("#"+tc+" "+ans+"\n");
		}
		out.write(sb.toString());
		in.close();
		out.flush();
		out.close();
	}
	private static void solveAns(int cnt, int left, int right) {
		if(cnt==N-1) {
			ans++;
			for(int i=0; i<N; i++) {
				if(!isChecked[i]&&left>=right+all[i]) {
					ans++;
				}
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(!isChecked[i]) {
				isChecked[i]=true;
				solveAns(cnt+1, left+all[i], right);
				if(left>=right+all[i]) {
					solveAns(cnt+1, left, right+all[i]);
				}
				isChecked[i]=false;
			}
		}
	}

}
