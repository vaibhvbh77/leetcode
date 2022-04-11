class Solution {
   	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < k; i++)
			shift(grid);

		for (int[] arr : grid) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < arr.length; i++)
				list.add(Integer.valueOf(arr[i]));
			res.add(list);
		}
		return res;
	}

	public static void shift(int[][] grid) {
		List<Integer> lastElements = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			lastElements.add(grid[i][grid[i].length - 1]);
		}
		for (int i = 0; i < grid.length; i++) {

			for (int j = grid[i].length - 1; j > 0; j--) {
				grid[i][j] = grid[i][j - 1];

			}

		}
		for (int i = 0; i < grid.length; i++)
			if (i != grid.length - 1)
				grid[i + 1][0] = lastElements.get(i);

		grid[0][0] = lastElements.get(lastElements.size() - 1);

	}
}