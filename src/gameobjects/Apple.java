package gameobjects;

import components.food_components.FoodRenderComponent;
import components.component_templates.StateSpaceComponent;
import main.GamePanel;

import java.awt.*;
import java.util.Random;

public class Apple extends GameObject {

    FoodRenderComponent render;

    public Apple(StateSpaceComponent stateSpace, FoodRenderComponent render) {
        super(stateSpace);
        this.render = render;
    }

    public void update(GamePanel world){
        if (!alive)
            spawn();
    }

    public void despawn() {
        alive = false;
        stateSpace.xpos[0] =- stateSpace.size * 10;
    }

    private void spawn() {
        Random random = new Random();

        stateSpace.xpos[0] = random.nextInt(30 - 1) * 30;
        stateSpace.ypos[0] = random.nextInt(30 - 1) * 30;

        alive = true;
    }

    @Override
    public void draw(Graphics g) {
        render.draw(stateSpace, g);
    }
}
