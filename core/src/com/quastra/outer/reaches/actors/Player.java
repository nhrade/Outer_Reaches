/**
 * Player.java
 * @author quastra
 */

package com.quastra.outer.reaches.actors;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Color;
import com.quastra.outer.reaches.MyGame;
import com.quastra.outer.reaches.components.SpriteComponent;

public class Player extends Actor{

    private Entity entity;
    private Texture texture;
    public Entity getEntity() {
        return entity;
    }
    public SpriteComponent spriteComponent;
    private String texturePath = "assets/Textures/player_ship.png";

    private MyGame game;

    public Player(MyGame game) {
        entity = new Entity();
        this.game = game;
        game.getEngine().addEntity(entity);
        entity.add(new SpriteComponent());
        spriteComponent = entity.getComponent(SpriteComponent.class);
        spriteComponent.sprite = new Sprite(new Texture(Gdx.files.internal(texturePath)));
        spriteComponent.sprite.setPosition(0, 0);
        spriteComponent.sprite.setScale(0.3f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        spriteComponent.sprite.draw(batch);
    }

}
