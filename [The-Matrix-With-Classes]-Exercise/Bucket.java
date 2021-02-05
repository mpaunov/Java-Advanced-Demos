public class Bucket {
    private int row;
    private int col;
    private char colorToReplace;
    private Matrix matrix;

    public Bucket(int row, int col, Matrix matrix) {
        this.row = row;
        this.col = col;
        this.colorToReplace = matrix.getCell(row, col);
        this.matrix = matrix;
    }

    public void paint(char fillColor, Strategy DFSRecursive) {
        DFSRecursive.solve(row, col, colorToReplace, fillColor, matrix);
    }
}
