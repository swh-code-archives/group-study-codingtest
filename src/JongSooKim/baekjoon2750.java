package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2750 {
    public static void main(String[] args) throws IOException {
        //선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //풀이
        //버블 정렬
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(arr[i] > arr[j]){
                    int swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }
        }

        //결과
        for(int x : arr){
            System.out.println(x);
        }
    }
}
