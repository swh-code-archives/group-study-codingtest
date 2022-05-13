package JongSooKim;

//프로그래머스 타겟 넘버
public class TargetNumber {
    private static int answer = 0;
    public static void main(String[] args) {
        int [] arr = new int[]{4,1,2,1};
        int target = 4;

        dfs(arr, target, 0, 0);
        System.out.println(answer);
    }
    public static void dfs(int [] numbers, int target, int L, int sum){
        if(L == numbers.length){ // 주어진 숫자를 다 써야하므로
            if(sum == target) answer++;
            return;
        }
        dfs(numbers, target, L+1, sum+numbers[L]); // +인 경우의 수
        dfs(numbers, target, L+1, sum-numbers[L]); // -인 경우의 수
    }
}
