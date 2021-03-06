package constants;

/**
* Collected constants of simple_pacman app.
*
* This class is non extendable and non-instantiable.
* All members of this class are immutable.
*/

public final class ConstantVariables {	// by declaring final, class is made non-extendable

    // GameDisplay constants
    public static final int WINDOW_WIDTH = 464;  // was 696: tiles will be 24 x 24? to go with maze.txt dimensions
    public static final int WINDOW_HEIGHT = 562;	//512  // was 768
    public static final int TILE_SIZE = 24;
    public static final int DISPLAY_INITIAL_X = (WINDOW_WIDTH / 2) - 8;
    public static final int DISPLAY_INITIAL_Y = (WINDOW_HEIGHT / 2) - 40; //WINDOW_HEIGHT / 2 - 16; or -30
    public static final int DISPLAY_INITIAL_E = 17;
    public static final int SCOREBOARD_HEIGHT = 50;

  // AnimationApp constants
    public static final int WORLD_WIDTH = 464; // was 656
    public static final int WORLD_HEIGHT = 512; // was 272;
    public static final int NUM_COL = 29;	// was WORLD_WIDTH / 16
    public static final int NUM_ROWS = 32;	// was WORLD_HEIGHT / 16
    public static final int INITIAL_X = (NUM_COL / 2);  // was (NUM_COL / 2)-1
    public static final int INITIAL_Y = (NUM_ROWS / 2) - 1;
    public static final int INITIAL_E_X = 2; // temp was (NUM_COL / 2) - 1;
    public static final int INITIAL_E_Y = 2;  // temporary was (NUM_ROWS / 2) - 5;
    public static final char WALL_CHAR = 'X';
    public static final char COIN_CHAR = '.';
    public static final char EMPTY_CHAR = ' ';
    public static final char AV_CHAR = 'A';
    public static final char AI_CHAR = 'E';
    public static final int MOVE_AMNT = 16; // was 24
    public static final int SPACES_IN_MID = 15;

    // Coin constants
    public static final int C_DIM = 4;
    public static final int COIN_OFFSET = 6;

    // MovableItem constants (also happen to be the constants for Wall)
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;

    // private constructor so class is non-instantiable
    private ConstantVariables() {

    }
}
