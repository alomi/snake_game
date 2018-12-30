package contants;

import java.awt.event.KeyEvent;
import java.util.HashMap;

import static contants.Direction.*;

public class Constants {
    public static final int SCREEN_WIDTH = 900, SCREEN_HEIGHT = 900;
    public static final int ROWS = 30, COLS = 30;
    public static HashMap<Integer, Direction> keyMap;
    public static HashMap<Direction, Direction> opposite;
    public static HashMap<Direction, Integer> dirMap;

    static {
        keyMap = new HashMap<>();
        keyMap.put(KeyEvent.VK_LEFT, LEFT);
        keyMap.put(KeyEvent.VK_RIGHT, RIGHT);
        keyMap.put(KeyEvent.VK_UP, UP);
        keyMap.put(KeyEvent.VK_DOWN, DOWN);

        opposite = new HashMap<>();
        opposite.put(LEFT, RIGHT);
        opposite.put(RIGHT, LEFT);
        opposite.put(UP, DOWN);
        opposite.put(DOWN, UP);

        dirMap = new HashMap<>();
        dirMap.put(UP, -30);
        dirMap.put(DOWN, 30);
        dirMap.put(LEFT, -30);
        dirMap.put(RIGHT, 30);
    }
}
