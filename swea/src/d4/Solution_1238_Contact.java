package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int N, start;
	static int[][] adjMatrix;
	static int[] isVisited;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/sw1238.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			sb.append("#"+tc+" ");
			stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			start = Integer.parseInt(stk.nextToken());
			
			adjMatrix = new int[N+1][N+1];
			isVisited = new int[N+1];
			stk=new StringTokenizer(in.readLine());
			while(stk.hasMoreElements()) {
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				adjMatrix[from][to]=1;
			}
			sb.append(bfs());
			sb.append("\n");
		}
		out.write(sb.toString());
		in.close();
		out.flush();
		out.close();
	}
	private static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		isVisited[start]=1;
		while(!queue.isEmpty()) {
			int from=queue.poll();
			for(int to=1; to<=N; to++) {
				if(isVisited[to]==0&&adjMatrix[from][to]!=0) {
					queue.offer(to);
					isVisited[to]=isVisited[from]+1;
				}
			}
		}
		int max=0;
		int result=0;
		for(int i=1; i<=N; i++) {
			if(max <= isVisited[i]) {
				max = isVisited[i];
				result = i;
			}
		}
		return result;
	}

}
