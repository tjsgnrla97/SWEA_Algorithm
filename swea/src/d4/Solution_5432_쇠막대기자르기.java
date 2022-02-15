package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5432_쇠막대기자르기 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int T,sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> stack = new Stack<Character>();
		T=Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			sum=0;
			String arr = in.readLine();
			char[] charArr=new char[arr.length()];
			for(int i=0; i<arr.length(); i++) {
				charArr[i] = arr.charAt(i);
			}
			for(int i=0; i<arr.length(); i++) {
				if(charArr[i]=='(') {
					stack.push(charArr[i]);
				}
				if(charArr[i]==')' && charArr[i-1]=='(') {
					stack.pop();
					sum += stack.size();
				}
				if(charArr[i]==')'&&charArr[i-1]==')') {
					stack.pop();
					sum+=1;
				}
			}
			sb.append("#"+tc+" "+sum+"\n");
		}
		out.write(sb.toString());
		in.close();
		out.flush();
		out.close();
	}

}
