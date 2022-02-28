package d3;

import java.util.Scanner;

public class Solution_13038_교환학생 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = in.nextInt();
			
			int[] week = new int[7]; //각 요일에 수업열리는 여부
			for(int i=0; i<7; i++) {
				week[i]=in.nextInt();
			}
			int min = Integer.MAX_VALUE;
			for(int start=0; start<7; start++) {
				//수업이 시작하는 모든 요일 처리
				if(week[start]==0) continue; //수업이 열리지 않는 날은 패스
				
				int day=start, cnt=0;
				while(true) {
					if(week[day%7]==1) cnt++;
					++day; //하루 지남
					if(cnt==N) {	//머무른 최소일수
						if(cnt==N) min=Math.min(min, day-start);
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+min);
		}
	}

}
