package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1974_스도쿠검증 {
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int T;
	static int[][] sdoku = new int[9][9];
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/sw1974.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			boolean success = true;
			for(int i=0; i<9; i++) {
				stk = new StringTokenizer(in.readLine());
				for(int j=0; j<9; j++) {
					sdoku[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			for(int i=0; i<9; i++) {
				int[] arr = new int[9];
				for(int j=0; j<9; j++) {
					arr[(sdoku[i][j])-1]++;
				}
				for(int idx=0; idx<9; idx++) {
					if(arr[idx]==0) {
						success=false;
						break;
					}
				}
			}
			for(int i=0; i<9; i++) {
				int[] arr = new int[9];
				for(int j=0; j<9; j++) {
					arr[(sdoku[j][i])-1]++;
				}
				for(int idx=0; idx<9; idx++) {
					if(arr[idx]==0) {
						success=false;
						break;
					}
				}
			}
			Outer: for(int i=0; i<=6; i+=3) {
				for(int j=0; j<=6; j+=3) {
//					System.out.println(i+" "+j);
					int[] arr = new int[9];
					int y=i+3;
					int x=j+3;
					for(int a=i; a<y; a++) {
						for(int b=j; b<x; b++) {
//							System.out.println(a+" "+b);
//							System.out.println((sdoku[a][b]-1));
							arr[sdoku[a][b]-1]++;
						}
					}
					for(int c=0; c<9; c++) {
						if(arr[c]==0) {
							success=false;
							break Outer;
						}
					}
				}
			}
			if(success) sb.append("#"+ tc + " "+ 1+"\n");
			else sb.append("#"+ tc + " "+ 0+"\n");
		}
		out.write(sb.toString());
		in.close();
		out.flush();
		out.close();
	}

}
