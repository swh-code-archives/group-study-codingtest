package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon2018 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int start = 1, end = 1, sum = 1, count = 1;
        while(end != n) {
            if (sum == n) {
                count++;
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
