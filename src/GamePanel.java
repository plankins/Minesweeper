import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int width, height, size, xunits, yunits;
    Board board;
    Game game = Game.getGame();
    InputHandler inputHandler;

    public GamePanel(int width, int height, int size){
        this.width = width;
        this.height = height;
        this.size = size;
        this.xunits = width/size;
        this.yunits = height/size;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(width+size, height+size));
        inputHandler = new InputHandler();
        this.addMouseListener(inputHandler);
        board = Game.game.getBoard();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
    /*
    geöffnete Mine: 3
    geschlossene Mine: 2
    geöffnet: 1
    geschlossen: 0
    */
        for (int x = 0; x < xunits; x++) {
            for (int y = 0; y < yunits; y++) {
                if(board.isOpenMine(x,y)){
                    g.setColor(Color.red);
                    drawRect(g,Color.red, x,y,size);
               // } else if(board.isClosedMine(x,y)){
                    //weißes viereck
                } else if(board.isOpen(x,y)){
                    drawCross(g,Color.GRAY,x,y,size);

                //} else if (board.isClosed(x, y)) {

                }

            }

        }


        g.setColor(Color.black);
        for (int i = 0; i <= xunits; i++) {
            g.drawLine(size*i,0,size*i,height);
        }
        for (int i = 0; i <= yunits; i++) {
            g.drawLine(0,size*i,width,size*i);
        }

    }

    public void drawCross(Graphics g, Color c, int x, int y, int size) {
        g.setColor(c);
        g.drawLine(x*size,y*size,x*size+size, x*size+size);
        g.drawLine(x*size+size,y*size,x*size, x*size+size);



    }

    public void drawRect(Graphics g,Color c, int x, int y, int size){
        g.setColor(c);
        g.fillRect(x*size,y*size,size,size);

    }
}
