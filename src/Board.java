public class Board {
    int[][] boardArray;
    int xunits, yunits;

    public Board(int x, int y) {
        this.boardArray = new int[x][y];
        this.xunits = x;
        this.yunits = y;
    }

    public void set(int x, int y, int state){
        this.boardArray[x][y] = state;
    }

    public int getState(int x, int y){
        if(x < 0 || x > xunits-1 || y < 0 || y > yunits-1){
            return 0;
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
        if(getState(x,y) == 3){
            return true;
        }
        return false;
    }

    public boolean isClosedMine(int x, int y){
        if(getState(x,y) == 2){
            return true;
        }
        return false;
    }

    public boolean isOpen(int x, int y){
        if(getState(x,y) == 1){
            return true;
        }
        return false;
    }

    public boolean isClosed(int x, int y){
        if(getState(x,y) == 0){
            return true;
        }
        return false;
    }

    public void setOpenMine(int x, int y) {
        this.boardArray[x][y] = 3;
    }

    public void setClosedMine(int x, int y) {
        this.boardArray[x][y] = 2;
    }

    public void setClosed(int x, int y) {
        this.boardArray[x][y] = 0;
    }

    public void setOpen(int x, int y) {
        this.boardArray[x][y] = 1;
    }

    public void click(int x, int y){
        int xx = x/xunits;
        int yy = y/yunits;
        int clicked = boardArray[xx][yy];
        switch (clicked){
            case 0:
                setOpen(xx,yy);
                break;
            case 1:
                break;
            case 2:
                setOpenMine(xx,yy);
                break;
            case 3:
                break;
        }
    }
}
