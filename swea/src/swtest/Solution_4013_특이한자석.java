package swtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int T, K, ans;
	static int[][] gear;
	static int[] dir;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			K=Integer.parseInt(in.readLine());
			ans=0;
			gear = new int[4][8];
			for(int y=0; y<gear.length; y++) {
				stk = new StringTokenizer(in.readLine());
				for(int x=0; x<gear[y].length; x++) {
					gear[y][x] = Integer.parseInt(stk.nextToken());
				}
			}
			while(K-- >0) {
				stk = new StringTokenizer(in.readLine());
				int idx = Integer.parseInt(stk.nextToken())-1;
				int rotateDir = Integer.parseInt(stk.nextToken());
				
				dir = new int[4];
				dir[idx]=rotateDir;
				
				rotateCheckLeft(idx, rotateDir*-1);
				rotateCheckRight(idx, rotateDir*-1);
				
				for(int i=0; i<dir.length; i++) rotateGear(i, dir[i]);
			}
			for(int i=0; i<gear.length; i++) {
				if(gear[i][0]==1) {
					ans+= 1<<i;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	private static void rotateGear(int idx, int rotateDir) {
		int temp=0;
		if(rotateDir==1) {
			temp = gear[idx][7];
			for(int i=gear[idx].length-1; i>0; i--) {
				gear[idx][i] = gear[idx][i-1];
			}
			gear[idx][0]=temp;
		}
		else if(rotateDir==-1) {
			temp=gear[idx][0];
			for(int i=0; i<gear[idx].length-1; i++) {
				gear[idx][i]=gear[idx][i+1];
			}
			gear[idx][7]=temp;
		}
	}
	private static void rotateCheckRight(int left, int rotateDir) {
		int right = left +1;
		if(right>3) return;
		if(gear[left][2] != gear[right][6]) {
			dir[right]=rotateDir;
			rotateCheckRight(right, rotateDir*-1);
		}
	}
	private static void rotateCheckLeft(int right, int rotateDir) {
		int left = right -1;
		if(left<0) return;
		if(gear[left][2] != gear[right][6]) {
			dir[left]=rotateDir;
			rotateCheckLeft(left, rotateDir*-1);
		}
	}

}
