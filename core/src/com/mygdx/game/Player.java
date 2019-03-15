package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

        private float x, y;
        private Texture player_down, player_up, player_left, player_right;

        public Player() {
            x = 1000;
            y = 700;

            loadPlayerTextures();
        }

        public void update (float delta){
            // update player movement
            if (RIGHT_TOUCHED) {
                x += speed * delta;
            }
            if (LEFT_TOUCHED) {
                x -= speed * delta;
            }
            if (UP_TOUCHED){
                y += speed * delta;
            }
            if (DOWN_TOUCHED){
                y -= speed * delta;
            }

            // set ship texture:
            if (UP_TOUCHED == true && DOWN_TOUCHED == false) {
                ship = player_up;
            } else if (DOWN_TOUCHED == true && UP_TOUCHED == false) {
                ship = player_down;
            } else {
                ship = player_down;
            }
        }

        public void render (SpriteBatch sb){
            sb.draw(player_down,x,y);
        }

        public void loadPlayerTextures(){
            player_down = new Texture("core/assets/Player/Character_Down.png");
            player_up = new Texture("core/assets/Player/Character_Up.png");
            player_left = new Texture("core/assets/Player/Character_Left.png");
            player_right = new Texture("core/assets/Player/Character_Right.png");
        }
}
