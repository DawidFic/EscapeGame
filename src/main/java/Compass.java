import java.io.Console;

public class Compass {

    private int escapeX, escapeY;

    public void drawCompass(int playerX, int playerY) {
        if(playerX > escapeX && playerY == escapeY) { //NORTH
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"  N  ");
            System.out.println("  |  ");
            System.out.println(ConsoleColours.RESET + "W-"+ConsoleColours.CYAN_BOLD_BRIGHT+"o"+ConsoleColours.RESET+"-E");
            System.out.println("  |  ");
            System.out.println("  S  \n");
        } else if (playerX > escapeX && playerY < escapeY) { //NORTH-EAST
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"  N  ");
            System.out.println("  |  ");
            System.out.println(ConsoleColours.RESET + "W-" + ConsoleColours.CYAN_BOLD_BRIGHT+"o-E"+ConsoleColours.RESET);
            System.out.println("  |  ");
            System.out.println("  S  \n");
        } else if (playerX == escapeX && playerY < escapeY) { //EAST
            System.out.println("  N  ");
            System.out.println("  |  ");
            System.out.println(ConsoleColours.RESET + "W-"+ConsoleColours.CYAN_BOLD_BRIGHT+"o-E"+ConsoleColours.RESET);
            System.out.println("  |  ");
            System.out.println("  S  \n");
        } else if (playerX < escapeX && playerY < escapeY) { //SOUTH-EAST
            System.out.println("  N  ");
            System.out.println("  |  ");
            System.out.println(ConsoleColours.RESET + "W-"+ConsoleColours.CYAN_BOLD_BRIGHT+"o-E");
            System.out.println("  |  ");
            System.out.println("  S  \n"+ConsoleColours.RESET);
        } else if (playerX < escapeX && playerY == escapeY) { //SOUTH
            System.out.println("  N  ");
            System.out.println("  |  ");
            System.out.println("W-"+ConsoleColours.CYAN_BOLD_BRIGHT+"o"+ConsoleColours.RESET+"-E");
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"  |  ");
            System.out.println("  S  \n"+ConsoleColours.RESET);
        } else if (playerX < escapeX && playerY > escapeY) { //SOUTH-WEST
            System.out.println("  N  ");
            System.out.println("  |  ");
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"W-o"+ConsoleColours.RESET+"-E");
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"  |  ");
            System.out.println("  S  \n"+ConsoleColours.RESET);
        } else if (playerX == escapeX && playerY > escapeY) { //WEST
            System.out.println("  N  ");
            System.out.println("  |  ");
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"W-o"+ConsoleColours.RESET+"-E");
            System.out.println("  |  ");
            System.out.println("  S  \n");
        } else if (playerX > escapeX && playerY > escapeY) { //NORTH-WEST
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"  N  ");
            System.out.println("  |  ");
            System.out.println("W-o"+ConsoleColours.RESET+"-E");
            System.out.println("  |  ");
            System.out.println("  S  \n");
        } else if (playerX == escapeX && escapeY == escapeY) { //CENTER
            System.out.println("  N  ");
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"  |  "+ConsoleColours.RESET);
            System.out.println("W"+ConsoleColours.RESET+ConsoleColours.CYAN_BOLD_BRIGHT+"-"+ConsoleColours.RED_BOLD_BRIGHT+"o"+ConsoleColours.CYAN_BOLD_BRIGHT+"-"+ConsoleColours.RESET+"E");
            System.out.println(ConsoleColours.CYAN_BOLD_BRIGHT+"  |  ");
            System.out.println(ConsoleColours.RESET+"  S  \n");
        }
    }

    public Compass(int escapeX, int escapeY) {
        this.escapeX = escapeX;
        this.escapeY = escapeY;
    }
}
