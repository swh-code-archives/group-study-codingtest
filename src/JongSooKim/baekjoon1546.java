package JongSooKim;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int max = Arrays.stream(arr).max().getAsInt();
        double avr = 0;
        double sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        System.out.println(sum * 100 / max / n);
    }
}
