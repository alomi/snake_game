package components.player_components;

import components.component_templates.KeyboardComponent;
import components.component_templates.StateSpaceComponent;
import contants.Direction;
import gameobjects.GameObject;

import static contants.Constants.keyMap;
import static contants.Constants.opposite;

public class PlayerKeyboardComponent extends KeyboardComponent {

    @Override
    public void keyPressed(GameObject object, int k) {

        StateSpaceComponent state = object.stateSpace;
        if (!keyMap.containsKey(k))
            return;

        Direction cur = state.direction;

        state.direction = keyMap.get(k);

        if (cur == opposite.get(state.direction))
            state.direction = cur;

    }
}
