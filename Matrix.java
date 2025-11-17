public class Matrix {
    private final double[][] matrix;
    private final int rows;
    private final int cols;
    private final int nonZero;

    /**
     * Constructor with int array elements (will be converted to double after construction)
     *
     * @param rows number of rows in the matrix
     * @param cols number of columns in the matrix
     * @param nums array of elements in row-major order (left to right, top to bottom)
     * @throws IllegalArgumentException if rows/cols are invalid or array size doesn't match matrix dimensions
     */
    public Matrix(int rows, int cols, double[] nums) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Illegal rows and columns");
        } else if (nums.length != rows * cols) {
            throw new IllegalArgumentException("Illegal Matrix Size");
        }
        this.matrix = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
        for (int i = 0; i < rows; i++) {
            System.arraycopy(nums, i * cols, this.matrix[i], 0, cols);
        }
        this.nonZero = getMatrixNonZero();
    }

    /**
     * Constructor with double array elements
     *
     * @param rows number of rows in the matrix
     * @param cols number of columns in the matrix
     * @param nums array of elements in row-major order (left to right, top to bottom)
     * @throws IllegalArgumentException if rows/cols are invalid or array size doesn't match matrix dimensions
     */
    public Matrix(int rows, int cols, int[] nums) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Illegal rows and columns");
        } else if (nums.length != rows * cols) {
            throw new IllegalArgumentException("Illegal Matrix Size");
        }
        this.matrix = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix[i][j] = nums[i * cols + j];
            }
        }
        this.nonZero = getMatrixNonZero();
    }

    /**
     * Constructor for empty matrix (all elements initialized to zero)
     *
     * @param rows number of rows in the matrix
     * @param cols number of columns in the matrix
     * @throws IllegalArgumentException if rows/cols are invalid
     */
    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Illegal rows and columns");
        }
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
        this.nonZero = getMatrixNonZero();
    }

    /**
     * Constructor with 2D array
     *
     * @param matrix 2D array representing the matrix
     * @throws IllegalArgumentException if the input array is empty or invalid
     */
    public Matrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrix array");
        }
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.nonZero = getMatrixNonZero();
    }

    /**
     * Returns the number of rows in the matrix
     *
     * @return number of rows
     */
    public int getrows() {
        return rows;
    }

    /**
     * Returns the number of columns in the matrix
     *
     * @return number of columns
     */
    public int getcols() {
        return cols;
    }

    /**
     * Returns the underlying 2D array representation of the matrix
     *
     * @return 2D double array containing matrix elements
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * Prints the matrix in a formatted way to standard output
     * Automatically adjusts formatting based on value precision and handles negative numbers
     */
    public void printMatrix() {
        int l = 0;
        double a;
        boolean b = false;
        for (double[] value : this.matrix) {
            for (double i : value) {
                if (i == 0) {
                    a = 1;
                } else if (i < 0) {
                    b = true;
                    a = -1 * i;
                } else {
                    a = i;
                }
                if (Math.log10(a) > l) {
                    l = (int) (Math.log10(a));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int f;
        if (nonZero == 0) {
            f = -1;
        } else {
            f = nonZero;
        }
        if (b) {
            for (double[] ints : this.matrix) {
                sb.append("{");
                for (int j = 0; j < ints.length; j++) {
                    sb.append(String.format("% " + (l + 1 + f + 1) + "." + nonZero + "f", ints[j]));
                    if (j < ints.length - 1) {
                        sb.append(",");
                    } else {
                        sb.append("}\n");
                    }
                }
            }
        } else {
            for (double[] ints : this.matrix) {
                sb.append("{");
                for (int j = 0; j < ints.length; j++) {
                    sb.append(String.format("%" + (l + 1 + f + 1) + "." + nonZero + "f", ints[j]));
                    if (j < ints.length - 1) {
                        sb.append(",");
                    } else {
                        sb.append("}\n");
                    }
                }
            }
        }
        System.out.print(sb);
    }

    /**
     * Performs matrix addition with another matrix
     *
     * @param other the matrix to be added
     * @return new Matrix object containing the result of addition
     * @throws IllegalArgumentException if matrices have different dimensions or other matrix is null
     */
    public Matrix addition(Matrix other) {
        if (other == null || rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Illegal Matrix Size");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.getMatrix()[i][j] = other.getMatrix()[i][j] + matrix[i][j];
            }
        }
        return result;
    }

    /**
     * Performs matrix subtraction with another matrix
     *
     * @param other the matrix to be subtracted
     * @return new Matrix object containing the result of subtraction
     * @throws IllegalArgumentException if matrices have different dimensions or other matrix is null
     */
    public Matrix subtraction(Matrix other) {
        if (other == null || rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Illegal Matrix Size");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.getMatrix()[i][j] = matrix[i][j] - other.getMatrix()[i][j];
            }
        }
        return result;
    }

    /**
     * Performs scalar multiplication with the matrix
     *
     * @param k the scalar value to multiply with
     * @return new Matrix object containing the result of scalar multiplication
     */
    public Matrix multiplication(int k) {
        Matrix r = new Matrix(rows, cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                r.getMatrix()[i][j] = this.matrix[i][j] * k;
            }
        }
        return r;
    }

    /**
     * Performs left multiplication with another matrix (this * rightMatrix)
     *
     * @param rightMatrix the matrix to multiply on the right side
     * @return new Matrix object containing the result of multiplication
     * @throws IllegalArgumentException if matrices have incompatible dimensions or rightMatrix is null
     */
    public Matrix leftMultiplication(Matrix rightMatrix) {
        if (rightMatrix == null) {
            throw new IllegalArgumentException("Null Matrix");
        } else if (cols != rightMatrix.getrows()) {
            throw new IllegalArgumentException("Illegal Matrix Size");
        }

        double[][] result = new double[rows][rightMatrix.getcols()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rightMatrix.getcols(); j++) {
                for (int k = 0; k < cols; k++) {
                    result[i][j] += rightMatrix.getMatrix()[k][j] * matrix[i][k];
                }
            }
        }
        return new Matrix(result);
    }

    /**
     * Performs right multiplication with another matrix (leftMatrix * this)
     *
     * @param leftMatrix the matrix to multiply on the left side
     * @return new Matrix object containing the result of multiplication
     * @throws IllegalArgumentException if matrices have incompatible dimensions or leftMatrix is null
     */
    public Matrix rightMultiplication(Matrix leftMatrix) {
        if (leftMatrix == null) {
            throw new IllegalArgumentException("Null Matrix");
        } else if (rows != leftMatrix.getcols()) {
            throw new IllegalArgumentException("Illegal Matrix Size");
        }
        double[][] result = new double[leftMatrix.getrows()][cols];
        for (int i = 0; i < leftMatrix.getrows(); i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < leftMatrix.getcols(); k++) {
                    result[i][j] += leftMatrix.getMatrix()[i][k] * matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    /**
     * Computes the transpose of the matrix
     *
     * @return new Matrix object containing the transpose
     */
    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.getMatrix()[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    /**
     * Computes the determinant of the matrix (only for square matrices)
     *
     * @return the determinant value as double
     * @throws IllegalArgumentException if the matrix is not square
     */
    public double determinant() {
        if (rows != cols) {
            throw new IllegalArgumentException("Illegal Matrix Size");
        }
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        if (n > 2) {
            double result = 0;
            for (int i = 0; i < n; i++) {
                result += Math.pow(-1, i) * matrix[0][i] * new Matrix(getMinor(0, i)).determinant();
            }
            return result;
        }
        return 0;
    }

    /**
     * Creates a minor matrix by removing specified row and column
     *
     * @param rowToRemove the row index to remove (0-based)
     * @param colToRemove the column index to remove (0-based)
     * @return 2D double array representing the minor matrix
     */
    private double[][] getMinor(int rowToRemove, int colToRemove) {
        int n = matrix.length;
        double[][] minor = new double[n - 1][n - 1];
        int minorRow = 0;
        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;
            int minorCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }

    /**
     * Returns the minor matrix for specified row and column
     *
     * @param rowToRemove the row index to remove (0-based)
     * @param colToRemove the column index to remove (0-based)
     * @return Matrix object representing the minor matrix
     */
    public Matrix getMinorMatrix(int rowToRemove, int colToRemove) {
        return new Matrix(getMinor(rowToRemove, colToRemove));
    }

    /**
     * Computes the inverse of the matrix (only for square matrices)
     *
     * @return new Matrix object containing the inverse
     * @throws IllegalArgumentException if matrix is singular or not square
     */
    public Matrix inverse() {
        double det = determinant();
        if (Math.abs(det) < 1e-10) {
            throw new IllegalArgumentException("Matrix is singular and cannot be inverted");
        }

        int n = rows;
        Matrix result = new Matrix(n, n);
        Matrix augmented = new Matrix(n, 2 * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmented.getMatrix()[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            augmented.getMatrix()[i][i + n] = 1;
        }
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(augmented.getMatrix()[k][i]) > Math.abs(augmented.getMatrix()[maxRow][i])) {
                    maxRow = k;
                }
            }
            if (maxRow != i) {
                for (int j = 0; j < 2 * n; j++) {
                    double temp = augmented.getMatrix()[i][j];
                    augmented.getMatrix()[i][j] = augmented.getMatrix()[maxRow][j];
                    augmented.getMatrix()[maxRow][j] = temp;
                }
            }
            double pivot = augmented.getMatrix()[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmented.getMatrix()[i][j] /= pivot;
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmented.getMatrix()[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmented.getMatrix()[k][j] -= factor * augmented.getMatrix()[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.getMatrix()[i][j] = augmented.getMatrix()[i][j + n];
            }
        }
        return result;
    }

    /**
     * Computes the trace of the matrix (sum of diagonal elements)
     *
     * @return the trace value as double
     * @throws IllegalArgumentException if matrix is not square
     */
    public double trace() {
        if (rows != cols) {
            throw new IllegalArgumentException("Illegal Matrix Size");
        }
        double r = 0;
        for (int i = 0; i < rows; i++) {
            r += matrix[i][i];
        }
        return r;
    }

    /**
     * Computes the rank of the matrix using Gaussian elimination
     *
     * @return the rank of the matrix as integer
     */
    public int rank() {
        double[][] temp = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, temp[i], 0, cols);
        }
        int rank = 0;
        int lead = 0;
        for (int r = 0; r < rows && lead < cols; r++) {
            int i = r;
            while (i < rows && Math.abs(temp[i][lead]) < 1e-10) {
                i++;
            }
            if (i < rows) {
                if (i != r) {
                    double[] swap = temp[r];
                    temp[r] = temp[i];
                    temp[i] = swap;
                }
                double pivot = temp[r][lead];
                for (int j = lead; j < cols; j++) {
                    temp[r][j] /= pivot;
                }
                for (int k = 0; k < rows; k++) {
                    if (k != r) {
                        double factor = temp[k][lead];
                        for (int j = lead; j < cols; j++) {
                            temp[k][j] -= factor * temp[r][j];
                        }
                    }
                }
                rank++;
                lead++;
            } else {
                lead++;
                r--;
            }
        }
        return rank;
    }

    /**
     * Calculates the maximum number of non-zero decimal digits in matrix elements
     * If non-zero digits exceed 5, only 5 decimal places will be shown when printing
     *
     * @return maximum number of non-zero decimal digits
     */
    private int getMatrixNonZero() {
        int nonZero = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (nonZero < getNonZeroDecimalDigits(matrix[i][j])) {
                    nonZero = getNonZeroDecimalDigits(matrix[i][j]);
                }
            }
        }
        return nonZero;
    }

    /**
     * Extracts the decimal part of a number and counts non-zero digits
     *
     * @param number the input number
     * @return number of non-zero digits in the decimal part
     */
    private int getNonZeroDecimalDigits(double number) {
        String numberStr = String.valueOf(number);
        int decimalIndex = numberStr.indexOf('.');
        if (decimalIndex == -1) {
            return 0;
        }
        String decimalPart = numberStr.substring(decimalIndex + 1);
        return countNonZeroDigits(decimalPart);
    }

    /**
     * Counts non-zero digits in a string representing decimal part
     *
     * @param str string containing decimal digits
     * @return count of non-zero digits (maximum 5)
     */
    private int countNonZeroDigits(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '1' && c <= '9') {
                count++;
            }
        }
        if (count > 5) {
            count = 5;
        }
        return count;
    }

    /**
     * Compares this matrix with another matrix for equality
     *
     * @param other the matrix to compare with
     * @return true if matrices have same dimensions and all elements are equal, false otherwise
     */
    public boolean equals(Matrix other) {
        if (other == null) return false;
        if (rows == other.getrows() && cols == other.getcols()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (Math.abs(matrix[i][j] - other.getMatrix()[i][j]) > 1e-10) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
