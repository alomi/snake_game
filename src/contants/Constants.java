package contants;

import java.awt.event.KeyEvent;
import java.util.HashMap;

import static contants.Direction.*;

public class Constants {
    public static final int SCREEN_WIDTH = 900, SCREEN_HEIGHT = 900;
    public static final int ROWS = 30, COLS = 30;

    public static HashMap<Direction, Direction> opposite;

    static {
        opposite = new HashMap<>();
        opposite.put(LEFT, RIGHT);
        opposite.put(RIGHT, LEFT);
        opposite.put(UP, DOWN);
        opposite.put(DOWN, UP);
    }
}
