package components.player_components;

import components.component_templates.InputComponent;
import components.component_templates.StateSpaceComponent;
import gameobjects.GameObject;

public class PlayerInputComponent extends InputComponent {

    @Override
    public void update(GameObject object) {

        StateSpaceComponent state = object.stateSpace;

        for (int z = state.length; z > 0; z--) {
            state.xpos[z] = state.xpos[z-1];
            state.ypos[z] = state.ypos[z-1];
        }

        switch (state.direction){
            case RIGHT:
                    state.xpos[0] += state.size;
                break;

            case LEFT:
                    state.xpos[0] -= state.size;
                break;

            case DOWN:
                    state.ypos[0] += state.size;
                break;

            case UP:
                    state.ypos[0] -= state.size;
                break;
        }
    }
}
