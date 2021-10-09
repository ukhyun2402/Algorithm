/*
 * URL: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 * TITLE: Number of Ways to Arrive at Destination
 * DIFFICULTY: MEDIUM
 * */

import java.util.*;

/*
 * n개의 구역이 있는 도시에 당신은 위치해 있습니다. 각 구격은 사이를 오갈 수 있는 도로가 있습니다.
 * 입력된 값은 하나 이상의 도로를 거쳐 도달할 수 있습니다.
 *
 * 2차원 배열인 roads가 주어집니다. road[i] = [u_i, v_i, time_i]로 구성되어 있으며 u_i와 v_i는 도시를 나타냅니다.
 * time_i는 도로를 이용하면 걸리는 시간입니다. 0 번에서 마지막번호(n-1) 구역으로 가는 최소시간이 걸리는 방법의 갯수를 반환하세요
 * */
public class P1976 {
    int count = 0;
    int MOD = (int) (1e9 + 7);
        public static void main(String[] args) {
        P1976 SOL = new P1976();
//        System.out.println(SOL.countPaths(7, new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
        System.out.println(SOL.countPaths(4, new int[][]
                {{0,1,2},{1,2,2},{0,3,2},{1,3,1},{2,3,2},{0,2,1}}
        ));
    }
//    public int countPaths(int n, int[][] roads) {
//        MIN = Integer.MAX_VALUE;
//        N = n;
//        count = 0;
//        ROADS = roads.clone();
//        intersections = new Intersection[N];
//        visited = new boolean[N];
//        ANSWER = new HashMap<>();
//
//        for (int[] road : roads) {
//            if (intersections[road[0]] == null) {
//                intersections[road[0]] = new Intersection();
//            }
//            if (intersections[road[1]] == null) {
//                intersections[road[1]] = new Intersection();
//            }
//            intersections[road[0]].connectedIntersection.put(road[1], road[2]);
//            intersections[road[1]].connectedIntersection.put(road[0], road[2]);
//        }
//        visited[0] = true;
//        dfs(0, 0);
//        System.out.println(ANSWER);
//        ArrayList<Integer> key = new ArrayList<>(ANSWER.keySet());
//        Collections.sort(key);
//        for(int a : key){
//            return ANSWER.get(a);
//        }
//        return -1;
//    }
//
//    public void dfs(int depth, int cur) {
//        if(depth > MIN) {
//            return;
//        }
//        if (cur == N - 1) {
//            if (!ANSWER.containsKey(depth)) {
//                ANSWER.put(depth, 0);
//            }
//            ANSWER.put(depth, ANSWER.get(depth) + 1);
//            return;
//        }
//        Intersection intersection = intersections[cur];
//        Set<Integer> keySet = intersection.connectedIntersection.keySet();
//        for (int k : keySet) {
//            if (!visited[k]) {
//                System.out.println(cur + " -> " + k);
//                visited[k] = true;
//                dfs(depth + intersection.connectedIntersection.get(k), k);
//                visited[k] = false;
//            }
//        }
//    }
//
//    class Intersection {
//        //        int numOfIntersection;
//        HashMap<Integer, Integer> connectedIntersection;
//
//        public Intersection() {
////            this.numOfIntersection = numOfIntersection;
//            this.connectedIntersection = new HashMap<>();
//        }
//    }

    public int shortestTimeToDest(int start, int dest, int n, Map<Integer, List<int[]>> graph) {
        // dijkstra
        // 각각의 점까지 최소 거리를 저장하기 위한 배열 선언
        int[] distances = new int[n];
        //다익스트라 알고리즘 실행을 위해 배열에 최대값 채워넣기
        Arrays.fill(distances, Integer.MAX_VALUE);
        //??
        int[] count = new int[n];
        // min heap
        // [vertex, cost]
        // 각 버텍스에 있는 값이 낮은 순서대로 정렬됨
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

        // 처음 시작하는 곳은 0으로 채워넣기 이는 현재의 노드에서 현재의 노드로 가는 것이기 떄문
        distances[start] = 0;
        // queue에 처음 버텍스 넣기
        pq.add(new int[]{start, 0});

        // 지점까지 갈수 있는 방법 갯수
        count[start] = 1;

        // 반복시작
        while (!pq.isEmpty()) {
            // 버텍스 추출
            int[] obj = pq.poll();
            // 버텍스 번호
            int u = obj[0];
            // 버텍스 가중치
            int cost_u = obj[1];
            // 현재 버텍스가 가지고 있는 값보다 cost가 큰 경우
            // 버텍스의 최소값을 유지.
            if (cost_u > distances[u])
                continue;
            // u 버텍스에 대한 이웃들 구함
            List<int[]> neighbors = graph.get(u);
            // 이웃들에 대한 정보를 반복문으로
            Iterator<int[]> it = neighbors.iterator();
            while (it.hasNext()) {
                // it은 이웃들 중 하나를 뜻함
                int[] edge = it.next();
                // 버텍스 번호
                int v = edge[0];
                // 버텍스 가중치
                int cost_uv = edge[1];
                // u => 현재 버텍스
                // 만약 현재 버텍스의 가중치와 간선의 가중치를 더한 값이 이전의 값보다 작은 경우
                if (distances[u] + cost_uv < distances[v]) {
                    // 그 버텍스 거리에다가 값을 새로 넣음
                    distances[v] = distances[u] + cost_uv;
                    // 그리고 나서 그 버텍스는 다시 검사를 해야 하니 Queue
                    pq.add(new int[]{v, distances[v]});
                    //
                    count[v] = count[u]; // found a better way to reach v
                } else if (distances[u] + cost_uv == distances[v]) {
                    count[v] = count[u] % MOD + count[v] % MOD; // found another same weight path
                }
            }
        }
        return count[n - 1] % MOD;
    }

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new LinkedList<int[]>());
        }
        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            int cost_uv = road[2];
            graph.get(u).add(new int[]{v, cost_uv});
            graph.get(v).add(new int[]{u, cost_uv});
        }
        return shortestTimeToDest(0, n-1, n, graph);
    }
}
