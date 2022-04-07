package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1249_보급로 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int N,ans;
	static int[][] map;
	static int[][] updateMap;
	static boolean[][] isVisited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static class Engineer implements Comparable<Engineer>{
		int y;
		int x;
		int time;
		
		public Engineer(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(Engineer o) {
			return this.time-o.time;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			updateMap = new int[N][N];
			isVisited = new boolean[N][N];
			for(int y=0; y<N; y++) {
				String[] str = in.readLine().split("");
				for(int x=0; x<N; x++) {
					map[y][x] = Integer.parseInt(str[x]);
				}
			}
			ans = Integer.MAX_VALUE;
			for(int y=0; y<N; y++) Arrays.fill(updateMap[y], Integer.MAX_VALUE);
			updateMap[0][0]=0;
			bfs(0,0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();

	}
	private static void bfs(int y, int x) {
		PriorityQueue<Engineer> pq = new PriorityQueue<>();
		pq.add(new Engineer(y, x, 0));
		isVisited[y][x]=true;
		while(!pq.isEmpty()) {
			Engineer current = pq.poll();
			int cy = current.y;
			int cx = current.x;
			int time = current.time;
			
			if(cy==N-1 && cx==N-1) ans=Math.min(ans, time);
			if(time >= ans) continue;
			for(int d=0; d<4; d++) {
				int ny = cy+dy[d];
				int nx = cx+dx[d];
				if(isBoundary(ny,nx)) {
					int nextTime = time + map[ny][nx];
					if(!isVisited[ny][nx] || nextTime < updateMap[ny][nx]) {
						isVisited[ny][nx]=true;
						updateMap[ny][nx]=nextTime;
						pq.add(new Engineer(ny, nx, nextTime));
					}
				}
			}
		}
	}
	private static boolean isBoundary(int ny, int nx) {
		if(ny<0 || nx<0 || ny>=N || nx>=N) return false;
		return true;
	}

}
