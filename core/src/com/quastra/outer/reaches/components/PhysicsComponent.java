/**
 * PhysicsComponent.java
 * @author quastra
 */

package com.quastra.outer.reaches.components;


import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class PhysicsComponent implements Component{
    public Vector2 velocity;
    public Vector2 acceleration;
}
