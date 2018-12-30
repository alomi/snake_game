package gameobjects;

import components.food_components.FoodRenderComponent;
import components.component_templates.StateSpaceComponent;
import main.GamePanel;

import java.awt.*;
import java.util.Random;

public class Apple extends GameObject {

    FoodRenderComponent render;

    public Apple(StateSpaceComponent stateSpace, FoodRenderComponent render, int length) {
        super(stateSpace, length);
        this.render = render;
        spawn();
    }

    public void update(GamePanel world){
        if (!alive)
            spawn();
    }

    public void despawn() {
        alive = false;
        stateSpace.setX(-stateSpace.getSize() * 10);
    }

    private void spawn() {
        Random random = new Random();

        stateSpace.setX(random.nextInt(30 - 1) * 30);
        stateSpace.setY(random.nextInt(30 - 1) * 30);

        alive = true;
    }

    @Override
    public void draw(Graphics g) {
        render.draw(stateSpace, g);
    }
}
