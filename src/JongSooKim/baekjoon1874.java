package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int num = 1; // 오름차순 수
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int su = arr[i]; // 현재 수열의 수
            if(su >= num){ // 현재 수열 값 >= 오름차순 : 자연수 값이 같아질 때 까지 push
                while(su >= num){
                    stack.push(num++);
                    sb.append("+ \n");
                }
                stack.pop();
                sb.append("- \n");
            }else{ // 현재 수열 값 < 오름차순 자연수 : pop으로 수열 원소 제거
                int k = stack.pop();
                if(k > su){ // 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열 출력 불가능.
                    System.out.println("NO");
                    return;
                }else{
                    sb.append("- \n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
