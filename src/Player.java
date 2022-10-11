public class Player {
    int x, y, maxX, maxY;
    char playerSymbol;


    public Player(int x, int y, int maxX, int maxY, char playerSymbol){
        this.x = x;
        this.y = y;
        this.maxX = maxX-1;
        this.maxY = maxY-1;
        this.playerSymbol = playerSymbol;
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

    public int playerDig(int escapeX, int escapeY) {
        if(x == escapeX && y == escapeY) {
            System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT+"SUCCESS YOU HAVE MANGED TO ESCAPE!!");
            return 0;
        } else {
            System.out.println(ConsoleColours.RED_BOLD_BRIGHT+"NOTHING TO BE FOUND HERE");
            return 1;
        }
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
}
