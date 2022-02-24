package d4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;
		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
	}
	static int[] parents;
	static int T,N;
	static long E,ans;
	static Point[] land;
	static ArrayList<Edge> edgeList;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/sw1251.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N=Integer.parseInt(in.readLine());
			land = new Point[N];
			parents= new int[N];
			
			stk=new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				land[i] = new Point(0, 0);
				land[i].x = Integer.parseInt(stk.nextToken());
			}
			stk = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				land[i].y=Integer.parseInt(stk.nextToken());
			}
			double E = Double.parseDouble(in.readLine());
			edgeList = new ArrayList<Edge>();
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					long disX=Math.abs(land[i].x-land[j].x);
					long disY=Math.abs(land[i].y-land[j].y);
					edgeList.add(new Edge(i, j, disX*disX+disY*disY));
				}
			}
			edgeList.sort(null);
			makeSet();
			
			
			int cnt=0;
			ans=0;
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					ans+=edge.weight;
					if(++cnt==N-1) break;
				}
			}
			sb.append("#"+tc+" "+Math.round(ans*E)+"\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	private static int findSet(int x) {
		if(x==parents[x]) return x;
		return parents[x]=findSet(parents[x]);
	}
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		parents[bRoot]=aRoot;
		return true;
	}
	private static void makeSet() {
		for(int i=0; i<N; i++) parents[i]=i;
	}
}
