package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int V,E;
	static long ans;
	static int[] parent;
	static Edge[] edge;
	static class Edge{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			stk = new StringTokenizer(in.readLine());
			V = Integer.parseInt(stk.nextToken());
			E = Integer.parseInt(stk.nextToken());
			parent = new int[V+1];
			edge = new Edge[E];
			
			for(int i=0; i<E; i++) {
				stk = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				int weight = Integer.parseInt(stk.nextToken());				
				edge[i] = new Edge(from, to, weight);
			}
			makeSet();
			Arrays.sort(edge, (a,b)->a.weight-b.weight);
			int cnt=0;
			ans=0;
			for(int i=0; i<E; i++) {
				Edge e = edge[i];
				if(findSet(e.from)==findSet(e.to)) continue;
				union(e.from, e.to);
				cnt++;
				ans+=e.weight;
				if(cnt==V-1) break;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px<py) parent[py]=px;
		else parent[px]=py;
	}
	private static int findSet(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	private static void makeSet() {
		for(int i=1; i<=V; i++) parent[i]=i;
	}
}
