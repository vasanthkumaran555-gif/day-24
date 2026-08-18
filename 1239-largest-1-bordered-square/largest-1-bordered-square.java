class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int rowPrefix[][] = new int[n][m];
        int colPrefix[][] = new int[n][m];
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(grid[i][j] == 1) {
                    rowPrefix[i][j] = 1 + (j>0 ? rowPrefix[i][j-1] : 0);
                    colPrefix[i][j] = 1 + (i>0 ? colPrefix[i-1][j] : 0);
                }
            }
        }

        int maxSide = 0;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                int bottom = rowPrefix[i][j];
                int right = colPrefix[i][j];
                int k = Math.min(bottom, right);
                while(k > maxSide) {
                    int top = rowPrefix[i-k+1][j];
                    int left = colPrefix[i][j-k+1];
                    if(top >= k && left >= k) {
                        maxSide = k;
                        break;
                    }
                    --k;
                }
            }
        }
        int maxArea = maxSide * maxSide;

        return maxArea;
    }
}
