package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map extends ApplicationAdapter {

    private TiledMap gameMap;
    private AssetManager manager;
    public OrthographicCamera viewPort;
    public OrthogonalTiledMapRenderer renderer;

    public int TILEWIDTH, TILEHEIGHT, MAPWIDTH_TILES, MAPHEIGHT_TILES, MAPWIDTH_PIXELS, MAPHEIGHT_PIXELS;

    @Override
    public void create () {
        manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load("core/assets/map_v1.tmx", TiledMap.class);
        manager.finishLoading();

        gameMap = manager.get("core/assets/map_v1.tmx", TiledMap.class);

        MapProperties properties = gameMap.getProperties();
        TILEWIDTH = properties.get("tilewidth", Integer.class);
        TILEHEIGHT = properties.get("tileheight", Integer.class);
        MAPWIDTH_TILES = properties.get("width", Integer.class);
        MAPHEIGHT_TILES = properties.get("height", Integer.class);
        MAPWIDTH_PIXELS = MAPWIDTH_TILES * TILEWIDTH;
        MAPHEIGHT_PIXELS = MAPHEIGHT_TILES * TILEHEIGHT;

        viewPort = new OrthographicCamera(480.f, 270.f);
        viewPort.position.x = MAPWIDTH_PIXELS * 0.4f;
        viewPort.position.y = MAPHEIGHT_PIXELS * 0.85f;

        renderer = new OrthogonalTiledMapRenderer(gameMap);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(.5f, .7f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewPort.update();
        renderer.render();
    }

    @Override
    public void dispose () {
        manager.dispose();
    }
}