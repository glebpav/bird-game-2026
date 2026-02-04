package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {

    Texture texture;

    int x;
    int y;
    int width;
    int height;

    boolean isJumping;
    int jumpStartY;

    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        isJumping = false;

        texture = new Texture(GameResources.BIRD_TEXTURE_PATH);
    }

    void jump() {
        isJumping = true;
        jumpStartY = y;
    }

    public void move() {

        if (y >= jumpStartY + GameSettings.BIRD_JUMP_HEIGHT) {
            isJumping = false;
        }

        if (isJumping) {
            y += GameSettings.BIRD_SPEED;
        } else {
            y -= GameSettings.BIRD_SPEED;
        }

    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }

}
