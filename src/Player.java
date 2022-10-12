import java.util.Random;

public class Player {
    int x, y, maxX, maxY, lastX, lastY, score, hp, game, rndNumber;
    char playerSymbol;

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
            case 'W':
                this.x--;
                checkXBounds();
                break;
            case 'S':
                this.x++;
                checkXBounds();
                break;
            case 'A':
                this.y--;
                checkYBounds();
                break;
            case 'D':
                this.y++;
                checkYBounds();
                break;
        }
    }

    private boolean checkLastDig()
    {
        if (x == lastX && y == lastY) {
            return true;
        } else {
            return false;
        }
    }

    public int playerDig(int escapeX, int escapeY) {
        if(x == escapeX && y == escapeY) {
            System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT+"SUCCESS YOU HAVE MANGED TO ESCAPE!!");
            System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT+"SCORE: "+ConsoleColours.RED_BOLD_BRIGHT+getScore()+ConsoleColours.RESET);
            this.game = 0;
        } else {
            rndNumber = random.nextInt(100);
            if(rndNumber <= 10) { //JEWEL
                if (checkLastDig() == false) {
                    score += 100;
                    System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT + "YOU HAVE FOUND A " + ConsoleColours.PURPLE_BOLD_BRIGHT + "RARE JEWEL " + ConsoleColours.WHITE_BOLD_BRIGHT + "WORTH: " + ConsoleColours.YELLOW_BOLD_BRIGHT + "100 POINTS!" + ConsoleColours.RESET);
                    game = 1;
                    lastX = x;
                    lastY = y;
                } else {
                    rndNumber = 62; //GO TO NOTHING
                }
            } else if (rndNumber >= 11 && rndNumber <= 20) { //ROLEX
                if (checkLastDig() == false) {
                    score += 70;
                    System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT + "YOU HAVE FOUND A " + ConsoleColours.YELLOW_BOLD_BRIGHT + "ROLEX " + ConsoleColours.WHITE_BOLD_BRIGHT + "WORTH: " + ConsoleColours.YELLOW_BOLD_BRIGHT + "70 POINTS!" + ConsoleColours.RESET);
                    game = 1;
                    lastX = x;
                    lastY = y;
                } else {
                    rndNumber = 62; //GO TO NOTHING
                }
            } else if (rndNumber >= 21 && rndNumber <=35) { //ANCIENT RELIC
                if (checkLastDig() == false) {
                    score += 30;
                    System.out.println(ConsoleColours.WHITE_BOLD_BRIGHT + "YOU HAVE FOUND A " + ConsoleColours.GREEN_BOLD_BRIGHT + "ANCIENT RELIC " + ConsoleColours.WHITE_BOLD_BRIGHT + "WORTH: " + ConsoleColours.YELLOW_BOLD_BRIGHT + "30 POINTS!" + ConsoleColours.RESET);
                    game = 1;
                    lastX = x;
                    lastY = y;
                } else {
                    rndNumber = 62; //GO TO NOTHING
                }
            } else if (rndNumber >= 36 && rndNumber<=60) { //BOMB
                if (checkLastDig() == false) {
                    score -= 100;
                    hp -= 20;
                    System.out.println(ConsoleColours.RED_BOLD_BRIGHT + "YOU SET OFF A BOMB, YOU HAVE LOST 100 POINTS AND 20HP" + ConsoleColours.RESET);
                    game = 1;
                } else {
                    rndNumber = 62; //GO TO NOTHING
                }
            } else if (rndNumber >=61 && rndNumber<=100) { //NOTHING
                score -= 10;
                System.out.println(ConsoleColours.RED_BOLD_BRIGHT+"NOTHING TO BE FOUND HERE"+ConsoleColours.RESET);
                game = 1;
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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
