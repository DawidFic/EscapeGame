import java.util.Random;

public class Player {
    int x, y, maxX, maxY, lastX, lastY, score, hp, game, rndNumber;
    char playerSymbol;
    boolean playerMove = true;

    Random random = new Random();

    public Player(int x, int y, int maxX, int maxY, char playerSymbol, int score, int hp){
        this.x = x;
        this.y = y;
        this.maxX = maxX-1;
        this.maxY = maxY-1;
        this.playerSymbol = playerSymbol;
        this.score = score;
        this.hp = hp;
    }

    public void playerMove(char move) {
        switch (move) {
            case 'W' -> {
                this.x--;
                checkXBounds();
            }
            case 'S' -> {
                this.x++;
                checkXBounds();
            }
            case 'A' -> {
                this.y--;
                checkYBounds();
            }
            case 'D' -> {
                this.y++;
                checkYBounds();
            }
        }
        playerMove = true;
    }

    private void checkPlayerMove()
    {
        playerMove = x != lastX || y != lastY;
    }

    private void updateLastMove()
    {
        this.lastX = x;
        this.lastY = y;
    }

    public int playerDig(int escapeX, int escapeY) {
        if (x == escapeX && y == escapeY) {
            System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT + "SUCCESS YOU HAVE MANGED TO ESCAPE!!");
            System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT + "SCORE: " + ConsoleColours.RED_BOLD_BRIGHT + getScore() + ConsoleColours.RESET);
            this.game = 0;
        } else {
            this.rndNumber = random.nextInt(100);
            if (this.rndNumber >= 0 && this.rndNumber <= 10 && this.playerMove) { //JEWEL
                System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT + "YOU HAVE FOUND A " + ConsoleColours.PURPLE_BOLD_BRIGHT + "JEWEL " + ConsoleColours.WHITE_BOLD_BRIGHT + "WORTH: " + ConsoleColours.YELLOW_BOLD_BRIGHT + "100 POINTS!" + ConsoleColours.RESET);
                updateLastMove();
                checkPlayerMove();
                score += 100;
                this.game = 1;
            } else if (this.rndNumber >= 11 && this.rndNumber <= 25 && this.playerMove) { //ROLEX
                System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT + "YOU HAVE FOUND A " + ConsoleColours.YELLOW_BOLD_BRIGHT + "ROLEX " + ConsoleColours.WHITE_BOLD_BRIGHT + "WORTH: " + ConsoleColours.YELLOW_BOLD_BRIGHT + "50 POINTS!" + ConsoleColours.RESET);
                updateLastMove();
                checkPlayerMove();
                score += 50;
                this.game = 1;
            } else if (this.rndNumber >= 26 && this.rndNumber <= 40 && this.playerMove) { //ANCIENT RELIC
                System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT + "YOU HAVE FOUND A " + ConsoleColours.GREEN_BOLD_BRIGHT + "ANCIENT RELIC " + ConsoleColours.WHITE_BOLD_BRIGHT + "WORTH: " + ConsoleColours.YELLOW_BOLD_BRIGHT + "30 POINTS!" + ConsoleColours.RESET);
                updateLastMove();
                checkPlayerMove();
                score += 30;
                this.game = 1;
            } else if (this.rndNumber >= 41 && this.rndNumber <= 60 && this.playerMove) { //BOMB
                System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT + "YOU HAVE FOUND A " + ConsoleColours.RED_BOLD_BRIGHT + "BOMB " + ConsoleColours.WHITE_BOLD_BRIGHT + "YOU HAVE LOST: " + ConsoleColours.RED_BOLD_BRIGHT + "100 POINTS" + ConsoleColours.WHITE_BOLD_BRIGHT + " AND " + ConsoleColours.RED_BOLD_BRIGHT + "40 HEALTH" + ConsoleColours.RESET);
                updateLastMove();
                checkPlayerMove();
                score -= 100;
                hp -= 40;
                this.game = 1;
            } else if (this.rndNumber >= 61 && this.rndNumber <= 100 || !this.playerMove) { //NOTHING
                System.out.println(ConsoleColours.RED_BOLD_BRIGHT + "NOTHING TO BE FOUND HERE" + ConsoleColours.RESET);
                updateLastMove();
                checkPlayerMove();
                score -= 10;
                this.game = 1;
            }
        }
        return game;
    }

    private void checkXBounds() {
        if (this.x < 0) {
            this.x = this.maxX;
        } else if (this.x > this.maxX) {
            this.x = 0;
        }
    }

    private void checkYBounds() {
        if (this.y < 0) {
            this.y = this.maxY;
        } else if (this.y > this.maxY) {
            this.y = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public char getPlayerSymbol() {
        return playerSymbol;
    }


    public int getScore() {
        return score;
    }


    public int getHp() {
        return hp;
    }
}
