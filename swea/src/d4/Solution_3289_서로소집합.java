package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int[] parents;
	static int N,M;
	public static void makeSet() {
		for(int i=0; i<N; i++) parents[i]=i;
	}
	public static int findSet(int a) {
		if(parents[a]==a) return a;
		return parents[a]=findSet(parents[a]);
	}
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) return false;
		if(aRoot<=bRoot) parents[bRoot] = aRoot;
		else parents[aRoot]=bRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			stk=new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			parents = new int[N];
			sb.append("#"+tc+" ");
			makeSet();
			for(int i=0; i<M; i++) {
				stk = new StringTokenizer(in.readLine());
				int c = Integer.parseInt(stk.nextToken());
				int a = Integer.parseInt(stk.nextToken())-1;
				int b = Integer.parseInt(stk.nextToken())-1;
				if(c==0) union(a, b);
				else {
					if(findSet(a)==findSet(b)) sb.append("1");
					else sb.append("0");
				}
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		in.close();
		out.flush();
		out.close();
	}
}
