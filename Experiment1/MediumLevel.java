import java.util.Scanner;

public class MediumLevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions of the first matrix
        System.out.print("Enter the number of rows for Matrix 1: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix 1: ");
        int cols1 = scanner.nextInt();

        // Input dimensions of the second matrix
        System.out.print("Enter the number of rows for Matrix 2: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix 2: ");
        int cols2 = scanner.nextInt();

        // Input matrices
        System.out.println("Enter elements of Matrix 1:");
        int[][] matrix1 = inputMatrix(scanner, rows1, cols1);

        System.out.println("Enter elements of Matrix 2:");
        int[][] matrix2 = inputMatrix(scanner, rows2, cols2);

        // Perform operations
        if (rows1 == rows2 && cols1 == cols2) {
            System.out.println("Addition:");
            printMatrix(addMatrices(matrix1, matrix2));

            System.out.println("Subtraction:");
            printMatrix(subtractMatrices(matrix1, matrix2));
        } else {
            System.out.println("Addition and subtraction cannot be performed due to mismatched dimensions.");
        }

        if (cols1 == rows2) {
            System.out.println("Multiplication:");
            printMatrix(multiplyMatrices(matrix1, matrix2));
        } else {
            System.out.println("Multiplication cannot be performed due to mismatched dimensions.");
        }
    }

    // Method to input a matrix
    private static int[][] inputMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Method to add two matrices
    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    private static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to print a matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
