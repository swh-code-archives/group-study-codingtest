package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2606 {
    private static boolean [] visit;
    private static ArrayList<Integer>[] listArr;
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴터의 개수 (노드)
        int m = Integer.parseInt(br.readLine()); // 직접 연결된 쌍의 수 (간선)
        visit = new boolean[n + 1]; // 방문 횟수 체크
        listArr = new ArrayList[n + 1]; // 이 부분엔 왜 <Integer> 제너릭 처리가 안되나용

        for(int i = 1; i < n+1; i++){
            listArr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){
            //listArr 배열 내에 ArrayList는 간선의 연결 상태
            String [] str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            listArr[s].add(e);
            listArr[e].add(s);
        }

//        for(int i = 1; i < listArr.length; i++){
//            System.out.print(i+" -> ");
//            for(int j = 0; j < listArr[i].size(); j++){
//                System.out.print(listArr[i].get(j)+" ");
//            }
//            System.out.println();
//        }
        dfs(1);
        for(boolean b : visit){
            if(b) result++;
        }
        System.out.println(result-1); // 1번 컴퓨터가 감염 시킨 컴퓨터의 수 이므로, 1번 컴퓨터는 최종 결과에서 제외.

    }
    public static void dfs(int v){
        if(visit[v]) return; // 이미 방문 이력이 있다면 return;
        visit[v] = true; // 방문 이력이 없다면 생성
        for(int x : listArr[v]){
            dfs(x); // listArr 배열 내에, List는 간선의 연결을 나타내므로 전체 확인
        }
    }
}
