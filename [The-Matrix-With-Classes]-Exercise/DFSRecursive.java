public class DFSRecursive implements Strategy {

    @Override
    public void solve(int row, int col, char colorToReplace, char fillColor, Matrix matrix) {
        paint(row, col, colorToReplace, fillColor, matrix);
    }

    private void paint(int row, int col, char colorToReplace, char fillColor, Matrix matrix) {
        if (matrix.isOutOfBounds(row, col)
                || matrix.getCell(row, col) != colorToReplace
                || matrix.getCell(row, col) == fillColor) {
            return;
        }

        matrix.setCell(row, col, fillColor);

        // Up
        paint(row - 1, col, colorToReplace, fillColor, matrix);
        // Down
        paint(row + 1, col, colorToReplace, fillColor, matrix);
        // Left
        paint(row, col - 1, colorToReplace, fillColor, matrix);
        // Right
        paint(row, col + 1, colorToReplace, fillColor, matrix);
    }
}
