package entities;

import components.PointsComponent;
import components.component_templates.StateSpaceComponent;
import components.player_components.PlayerInputComponent;
import components.player_components.PlayerKeyboardComponent;
import components.player_components.PlayerPhysicsComponent;
import components.player_components.PlayerRenderComponent;
import main.GamePanel;

import java.awt.*;

public class Snake extends Entity {

    private PlayerInputComponent input;
    private PlayerPhysicsComponent physics;
    private PlayerRenderComponent render;
    private PlayerKeyboardComponent keyboard;
    private PointsComponent pointsComponent;

    private boolean moved;

    public Snake(StateSpaceComponent stateSpace,
                 PlayerInputComponent input,
                 PlayerPhysicsComponent physics,
                 PlayerRenderComponent render,
                 PlayerKeyboardComponent keyboard,
                 PointsComponent pointsComponent,
                 int length) {

        super(stateSpace, length);

        this.input = input;
        this.physics = physics;
        this.render = render;
        this.keyboard = keyboard;
        this.pointsComponent = pointsComponent;
    }

    public void update(GamePanel world) {
        if (alive) {
            input.update(this);
            physics.update(this, world);
        }
    }

    public void draw(Graphics g) {
        pointsComponent.draw(this, g);
        render.draw(stateSpace, g);

        moved = false;
    }

    @Override
    public void keyPressed(int k) {
        if (!moved)
            keyboard.keyPressed(this, k);
        moved = true;
    }
}
