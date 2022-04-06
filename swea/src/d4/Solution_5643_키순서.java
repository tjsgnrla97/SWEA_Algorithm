package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int V, E, adjMatrix[][];
	static int taller, shoter, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			V = Integer.parseInt(in.readLine());
			E = Integer.parseInt(in.readLine());
			adjMatrix = new int[V+1][V+1];
			for(int e = 1; e<=E; e++) {
				stk = new StringTokenizer(in.readLine());
				int y = Integer.parseInt(stk.nextToken());
				int x = Integer.parseInt(stk.nextToken());
				adjMatrix[y][x]=1;
			}
			ans=0;
			for(int from=1; from<=V; from++) {
				shoter=0;
				taller=0;
				findShoter(from);
				findTaller(from);
				if(taller+shoter==V-1) ans++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	private static void findTaller(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] isVisited = new boolean[V+1];
		q.add(start);
		isVisited[start]=true;
		while(!q.isEmpty()) {
			int from = q.poll();
			for(int to=1; to<=V; to++) {
				if(adjMatrix[from][to]==1 && !isVisited[to]) {
					q.add(to);
					isVisited[to]=true;
					taller++;
				}
			}
		}
	}
	private static void findShoter(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] isVisited = new boolean[V+1];
		q.add(start);
		isVisited[start]=true;
		while(!q.isEmpty()) {
			int from = q.poll();
			for(int to=1; to<=V; to++) {
				if(adjMatrix[to][from]==1 && !isVisited[to]) {
					q.add(to);
					isVisited[to]=true;
					shoter++;
				}
			}
		}
	}

}
