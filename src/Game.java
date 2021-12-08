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
        xunits = width/size;
        yunits = height/size;

        board = new Board(xunits,yunits);
        frame = new GameFrame(width, height, size);

        board.setOpen(5,5);
        board.setOpen(11,11);
        board.setOpenMine(2,2);

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
