package components.component_templates;

import contants.Direction;
import entities.Entity;

import java.util.HashMap;

public abstract class KeyboardComponent extends Component {

    protected HashMap<Integer, Direction> keyMap;

    public KeyboardComponent(HashMap<Integer, Direction> keyMap) {
        this.keyMap = keyMap;
    }

    public abstract void keyPressed(Entity object, int k);

    public void keyReleased(Entity object, int k) {
    }
}
