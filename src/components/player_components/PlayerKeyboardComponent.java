package components.player_components;

import components.component_templates.KeyboardComponent;
import components.component_templates.StateSpaceComponent;
import contants.Direction;
import entities.Entity;

import java.util.HashMap;

import static contants.Constants.opposite;

public class PlayerKeyboardComponent extends KeyboardComponent {


    public PlayerKeyboardComponent(HashMap<Integer, Direction> keyMap) {
        super(keyMap);
    }

    @Override
    public void keyPressed(Entity object, int k) {

        StateSpaceComponent state = object.getStateSpace();

        if (!keyMap.containsKey(k))
            return;

        Direction cur = state.getDirection();

        state.setDirection(keyMap.get(k));

        if (cur == opposite.get(state.getDirection()))
            state.setDirection(cur);

    }
}
