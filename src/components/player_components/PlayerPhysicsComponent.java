package components.player_components;

import components.component_templates.PhysicsComponent;
import components.component_templates.StateSpaceComponent;
import gameobjects.GameObject;
import main.GamePanel;

public class PlayerPhysicsComponent extends PhysicsComponent {

    @Override
    public void update(GameObject object, GamePanel world) {

        StateSpaceComponent state = object.stateSpace;

        world.handleCollision(state);

        for (int i = 1; i < state.length; i++){
            if (state.xpos[0] == state.xpos[i] && state.ypos[0] == state.ypos[i]){
                object.alive = false;
            }
        }
    }
}
