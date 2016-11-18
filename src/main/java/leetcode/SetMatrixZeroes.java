package leetcode;

/**
 * Created by bruce on 14-11-8.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
           return;
        }
        int n = matrix[0].length;
        if(n==0) {
            return;
        }
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int k = 0;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0) {
                    k=1;
                    line[j] = 1;
                }
            }
            if(k==1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(line[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1]= 2;
        matrix[0][2] =3;
        matrix[0][3]= 2;
        matrix[1][0]=2;
        matrix[1][2]=0;
        matrix[1][1]=3;
        matrix[1][3]= 2;
        matrix[2][0]=2;
        matrix[2][2]=4;
        matrix[2][1]=0;
        matrix[2][3]= 2;
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
