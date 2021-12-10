public class Board {
    feld[][] boardArray;
    int xunits, yunits;

    public enum feld{
        GESCHLOSSEN, OFFEN, MINE_GESCHLOSSEN, MINE_OFFEN, MARKIERT
    }

    public Board(int x, int y) {
        this.boardArray = new feld[x][y];
        this.xunits = x;
        this.yunits = y;

        for (int xx = 0; xx < xunits; xx++) {
            for (int yy = 0; yy < yunits; yy++) {
                boardArray[xx][yy] = feld.GESCHLOSSEN;
            }

        }
    }

    public void set(int x, int y, feld state) {
            this.boardArray[x][y] = state;
    }

    public feld getState(int x, int y) {
        if (x < 0 || x > xunits - 1 || y < 0 || y > yunits - 1) {
            return feld.GESCHLOSSEN;
        } else {
            return boardArray[x][y];
        }
    }
    /*
    geöffnete Mine: 3
    geschlossene Mine: 2
    geöffnet: 1
    geschlossen: 0
     */

    public boolean isOpenMine(int x, int y){
        if(getState(x,y) == feld.MINE_OFFEN){
            return true;
        }
        return false;
    }

    public boolean isClosedMine(int x, int y){
        if(getState(x,y) == feld.MINE_GESCHLOSSEN){
            return true;
        }
        return false;
    }

    public boolean isOpen(int x, int y){
        if(getState(x,y) == feld.OFFEN){
            return true;
        }
        return false;
    }

    public boolean isClosed(int x, int y){
        if(getState(x,y) == feld.GESCHLOSSEN){
            return true;
        }
        return false;
    }

    public boolean isMarked(int x, int y){
        if(getState(x,y) == feld.MARKIERT){
            return true;
        }
        return false;
    }

    public void setOpenMine(int x, int y) {
            this.boardArray[x][y] = feld.MINE_OFFEN;
    }

    public void setClosedMine(int x, int y) {
            this.boardArray[x][y] = feld.MINE_GESCHLOSSEN;
    }

    public void setClosed(int x, int y) {
            this.boardArray[x][y] = feld.GESCHLOSSEN;

    }

    public void setOpen(int x, int y) {
        this.boardArray[x][y] = feld.OFFEN;
    }

    public void setMarked(int x, int y) {
        this.boardArray[x][y] = feld.MARKIERT;
    }

    public void shuffleMines(int mineCnt){
        for (int i = 0; i < mineCnt; i++) {
            int x = (int) (Math.random() * xunits);
            int y = (int) (Math.random() * yunits);
            setClosedMine(x,y);

        }
    }

    public int countNeighborMines(int x, int y){
    int count = 0;
        if(getState(x-1, y-1) == feld.MINE_GESCHLOSSEN || getState(x-1,y-1) == feld.MINE_OFFEN){
            count++;
        }
        if(getState(x, y-1) == feld.MINE_GESCHLOSSEN || getState(x,y-1) == feld.MINE_OFFEN){
            count++;
        }
        if(getState(x+1, y-1) == feld.MINE_GESCHLOSSEN || getState(x+1,y-1) == feld.MINE_OFFEN){
            count++;
        }

        if(getState(x-1, y+1) == feld.MINE_GESCHLOSSEN || getState(x-1,y+1) == feld.MINE_OFFEN){
            count++;
        }
        if(getState(x, y+1) == feld.MINE_GESCHLOSSEN || getState(x,y+1) == feld.MINE_OFFEN){
            count++;
        }
        if(getState(x+1, y+1) == feld.MINE_GESCHLOSSEN || getState(x+1,y+1) == feld.MINE_OFFEN){
            count++;
        }

        if(getState(x-1, y) == feld.MINE_GESCHLOSSEN || getState(x-1,y) == feld.MINE_OFFEN){
            count++;
        }
        if(getState(x+1, y) == feld.MINE_GESCHLOSSEN || getState(x+1,y) == feld.MINE_OFFEN){
            count++;
        }

    return count;
    }

    public void click(int x, int y){
        feld clicked = getState(x,y);
        switch (clicked){
            case GESCHLOSSEN:
                setOpen(x,y);
                break;
            case OFFEN:
                break;
            case MINE_OFFEN:
                break;
            case MINE_GESCHLOSSEN:
                setOpenMine(x,y);
                break;
        }
    }
}
