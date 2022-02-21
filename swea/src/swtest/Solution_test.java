package swtest;

import java.util.Scanner;

public class Solution_test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();
		int T = in.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int X = in.nextInt();
			int Y = in.nextInt();
			double sum=0;
			int a = X-1;
			int b= Y-1;
//			System.out.println(a+" "+b);
			double h=1/(double)2;
			sum= (a*b)*h;
			System.out.printf("#"+tc+" %.6f\n",sum);
		}
	}

}
