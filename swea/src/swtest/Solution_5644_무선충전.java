package swtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
//	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int T,m,a, ans;
	static int[] moveA, moveB;
	static BC[] bcList;
	static Index A,B;
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	static class Index{
		int y, x;

		public Index(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		public void setIndex(int dir) {
			this.y = y + dy[dir];
			this.x = x + dx[dir];
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Index [y=").append(y).append(", x=").append(x).append("]");
			return builder.toString();
		}
		
	}
	
	static class BC{
		Index idx;
		int range, power;
		
		public BC(int y, int x, int range, int power) {
			this.idx = new Index(y,x);
			this.range = range;
			this.power = power;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("BC [idx=").append(idx).append(", range=").append(range).append(", power=").append(power)
					.append("]");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			stk = new StringTokenizer(in.readLine());
			
			m = Integer.parseInt(stk.nextToken());
			a = Integer.parseInt(stk.nextToken());
//			System.out.println("현재 m : "+m+" 현재 a : "+a);
			bcList = new BC[a];
			moveA = new int[m+1];
			moveB = new int[m+1];
			moveA[0] = 0;
			moveB[0] = 0;
			A = new Index(0,0);
			B = new Index(9,9);
			
			stk = new StringTokenizer(in.readLine());
			for(int i=1; i<=m; i++) moveA[i] = Integer.parseInt(stk.nextToken());
			stk = new StringTokenizer(in.readLine());
			for(int i=1; i<=m; i++) moveB[i] = Integer.parseInt(stk.nextToken());
			
			for(int i=0; i<a; i++) {
				stk = new StringTokenizer(in.readLine());
				
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				int C = Integer.parseInt(stk.nextToken());
				int P = Integer.parseInt(stk.nextToken());
				
				bcList[i] = new BC(y-1, x-1, C, P);
			}
//			for(BC bc : bcList) System.out.println(bc); 
			ans = solution();
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		out.write(sb.toString());
		in.close();
		out.flush();
		out.close();
	}

	private static int solution() {
		int sum=0;
		for(int t=0; t<=m; t++) {
			A.setIndex(moveA[t]);
			B.setIndex(moveB[t]);
			sum += getMax(getCheck(A,B));
//			System.out.println("현재 A : "+A.x+" , "+A.y+" 현재 B : "+B.x+" , "+B.y);
		}
		return sum;
	}

	private static int getMax(boolean[][] check) {
		int max = 0, value;
		boolean checkA, checkB;
		for(int i=0; i<a; i++) {
			checkA = check[0][i];
			for(int j=0; j<a; j++) {
				checkB = check[1][j];
				value=0;
				
				if(i==j && checkA && checkB) value = bcList[i].power;
				else {
					if(checkA) value += bcList[i].power;
					if(checkB) value += bcList[j].power;
				}
				max = Math.max(max, value);
			}
		}
		return max;
	}

	private static boolean[][] getCheck(Index idxA, Index idxB) {
		boolean[][] result = new boolean[2][a];
		
		for(int i=0; i<a; i++) {
			BC bc = bcList[i];
			if(getDistance(idxA, bc.idx)<=bc.range) result[0][i] = true;
			if(getDistance(idxB, bc.idx)<=bc.range) result[1][i] = true;
		}
		return result;
	}

	private static int getDistance(Index a, Index b) {
		return Math.abs(a.x - b.x)+Math.abs(a.y-b.y);
	}

}
