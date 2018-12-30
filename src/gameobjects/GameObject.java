package gameobjects;

import components.component_templates.StateSpaceComponent;
import main.GamePanel;

import java.awt.*;

public abstract class GameObject {

    public StateSpaceComponent stateSpace;
    public boolean alive;

    public GameObject(StateSpaceComponent stateSpace){
        this.stateSpace = stateSpace;

        alive = true;
    }

    public void update(GamePanel world){}
    public abstract void draw(Graphics g);

    public void keyPressed(int k){

    }
}
