package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1260 {
    private static List<Integer> [] list;
    private static boolean [] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 노드의 갯수
        int m = Integer.parseInt(st.nextToken()); // 간선의 갯수
        int k = Integer.parseInt(st.nextToken()); // 시작점

        visit = new boolean[n+1]; // 인덱스를 1번 부터 사용하기 위함.
        list = new ArrayList[n+1]; // 마찬가지로

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<Integer>(); // 인접리스트 표현
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        //방문 할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것을 먼저 방문.
        //방문 할 수 있는 정점이 여러개라는건 인접리스트에 2개 이상의 노드가 존재 한다는거고
        //작은거부터니까 정렬
        for(int i = 1; i < list.length; i++){
            Collections.sort(list[i]);
        }

//        for(int i = 1; i < list.length; i++){
//            System.out.print(i + " -> ");
//            for(int j = 0; j < list[i].size(); j++){
//                System.out.print(list[i].get(j)+" ");
//            }
//            System.out.println();
//        }
//        System.out.print("dfs : ");
        dfs(k);
        System.out.println();
        visit = new boolean[n+1];
//        System.out.print("bfs : ");
        bfs(k);
    }

    public static void dfs(int v){
        if(visit[v]) return; // 방문했으면 종료
        visit[v] = true; // 안했으면 방문 처리
        System.out.print(v+" ");
        for(int i = 0; i < list[v].size(); i++){
            dfs(list[v].get(i));
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>(); // bfs를 위한 큐 선언
        visit[v] = true; // 방문처리
        q.add(v); // 시작 노드 추가
        while(!q.isEmpty()){
            int node = q.poll(); // 큐에서 꺼낸 뒤
            System.out.print(node+" ");
            for(int i = 0; i < list[node].size(); i++){
                if(!visit[list[node].get(i)]){ // 방문처리 안되어있는 것만
                    visit[list[node].get(i)] = true;
                    q.add(list[node].get(i)); // 인접 노드 다시 삽입
                }
            }
        }
    }
}
