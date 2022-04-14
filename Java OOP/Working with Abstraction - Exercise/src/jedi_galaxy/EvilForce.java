package jedi_galaxy;

public class EvilForce {

    private int evilForceRow;
    private int evilForceCol;

    public EvilForce(int evilForceRow, int evilForceCol) {
        this.evilForceRow = evilForceRow;
        this.evilForceCol = evilForceCol;
    }

    public void destroyGalaxy(Galaxy galaxy){
        while (evilForceRow >= 0 && evilForceCol >= 0)
        {
            if (galaxy.isInGalaxy(evilForceRow, evilForceCol))
            {
                galaxy.getGalaxy()[evilForceRow] [evilForceCol] = 0;
            }
            evilForceRow--;
            evilForceCol--;
        }
    }
}
