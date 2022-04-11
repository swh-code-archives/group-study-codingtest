package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2751 {
    public static void main(String[] args) throws IOException {
        //선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean [] arr = new boolean[2000001];
        for(int i = 0; i < n; i++){
            arr[Integer.parseInt(br.readLine())+1000000] = true;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++){
            if(arr[i]){
                sb.append(i-1000000).append("\n");
            }
        }
        System.out.println(sb.toString());
        //결과
        //        for(int x : arr){
//            System.out.print(x+" ");
//        }
//        System.out.println();
//        for(int x : counting){
//            System.out.print(x+" ");
//        }
//        System.out.println();
//        for(int x : result){
//            System.out.println(x+" ");
//        }
    }
}
