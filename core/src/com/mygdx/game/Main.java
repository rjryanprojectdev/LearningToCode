package com.mygdx.game;


import Sprites.Player;
import com.badlogic.gdx.ApplicationAdapter;

public class Main extends ApplicationAdapter {

	Map map = new Map();
	Player player = new Player();
	
	@Override
	public void create () {
        map.create();
        player.create();
	}

	@Override
	public void render () {
        map.render();
        player.render();
	}

	public void resize () {

    }


	@Override
	public void dispose () {
		map.dispose();
	}
}
