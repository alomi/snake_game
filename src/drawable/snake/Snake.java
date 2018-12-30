package drawable.snake;

import drawable.Drawable;
import drawable.food.Food;
import drawable.model.SnakeModel;

import java.awt.*;

import static contants.Constants.*;
import static drawable.snake.Directions.*;

public class Snake implements Drawable {

    public int length;
    private int[] xpos = new int[SCREEN_WIDTH];
    private int[] ypos = new int[SCREEN_HEIGHT];
    private SnakeModel model;
    private Directions direction;
    private boolean alive;

    public Snake(int x, int y, int startLength, SnakeModel model) {
        this.model = model;

        xpos[0] = x;
        ypos[0] = y;
        length = 1;

        init(startLength);
    }

    private void init(int startLength) {

        for (int i = 1; i < startLength; i++) {
            xpos[i] = xpos[i - 1] + 30;
            ypos[i] = ypos[i - 1] + 30;
            length++;
        }

        alive = true;
        direction = UP;
    }


    public void draw(Graphics g) {
        model.setXpos(xpos);
        model.setYpos(ypos);
        model.draw(g, length);
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
            xpos[z] = xpos[z-1];
            ypos[z] = ypos[z-1];
        }

        //FIXA
        if (direction == UP || direction == DOWN)
            ypos[0] += dirMap.get(direction);
        if (direction == RIGHT || direction == LEFT)
            xpos[0] += dirMap.get(direction);
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
