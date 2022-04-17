package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < n; i++){
            int findNumber = arr[i];
            int start = 0;
            int end = n - 1;
            while(start < end){
                if(arr[start] + arr[end] == findNumber){
                    if(start != i && end != i){
                        count++;
                        break;
                    }else if(start == i){
                        start++;
                    }else if(end == i){
                        end --;
                    }
                }else if(arr[start] + arr[end] < findNumber){
                    start++;
                }else{
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}
