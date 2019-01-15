package entities;

import components.component_templates.StateSpaceComponent;
import components.food_components.FoodRenderComponent;
import main.GamePanel;

import java.awt.*;
import java.util.Random;

import static contants.Constants.COLS;
import static contants.Constants.ROWS;

public class Apple extends Entity {

    FoodRenderComponent render;

    public Apple(StateSpaceComponent stateSpace, FoodRenderComponent render, int length) {
        super(stateSpace, length);
        this.render = render;
    }

    public void update(GamePanel world) {
        if (!alive)
            spawn();
    }

    public void despawn() {
        alive = false;
        stateSpace.setX(-stateSpace.getSize() * 10);
    }

    private void spawn() {
        Random random = new Random();

        stateSpace.setX(random.nextInt(30 - 1) * ROWS);
        stateSpace.setY(random.nextInt(30 - 1) * COLS);

        alive = true;
    }

    @Override
    public void draw(Graphics g) {
        render.draw(stateSpace, g);
    }
}
