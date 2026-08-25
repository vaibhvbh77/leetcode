class Solution {
    boolean visited[];

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        Queue<Integer> q = new ArrayDeque<>();

           visited[0] = true;
        q.offer(0);
        // for (int i : rooms.get(0)) {
        //     q.add(i);
        // }

        bfs(rooms, q);

        for (boolean i : visited) {
            if (!i) {
                return false;
            }
        }
        return true;

    }

    public void bfs(List<List<Integer>> rooms, Queue<Integer> q) {

        while (!q.isEmpty()) {

            int element = q.poll();

            for (int i : rooms.get(element)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);

                }
            }

        }

    }
}