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

public class Map {

    private TiledMap gameMap;
    private AssetManager manager;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera viewPort;

    private int tileWidth, tileHeight, mapWidth_Tiles, mapHeight_Tiles, mapWidth_Pixels,  mapHeight_Pixels;

    public void create () {
        manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load("core/assets/map_v1.tmx", TiledMap.class);
        manager.finishLoading();

        gameMap = manager.get("core/assets/map_v1.tmx", TiledMap.class);

        MapProperties properties = gameMap.getProperties();
        tileWidth = properties.get("tilewidth", Integer.class);
        tileHeight = properties.get("tileheight", Integer.class);
        mapWidth_Tiles = properties.get("width", Integer.class);
        mapHeight_Tiles = properties.get("height", Integer.class);
        mapWidth_Pixels = mapWidth_Tiles * tileWidth;
        mapHeight_Pixels = mapHeight_Tiles * tileHeight;

        renderer = new OrthogonalTiledMapRenderer(gameMap);



        viewPort = new OrthographicCamera(960.f, 540.f);
        viewPort.position.x = mapWidth_Pixels * 0.4f;
        viewPort.position.y = mapHeight_Pixels * 0.85f;
    }

    public void render () {
        Gdx.gl.glClearColor(.5f, .7f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(viewPort);
        renderer.render();

        viewPort.update();
    }

    public void dispose () {
        manager.dispose();
        renderer.dispose();
    }

    public int getWidthPixels() {
        return mapWidth_Pixels;
    }

    public int getHeightPixels() {
        return mapHeight_Pixels;
    }
}
