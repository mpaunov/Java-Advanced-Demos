import java.util.ArrayDeque;

public class DFSSTack implements Strategy {
    @Override
    public void solve(int row, int col, char colorToReplace, char fillColor, Matrix matrix) {
        ArrayDeque<int[]> indexses = new ArrayDeque<>();

        indexses.push(new int[]{row, col});

        while (!indexses.isEmpty()) {
            int[] rowAndCol = indexses.pop();
            row = rowAndCol[0];
            col = rowAndCol[1];
            matrix.setCell(rowAndCol[0], rowAndCol[1], fillColor);

            if (!matrix.isOutOfBounds(row + 1, col)
                    && matrix.getCell(row + 1, col) == colorToReplace) {
                indexses.push(new int[]{row + 1, col});
            }
            if (!matrix.isOutOfBounds(row - 1, col)
                    && matrix.getCell(row - 1, col) == colorToReplace) {
                indexses.push(new int[]{row - 1, col});
            }
            if (!matrix.isOutOfBounds(row, col + 1)
                    && matrix.getCell(row, col + 1) == colorToReplace) {
                indexses.push(new int[]{row, col + 1});
            }
            if (!matrix.isOutOfBounds(row, col - 1)
                    && matrix.getCell(row, col - 1) == colorToReplace) {
                indexses.push(new int[]{row, col - 1});
            }
        }
    }
}
