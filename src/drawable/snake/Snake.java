package drawable.snake;

import drawable.Drawable;
import drawable.food.Food;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import static contants.Constants.SCREEN_HEIGHT;
import static contants.Constants.SCREEN_WIDTH;
import static drawable.snake.Directions.*;

public class Snake implements Drawable {

    private int size;
    public int length;
    private Color color;
    private int[] xpos = new int[SCREEN_WIDTH];
    private int[] ypos = new int[SCREEN_HEIGHT];
    private Directions direction;
    private HashMap<Integer, Directions> keyMap;
    private HashMap<Directions, Directions> opposite;
    HashMap<Directions, Integer> dirMap;

    private boolean alive;

    public Snake(int x, int y, int size, Color color) {
        this.size = size;
        this.color = color;

        xpos[0] = x;
        ypos[0] = y;
        length = 1;

        init();
    }

    private void init() {
        for (int i = 1; i < 0; i++) {
            xpos[i] = xpos[i-1] + 30;
            ypos[i] = ypos[i-1] + 30;
            length++;
        }

        alive = true;
        direction = UP;

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
        dirMap.put(UP, - 30);
        dirMap.put(DOWN, 30);
        dirMap.put(LEFT, -30);
        dirMap.put(RIGHT, 30);
    }


    public void draw(Graphics g) {
        g.setColor(color);

        for (int i = 0; i < length; i++) {
            g.fillRect(xpos[i], ypos[i], size, size);
        }
    }

    public void keyPressed(int keyCode) {
        if (!keyMap.containsKey(keyCode))
            return;

        Directions cur = direction;


        direction = keyMap.get(keyCode);

        if (cur == opposite.get(direction))
            direction = cur;
    }

    public void update(Food food) {
        move();
        handleCollision(food);
        handleCollision();
        checkBounds();
    }

    private void handleCollision() {
        for (int i = 1; i < length; i++)
            if (xpos[0] == xpos[i] && ypos[0] == ypos[i])
                alive = false;
    }

    private void move() {

        for (int z = length; z > 0; z--) {
            xpos[z] = xpos[(z - 1)];
            ypos[z] = ypos[(z - 1)];
        }

        if (direction == UP || direction == DOWN)
            ypos[0] = ypos[0] + dirMap.get(direction);
        if (direction == RIGHT || direction == LEFT)
            xpos[0] = xpos[0] + dirMap.get(direction);
    }

    private void checkBounds() {
        if (xpos[0] < 0)
            xpos[0] = SCREEN_WIDTH;
        else if (xpos[0] >= SCREEN_WIDTH)
            xpos[0] = 0;

        if (ypos[0] < 0)
            ypos[0] = SCREEN_HEIGHT;

        else if (ypos[0] >= SCREEN_HEIGHT)
            ypos[0] = 0;
    }

    private void handleCollision(Food food) {
        if (xpos[0] == food.x && ypos[0] == food.y) {
            food.despawn();

            xpos[length + 1] = xpos[length] + 30;
            ypos[length + 1] = ypos[length] + 30;
            length++;
        }
    }

    public boolean isAlive() {
        return alive;
    }
}
