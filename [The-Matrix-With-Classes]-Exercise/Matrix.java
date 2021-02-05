import java.util.Arrays;
import java.util.List;

public class Matrix {
    private int rows;
    private int cols;
    private char[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new char[this.rows][this.cols];
    }

    public void setMatrix(List<String> lines) {
        for (int row = 0; row < lines.size(); row++) {
            this.matrix[row] = lines.get(row).toCharArray();
        }
    }

    public char getCell(int row, int col) {
        return this.matrix[row][col];
    }

    public void setCell(int row, int col, char fillColor) {
        this.matrix[row][col] = fillColor;
    }

    public boolean isOutOfBounds(int row, int col) {
        return row >= rows || row < 0 || col >= cols || col < 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                builder.append(matrix[row][col]);
            }
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }
}
