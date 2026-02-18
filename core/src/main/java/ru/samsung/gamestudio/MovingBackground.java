package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MovingBackground {

    Texture texture;

    int texture1X;
    int texture2X;

    public MovingBackground(String pathToTexture) {
        texture1X = 0;
        texture2X = GameSettings.SCREEN_WIDTH;
        texture = new Texture(pathToTexture);
    }

    public void move() {
        texture1X -= GameSettings.MOVING_BACKGROUND_SPEED;
        texture2X -= GameSettings.MOVING_BACKGROUND_SPEED;

        if (texture1X <= - GameSettings.SCREEN_WIDTH) {
            texture1X = GameSettings.SCREEN_WIDTH;
        }
        if (texture2X <= - GameSettings.SCREEN_WIDTH) {
            texture2X = GameSettings.SCREEN_WIDTH;
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(
            texture,
            texture1X,
            0,
            GameSettings.SCREEN_WIDTH,
            GameSettings.SCREEN_HEIGHT
        );
        batch.draw(
            texture,
            texture2X,
            0,
            GameSettings.SCREEN_WIDTH,
            GameSettings.SCREEN_HEIGHT
        );
    }

    public void dispose() {
        texture.dispose();
    }

}
