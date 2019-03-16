package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Player2 {
    SpriteBatch batch;
    TextureAtlas textureAtlas;
    Animation animation;
    TextureRegion currentFrame;
    private float elapsedTime = 0f;
    private float origin_x, origin_y;
    private float playerSpeed = 10.0f;

    public void create() {

        batch = new SpriteBatch();

        textureAtlas = new TextureAtlas(Gdx.files.internal("spritesheets/player_spritesheet.atlas"));

        Array<TextureAtlas.AtlasRegion> walkingFrames = textureAtlas.findRegions("walking");

        animation = new Animation (1f/3f, walkingFrames, Animation.PlayMode.LOOP);

        TextureRegion firstTexture = walkingFrames.first();

        origin_x = (Gdx.graphics.getWidth()-firstTexture.getRegionWidth())  / 2;

        origin_y = (Gdx.graphics.getHeight()-firstTexture.getRegionHeight()) / 2;

    }

    public void render() {
        //Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        elapsedTime += Gdx.graphics.getDeltaTime();

        currentFrame = (TextureRegion)animation.getKeyFrame(elapsedTime);

        batch.begin();
        batch.draw(currentFrame, origin_x, origin_y);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();
    }
}
