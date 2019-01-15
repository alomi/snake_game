package entities;

import components.component_templates.StateSpaceComponent;
import main.GamePanel;

import java.awt.*;

public abstract class Entity {

    StateSpaceComponent stateSpace;
    boolean alive;

    public Entity(StateSpaceComponent stateSpace, int startLength) {
        this.stateSpace = stateSpace;

        stateSpace.setLength(startLength);
        alive = true;
    }

    public void update(GamePanel world) {
    }

    public abstract void draw(Graphics g);

    public void keyPressed(int k) {
    }

    public int getX() {
        return stateSpace.getX();
    }

    public int getY() {
        return stateSpace.getY();
    }

    public int getLength() {
        return stateSpace.getLength();
    }

    public boolean equalPosition(StateSpaceComponent other) {
        return stateSpace.samePosition(other);
    }

    public StateSpaceComponent getStateSpace() {
        return stateSpace;
    }

    public boolean isAlive() {
        return isAlive();
    }

    public void kill() {
        alive = false;
    }
}
