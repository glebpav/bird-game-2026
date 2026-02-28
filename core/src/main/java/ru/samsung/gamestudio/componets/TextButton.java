package ru.samsung.gamestudio.componets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.GameResources;

public class TextButton {

    Texture texture;
    TextView textView;
    String text;

    int x;
    int y;

    int buttonWidth;
    int buttonHeight;

    int textWidth;
    int textHeight;

    public TextButton(int x, int y, int width, int height, String text) {

        this.x = x;
        this.y = y;

        this.buttonWidth = width;
        this.buttonHeight = height;

        this.text = text;

        texture = new Texture(GameResources.BUTTON_BACKGROUND_TEXTURE_PATH);
        textView = new TextView(0, 0, 80);

        GlyphLayout glyphLayout = new GlyphLayout(textView.font, text);
        textWidth = (int) glyphLayout.width;
        textHeight = (int) glyphLayout.height;

        textView.x = x + buttonWidth / 2 - textWidth / 2;
        textView.y = y + buttonHeight / 2 + textHeight / 2;

    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y, buttonWidth, buttonHeight);
        textView.draw(spriteBatch, text);
    }

    public boolean isHit(int touchX, int touchY) {
        boolean isHitX = touchX > x && touchX < x + buttonWidth;
        boolean isHitY = touchY > y && touchY < y + buttonHeight;
        return isHitX && isHitY;
    }

    public void dispose() {
        texture.dispose();
        textView.dispose();
    }

}
