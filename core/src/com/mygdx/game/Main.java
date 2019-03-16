package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;

public class Main extends ApplicationAdapter {

	Map map = new Map();

	@Override
	public void create () {
		map.create();
	}

	@Override
	public void render () {
		map.render();
	}

	public void resize () {

	}


	@Override
	public void dispose () {
		map.dispose();
	}
}