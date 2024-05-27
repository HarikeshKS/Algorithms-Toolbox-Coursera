public class LCS3 {

    // Function to find the length of LCS of three sequences
    public static int lcsOf3(String X, String Y, String Z) {
        int m = X.length();
        int n = Y.length();
        int o = Z.length();

        // Create a 3D array to store lengths of longest common subsequence.
        int[][][] L = new int[m + 1][n + 1][o + 1];

        // Building the L[m+1][n+1][o+1] in bottom up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= o; k++) {
                    if (i == 0 || j == 0 || k == 0)
                        L[i][j][k] = 0;
                    else if (X.charAt(i - 1) == Y.charAt(j - 1) && X.charAt(i - 1) == Z.charAt(k - 1))
                        L[i][j][k] = L[i - 1][j - 1][k - 1] + 1;
                    else
                        L[i][j][k] = Math.max(Math.max(L[i - 1][j][k], L[i][j - 1][k]), L[i][j][k - 1]);
                }
            }
        }

        // L[m][n][o] contains the length of LCS for X[0..m-1], Y[0..n-1] and Z[0..o-1]
        return L[m][n][o];
    }

    public static void main(String[] args) {
        String X = "AGGT12";
        String Y = "12TXAYB";
        String Z = "12XBA";

        System.out.println("Length of LCS is " + lcsOf3(X, Y, Z));
    }
}
