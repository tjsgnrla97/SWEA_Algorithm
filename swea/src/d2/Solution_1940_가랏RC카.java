package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1940_가랏RC카 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int T,N,sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(in.readLine());
			int speed = 0;
			int dis = 0;
			for(int i=0; i<N; i++) {
				stk=new StringTokenizer(in.readLine());
				int cnt=Integer.parseInt(stk.nextToken());
				if(cnt == 1) {
					speed += Integer.parseInt(stk.nextToken());
				}else if(cnt ==2) {
					speed -= Integer.parseInt(stk.nextToken());
				}else if(cnt==0) {
					
				}
				if(speed<0) speed = 0;
				dis += speed;
			}
			sb.append("#"+tc+" "+dis+"\n");
		}
		out.write(sb.toString());
		in.close();
		out.flush();
		out.close();
	}

}
