package ru.samsung.gamestudio.component;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Image {

    Texture texture;

    int x;
    int y;
    int width;
    int height;

    public Image(String texturePath, int x, int y, int width, int height) {
        this.texture = new Texture(texturePath);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }
}
