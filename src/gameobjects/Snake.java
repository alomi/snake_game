package gameobjects;

import components.player_components.PlayerInputComponent;
import components.player_components.PlayerKeyboardComponent;
import components.player_components.PlayerPhysicsComponent;
import components.player_components.PlayerRenderComponent;
import components.component_templates.StateSpaceComponent;

import main.GamePanel;

import java.awt.*;

public class Snake extends GameObject {

    private PlayerInputComponent input;
    private PlayerPhysicsComponent physics;
    private PlayerRenderComponent render;
    private PlayerKeyboardComponent keyboard;

    public Snake(StateSpaceComponent stateSpace,
                 PlayerInputComponent input,
                 PlayerPhysicsComponent physics,
                 PlayerRenderComponent render,
                 PlayerKeyboardComponent keyboard) {

        super(stateSpace);

        this.input = input;
        this.physics = physics;
        this.render = render;
        this.keyboard = keyboard;
    }

    public void update(GamePanel world) {
        if (alive) {
            input.update(this);
            physics.update(this, world);
        }
    }

    public void draw(Graphics g) {
        render.draw(stateSpace, g);
    }

    @Override
    public void keyPressed(int k) {
        keyboard.keyPressed(this, k);
    }
}
