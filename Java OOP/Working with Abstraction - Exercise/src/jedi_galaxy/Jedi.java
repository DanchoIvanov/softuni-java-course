package jedi_galaxy;

public class Jedi {

    private int jediRow;
    private int jediCol;
    private long starsSum;

    public Jedi(int jediRow, int jediCol) {
        this.jediRow = jediRow;
        this.jediCol = jediCol;
    }

    public long getStarsSum(Galaxy galaxy){
        while (jediRow >= 0 && jediCol < galaxy.getGalaxy()[1].length)
        {
            if (galaxy.isInGalaxy(jediRow, jediCol))
            {
                starsSum += galaxy.getGalaxy()[jediRow][jediCol];
            }

            jediCol++;
            jediRow--;
        }
        return starsSum;
    }
}
