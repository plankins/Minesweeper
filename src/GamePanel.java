import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int width, height, size, xunits, yunits;
    Board board;
    Game game = Game.getGame();
    public GamePanel(int width, int height, int size){
        this.width = width;
        this.height = height;
        this.size = size;
        this.xunits = width/size;
        this.yunits = height/size;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(width+size, height+size));
        board = Game.game.getBoard();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        for (int i = 0; i <= xunits+1; i++) {
            g.drawLine(xunits*i,0,xunits*i,height);
        }
        for (int i = 0; i <= yunits+1; i++) {
            g.drawLine(0,yunits*i,width,yunits*i);
        }

            /*
    geöffnete Mine: 3
    geschlossene Mine: 2
    geöffnet: 1
    geschlossen: 0
     */
        for (int x = 0; x <= xunits; x++) {
            for (int y = 0; y <= yunits; y++) {
                if(board.isOpenMine(x,y)){
                    drawRect(g,Color.red, x,y,size);
               // } else if(board.isClosedMine(x,y)){
                    //weißes viereck
                } else if(board.isOpen(x,y)){
                    //drawCross(g,Color.GRAY,x,y,size);

                //} else if (board.isClosed(x, y)) {

                }

            }

        }

    }

    public void drawCross(Graphics g, Color c, int x, int y, int size) {
        g.setColor(c);
        g.drawLine(x,y,x+size-1,y+size-1);
        g.drawLine(x,y+size-1, x+size-1,y);

    }

    public void drawRect(Graphics g,Color c, int x, int y, int size){
        g.setColor(c);
        g.fillRect(x*size+1,y*size+1,size-1,size-1);
    }
}
