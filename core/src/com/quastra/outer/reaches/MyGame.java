/**
 * MyGame.java
 * @author quastra
 */

package com.quastra.outer.reaches;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.ArrayMap;
import com.quastra.outer.reaches.entities.Player;

import java.util.Iterator;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	World world;
	Stage currentStage;
	ArrayMap<String, Stage> stages;

	@Override
	public void create() {

		batch = new SpriteBatch();
		stages = new ArrayMap<>();
		stages.put("Game Stage", new Stage(new ScreenViewport()));
		currentStage = stages.get("Game Stage");
		currentStage.addActor( new Player());

	}

	@Override
	public void dispose() {
		Iterator<ObjectMap.Entry<String, Stage>> stageIterator = stages.iterator();
		while(stageIterator.hasNext()) {
			stageIterator.next().value.dispose();
		}
	}

	@Override
	public void resize (int width, int height) {
		currentStage.getViewport().update(width, height, true);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		currentStage.act(Gdx.graphics.getDeltaTime());
		currentStage.draw();
	}
}
