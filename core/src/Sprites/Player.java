package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
    SpriteBatch batch;
    Texture player;
    TextureRegion playerPosition;

    public void create () {
        batch = new SpriteBatch();
        player = new Texture("core/assets/player_right");

        playerPosition = new TextureRegion();
    }

    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(player, 500, 800);
        batch.end();

    }


    public void dispose () {

    }
}
