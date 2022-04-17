package JongSooKim;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int start = 0, end = arr.length-1, count = 0, sum = arr[start] + arr[end];
        while(start < end){
            if(sum == target){
               count++;
               start ++;
               end --;
               sum = arr[start] + arr[end];
            }else if(sum < target){
                sum -= arr[start++];
                sum += arr[start];
            }else{
                sum -= arr[end--];
                sum += arr[end];
            }
        }
        System.out.println(count);
    }
}
