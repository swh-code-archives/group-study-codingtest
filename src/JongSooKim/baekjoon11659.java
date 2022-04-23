package JongSooKim;

import java.util.Scanner;

public class baekjoon11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        int [] s = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        //구간 합 배열 생성
        s[0] = arr[0];
        for(int i = 1; i < n; i++){
            s[i] = s[i-1] + arr[i];
        }

        for(int i = 0; i < m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            // 0 보다 작아지는 경우는 1 ~ x 까지의 합이니까, 뺼 게 없음.
            if(start - 2 >= 0)
                System.out.println(s[end-1] - s[start - 2]);
            else
                System.out.println(s[end-1]);
        }
    }
}
