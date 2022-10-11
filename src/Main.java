import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Random rdm = new Random();

    public static void main(String[] args) {
        char[][] grid = new char[11][21];
        Map gameMap = new Map(rdm.nextInt(grid.length), (rdm.nextInt(grid[0].length)));
        Player player = new Player(rdm.nextInt(grid.length), rdm.nextInt(grid[0].length), grid.length, grid[0].length,'@');
        Compass compass = new Compass(gameMap.getEscapeX(), gameMap.getEscapeY());
        char move;
        int game = 1;

        gameMap.fillMap(grid);

        //game loop
        while(game == 1) {
            gameMap.fillMap(grid);
            gameMap.printMap(grid, player);
            //System.out.println("X: "+player.getX()+" Y: "+player.getY());
            //System.out.println("Escape X: "+gameMap.getEscapeX()+" Escape Y: "+gameMap.getEscapeY());
            compass.drawCompass(player.getX(), player.getY());
            System.out.println("Where do you want to move?");
            System.out.println(ConsoleColours.WHITE_BRIGHT + "W:" + ConsoleColours.YELLOW_BRIGHT + " UP");
            System.out.println(ConsoleColours.WHITE_BRIGHT + "S:" + ConsoleColours.YELLOW_BRIGHT + " DOWN");
            System.out.println(ConsoleColours.WHITE_BRIGHT + "A:" + ConsoleColours.YELLOW_BRIGHT + " LEFT");
            System.out.println(ConsoleColours.WHITE_BRIGHT + "D:" + ConsoleColours.YELLOW_BRIGHT + " RIGHT");
            System.out.println(ConsoleColours.WHITE_BRIGHT + "X:" + ConsoleColours.YELLOW_BRIGHT + " DIG" + ConsoleColours.RESET);
            move = scanner.next().charAt(0);
            move = Character.toUpperCase(move);
            if(move != 'X') {
                player.playerMove(move);
            } else {
                game = player.playerDig(gameMap.getEscapeX(), gameMap.getEscapeY());
            }
        }
    }
}