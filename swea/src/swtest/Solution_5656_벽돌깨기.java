package swtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int T,N,W,H,ans,max,block;
	static int[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			stk = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			H = Integer.parseInt(stk.nextToken());
			map = new int[H][W];
			ans = 0; max=Integer.MIN_VALUE; block=0;
			for(int y=0; y<H; y++) {
				stk = new StringTokenizer(in.readLine());
				for(int x=0; x<W; x++) {
					map[y][x]=Integer.parseInt(stk.nextToken());
					if(map[y][x]!=0) block++;
				}
			}
			dfs(0);
			sb.append("#").append(tc).append(" ").append((block-max)).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	private static void dfs(int depth) {
		if(depth==N-1) {
			max = Math.max(max, ans);
			return;
		}
		int tempMap[][] = new int[H][W];
		for(int y=0; y<H; y++) tempMap[y] = map[y].clone();
		int tempAns = ans;
		for(int x=0; x<W; x++) {
			dropBead(x);
			dfs(depth+1);
			ans = tempAns;
			for(int y=0; y<H; y++) map[y]=tempMap[y].clone();
		}
	}
	private static void dropBead(int x) {
		for(int y=0; y<H; y++) {
			if(map[y][x]!=0) {
				breakBlock(y,x);
				dropBlock();
				break;
			}
		}
	}
	private static void dropBlock() {
		for(int x=0; x<W; x++) {
			for(int y=H-1; y>=0; y--) {
				if(map[y][x]==0) {
					for(int b=y-1; b>=0; b--) {
						if(map[b][x]!=0) {
							map[y][x]=map[b][x];
							map[b][x]=0;
							break;
						}
					}
				}
			}
		}
	}
	private static void breakBlock(int y, int x) {
		int range = map[y][x];
		map[y][x]=0;
		ans++;
		for(int d=0; d<4; d++) {
			int ny = y;
			int nx = x;
			for(int r=1; r<range; r++) {
				ny = ny+dy[d];
				nx = nx+dx[d];
				if(isBoundary(ny,nx)) break;
				if(map[ny][nx]==0) continue;
				if(map[ny][nx]>1) {
					breakBlock(ny,nx);
					continue;
				}
				map[ny][nx]=0;
				ans++;
			}
		}
		
	}
	private static boolean isBoundary(int ny, int nx) {
		if(ny<0 || nx<0 || ny>=H || nx>=W) return true;
		return false;
	}

}
