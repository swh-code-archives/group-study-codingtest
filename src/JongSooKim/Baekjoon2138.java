package JongSooKim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2138 {
    private static int [] dx = {0,1,0,-1}; // 좌우
    private static int [] dy = {1,0,-1,0}; // 상하
    private static boolean [][] visit; // 방문 여부
    private static int[][] arr; // 미로
    private static int n;
    private static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j) - 48;
            }
        }

//        System.out.println("n = " + n);
//        System.out.println("m = " + m);
//        for(int [] x : arr){
//            for(int y : x){
//                System.out.print("" + y + " ");
//            }
//            System.out.println();
//        }

        bfs(0,0);
//        for(int [] x : arr){
//            for(int y : x){
//                System.out.print("" + y + " ");
//            }
//            System.out.println();
//        }
        System.out.println(arr[n-1][m-1]);
    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y}); // 첫번째 노드 큐에 삽입
        while(!q.isEmpty()){
            int [] node = q.poll(); // 첫번째 노드 큐에서 꺼내고,
            visit[x][y] = true; // 방문처리
            for(int i = 0; i < 4; i++){
                int xPoint = node[0] + dx[i];
                int yPoint = node[1] + dy[i];

                if((xPoint >= 0 && xPoint < n) && (yPoint >= 0 && yPoint < m)){ // 미로 맵 밖을 벗어나지 않도록.
                    if(!visit[xPoint][yPoint] && arr[xPoint][yPoint] != 0){ // 방문하지 않았으며, 갈 수 있는 길 일때
                        visit[xPoint][yPoint] = true; // 방문처리
                        arr[xPoint][yPoint] = arr[node[0]][node[1]]+1; // depth 업데이트
                        q.offer(new int[]{xPoint,yPoint}); // 갈 수 있는 길을 큐에 업데이트
                    }
                }
            }
        }

    }
}
