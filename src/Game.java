public class Game {
    int width, height, size, xunits, yunits;
    GameFrame frame;
    public Board board;

    private double delta;
    private boolean running = false;

    long startTime;
    static Game game;

    public Game(int size, int width, int height){
        game = this;

        this.width = width;
        this.height = height;
        this.size = size;
        this.xunits = width/size;
        this.yunits = height/size;

        this.board = new Board(xunits,yunits);
        this.frame = new GameFrame(width, height, size);

        this.board.setOpen(5,5);
        this.board.setOpen(11,11);
        this.board.setOpenMine(2,yunits-1);
        this.board.setOpenMine(3,2);
        this.board.setOpenMine(6,4);
        this.board.setClosedMine(1,1);

        run();
    }

    public void run(){
        running = true;
        long lastloop = System.nanoTime();
        startTime = (lastloop / 1000000);


        while (running) {
            long now = System.nanoTime();

            if((now-lastloop)/1000000 >= 5){
                frame.repaint();

                lastloop = now;
            }
        }
    }

    public static Game getGame(){
        return game;
    }

    public Board getBoard(){
        return board;
    }
}
