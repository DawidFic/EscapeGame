public class Map {
    private final int escapeX, escapeY;
    public static void fillMap(char[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                grid[x][y] = '.';
            }
        }
    }

    public void printMap(char[][] map, Player player) {
        System.out.println(ConsoleColours.RED_BOLD_BRIGHT +"+---------------------+"+ ConsoleColours.RESET);
        for(int i=0; i<map.length; i++) {
            System.out.print(ConsoleColours.RED_BOLD_BRIGHT + "|" + ConsoleColours.RESET);
            for(int j=0; j<map[0].length; j++) {
                if(i == player.getX() && j == player.getY()) {
                    System.out.print(ConsoleColours.CYAN_BOLD_BRIGHT+player.getPlayerSymbol());
                } else {
                    System.out.print(ConsoleColours.GREEN + map[i][j]);

                }
            }
            System.out.println(ConsoleColours.RED_BOLD_BRIGHT + "|" + ConsoleColours.RESET);
        }
        System.out.println(ConsoleColours.RED_BOLD_BRIGHT +"+---------------------+"+ ConsoleColours.RESET);
    }

    public int getEscapeX() {
        return escapeX;
    }


    public int getEscapeY() {
        return escapeY;
    }

    public Map(int escapeX, int escapeY) {
        this.escapeX = escapeX;
        this.escapeY = escapeY;
    }

}
