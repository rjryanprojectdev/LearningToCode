package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Player {

    public SpriteBatch batch;
    public TextureAtlas textureAtlas;
    public Animation animation;
    public TextureRegion currentFrame;
    private float elapsedTime = 0f;
    private float player_x, player_y;

    public void create() {

        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("core/assets/spritesheets/player_spritesheet.atlas"));
        Array<TextureAtlas.AtlasRegion> walkingFrames = textureAtlas.findRegions("walking");
        animation = new Animation (1f/6f, walkingFrames, Animation.PlayMode.LOOP);
        TextureRegion firstTexture = walkingFrames.first();
        player_x = (Gdx.graphics.getWidth()-firstTexture.getRegionWidth())  / 2;
        player_y = (Gdx.graphics.getHeight()-firstTexture.getRegionHeight()) / 2;

    }

    public void render() {
        elapsedTime += Gdx.graphics.getDeltaTime();

        currentFrame = (TextureRegion)animation.getKeyFrame(elapsedTime);

        batch.begin();
        batch.draw(currentFrame, player_x, player_y);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();
    }

    public float getPlayerX() {
        return player_x;
    }

    public float getPlayerY() {
        return player_y;
    }
}
