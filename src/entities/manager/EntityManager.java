package entities.manager;

import components.component_templates.Component;
import components.component_templates.StateSpaceComponent;
import components.food_components.FoodRenderComponent;
import contants.Direction;
import entities.Apple;
import entities.Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EntityManager {

    private ArrayList<Component> components;
    private HashMap<String, ArrayList<Entity>> map;

    public EntityManager() {
        components = new ArrayList<>();
        map = new HashMap<>();
    }

    public void createEntity() {
        Apple apple = new Apple(new StateSpaceComponent(0, 0, 20, Direction.NONE),
                new FoodRenderComponent(new Color(167, 231, 153)), 1);

        /*components.add("StateSpaceComponent");
        components.add("FoodRenderComponent");

        if (!map.get("StateSpaceComponent").add(apple)) {
            map.put("StateSpaceComponent", new ArrayList<>());
            map.get("StateSpaceComponent").add(apple);*/
    }


    public void update() {
        for (Component c : components) {

        }
    }

    public void draw(Graphics g) {

    }
}
