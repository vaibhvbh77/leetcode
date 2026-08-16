class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int fleets = 0;
        int n = position.length;

        int[][] newSpeed = new int[n][2];

        double previousTime = 0;

        // Store position and speed together
        for (int i = 0; i < n; i++) {
            newSpeed[i][0] = position[i];
            newSpeed[i][1] = speed[i];
        }

        // Closest to target first
        Arrays.sort(newSpeed, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {

            // Calculate time to reach target
            double time =
                (double)(target - newSpeed[i][0]) / newSpeed[i][1];

            // Cannot catch the fleet ahead
            // so this becomes a new fleet
            if (time > previousTime) {
                previousTime = time;
                fleets++;
            }
        }

        return fleets;
    }
}