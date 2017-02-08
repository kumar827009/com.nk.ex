package ds;

import java.util.Arrays;

/**
 * Created by NKumar on 2/3/2017.
 */
/*
    Given a 2D array. This algorithm finds the Minimum cost of path from (0,0) to (m-1,n-1)
    This uses dynamic programming approach to solving the problem.
 */
public class MinimumCostPathJ {
    public int minCost(int A[][], int m, int n) {

        int solMatrix[][] = new int[m + 1][n + 1];
        solMatrix[0][0] = A[0][0];
        for (int col = 1; col <= n; col++) {
            solMatrix[0][col] = A[0][col] + solMatrix[0][col - 1];
        }

        for (int row = 1; row <= m; row++) {
            solMatrix[row][0] = A[row][0] + solMatrix[row - 1][0];
        }
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                solMatrix[row][col] = A[row][col] + Math.min(solMatrix[row - 1][col], solMatrix[row][col - 1]);
            }
        }
        System.out.println(Arrays.deepToString(solMatrix));
        return solMatrix[m][n];
    }

    public static void main(String[] as) {
        int[][] A = {
                {1, 7, 9, 2},
                {8, 6, 3, 2},
                {1, 6, 7, 8},
                {2, 9, 8, 2}
        };
        MinimumCostPathJ minCostPath = new MinimumCostPathJ();
        System.out.println("Minimum Cost Path : " + minCostPath.minCost(A, A.length - 1, A[0].length - 1));
        System.out.println(A[0].length);
        System.out.println(A.length);
    }
}
