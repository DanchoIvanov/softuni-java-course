package jedi_galaxy;

public class Galaxy {
    private int[][] galaxy;

    public Galaxy(int rows, int cols) {
        this.galaxy = createGalaxy(rows, cols);
    }

    public int[][] getGalaxy() {
        return galaxy;
    }

    private int[][] createGalaxy(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int value = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

    public boolean isInGalaxy(int row, int col){
        return row >= 0 && row < this.galaxy.length && col >= 0 && col < this.galaxy[0].length;
    }
}
