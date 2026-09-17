class Solution {

    static int count = 0;

    public int totalNQueens(int n) {

        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];

        solve(0, n, columns, diagonal1, diagonal2);

        return count;
    }

    static void solve(int row, int n,
                      boolean[] columns,
                      boolean[] diagonal1,
                      boolean[] diagonal2) {

        // All queens have been placed
        if (row == n) {
            count++;
            return;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            // Check column
            if (columns[col]) {
                continue;
            }

            // Calculate diagonal positions
            int d1 = row - col + n - 1;
            int d2 = row + col;

            // Check diagonals
            if (diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            // Place queen
            columns[col] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            // Move to next row
            solve(row + 1, n, columns, diagonal1, diagonal2);

            // Backtrack
            columns[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }

    // Main method for running in VS Code
    public static void main(String[] args) {

        int n = 4;

        Solution obj = new Solution();

        int answer = obj.totalNQueens(n);

        System.out.println("Number of solutions: " + answer);
    }
}