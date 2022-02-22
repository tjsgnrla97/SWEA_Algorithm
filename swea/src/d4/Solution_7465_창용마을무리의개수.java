package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int[] parents, rank;
	static boolean[] visited;
	static int N,M,ans;
	public static void makeSet() {
		for(int i=1; i<=N; i++) parents[i]=i;
	}
	public static int findSet(int a) {
		if(parents[a]==a) return a;
		return parents[a]=findSet(parents[a]);
	}
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) return false;
		if(rank[aRoot]<rank[bRoot]) {
			parents[aRoot] = bRoot;
		}
		else {
			parents[bRoot]=aRoot;
			if(rank[aRoot]==rank[bRoot]) rank[aRoot]++;
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			stk=new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			parents = new int[N+1];
			rank = new int[N+1];
			visited = new boolean[N+1];
			sb.append("#"+tc+" ");
			makeSet();
			for(int i=0; i<M; i++) {
				stk = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				union(a, b);
			}
			ans = 0;
			for(int i=1; i<=N; i++) {
				int parent = findSet(i);
				if(!visited[parent]) {
					visited[parent]=true;
					ans++;
				}
			}
			sb.append(ans+"\n");
		}
		out.write(sb.toString());
		in.close();
		out.flush();
		out.close();
	}
}
