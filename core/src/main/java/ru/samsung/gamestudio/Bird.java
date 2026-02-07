package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {

    Texture[] textureArray;
    int frameCounter;

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

        textureArray = new Texture[] {
            new Texture(GameResources.BIRD_TEXTURE_PATH_0),
            new Texture(GameResources.BIRD_TEXTURE_PATH_1),
            new Texture(GameResources.BIRD_TEXTURE_PATH_2),
            new Texture(GameResources.BIRD_TEXTURE_PATH_1),
        };

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
        frameCounter += 1;

        int framePointer = (frameCounter / 10) % textureArray.length;

        spriteBatch.draw(textureArray[framePointer], x, y, width, height);
    }

    public void dispose() {
        for (Texture texture : textureArray) {
            texture.dispose();
        }
    }

}
