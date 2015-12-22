/**
 * Player.java
 * @author quastra
 */

package com.quastra.outer.reaches.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.quastra.outer.reaches.components.TransformComponent;

public class Player extends Actor{

    private Entity entity;
    private Texture texture;
    private String texturePath = "assets/Textures/player_ship.png";

    public Entity getEntity() {
        return entity;
    }
    private TransformComponent transform;

    public Player() {
        entity = new Entity();
        entity.add(new TransformComponent());
        transform = entity.getComponent(TransformComponent.class);
        transform.position = new Vector2(0, 0);
        texture = new Texture(Gdx.files.internal(texturePath));
        setBounds(transform.position.x, transform.position.y, texture.getWidth(), texture.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY());
    }

}
