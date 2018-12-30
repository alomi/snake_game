package components.component_templates;

import contants.Direction;
import gameobjects.GameObject;

import java.util.HashMap;

public abstract class KeyboardComponent {

    protected HashMap<Integer, Direction> keyMap;

    public KeyboardComponent(HashMap<Integer, Direction> keyMap) {
        this.keyMap = keyMap;
    }

    public abstract void keyPressed(GameObject object, int k);

    public void keyReleased(GameObject object, int k) {
    }
}
