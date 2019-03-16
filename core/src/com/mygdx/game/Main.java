package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Main extends ApplicationAdapter {

	Map map = new Map();

	private Player player;
	private SpriteBatch sb;
	private OrthographicCamera cam;
	private float delta;

	@Override
	public void create () {
		map.create();
		cam = new OrthographicCamera();
		cam.setToOrtho(false,map.TILEWIDTH,map.TILEHEIGHT);

	}

	@Override
	public void render () {
		map.render();
		map.renderer.setView(cam);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		delta = Gdx.graphics.getDeltaTime();

		// updates
		player.update(delta);

		// rendering
		sb.begin();
		player.render(sb);
		sb.end();
	}

	public void resize () {

	}


	@Override
	public void dispose () {
		map.dispose();
	}
}