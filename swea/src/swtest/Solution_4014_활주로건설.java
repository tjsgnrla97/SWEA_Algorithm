package swtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int N,X,ans;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			stk = new StringTokenizer(in.readLine());
			N=Integer.parseInt(stk.nextToken());
			X=Integer.parseInt(stk.nextToken());
			map = new int[N][N];
			ans=0;
			for(int y=0; y<N; y++) {
				stk = new StringTokenizer(in.readLine());
				for(int x=0; x<N; x++) {
					map[y][x]=Integer.parseInt(stk.nextToken());
				}
			}
			buildAirRoad();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	private static void buildAirRoad() {
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(y==0) buildRow(y,x);
				if(x==0) buildCol(y,x);
			}
		}
	}
	private static void buildCol(int y, int x) {
		int roadLength=1;
		int height = map[y][x];
		if(x==0) {
			for(int i=1; i<N; i++) {
				if(height-map[y][i]==0) roadLength++;
				else if(height-map[y][i]==1) {
					if(N-i<X) return;
					else {
						for(int j=1; j<X; j++) {
							if(height-map[y][++i] !=1) return;
						}
					}
					height = map[y][i];
					roadLength=0;
				}
				else if(height-map[y][i]==-1) {
					if(roadLength>=X) {
						height=map[y][i];
						roadLength=1;
					}
					else return;
				}
				else return;
			}
//			System.out.println("case C // y : "+y+" x : "+x);
			ans++;
		}
	}
	private static void buildRow(int y, int x) {
		int roadLength=1;
		int height = map[y][x];
		if(y==0) {
			for(int i=1; i<N; i++) {
				if(height-map[i][x]==0) roadLength++;
				else if(height-map[i][x]==1) {
					if(N-i<X) return;
					else {
						for(int j=1; j<X; j++) {
							if(height-map[++i][x] !=1) return;
						}
					}
					height = map[i][x];
					roadLength=0;
				}
				else if(height-map[i][x]==-1) {
					if(roadLength>=X) {
						height=map[i][x];
						roadLength=1;
					}
					else return;
				}
				else return;
			}
//			System.out.println("case R // y : "+y+" x : "+x);
			ans++;
		}
	}

}
