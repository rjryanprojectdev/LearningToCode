package com.ltc.rr;

import Sprites.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ViewPortUpdate {
    //updates the viewPort position and the player position.ww


    public void updateViewPort(OrthographicCamera viewPort) {

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            viewPort.position.x += 0f;
            viewPort.position.y += 2f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            viewPort.position.x -= 2f;
            viewPort.position.y += 0f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            viewPort.position.x += 0f;
            viewPort.position.y -= 2f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            viewPort.position.x += 2f;
            viewPort.position.y += 0f;
        }
    }


}