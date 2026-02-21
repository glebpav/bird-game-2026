package ru.samsung.gamestudio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TextView {

    BitmapFont font;

    int x;
    int y;

    public TextView(int x, int y, int textSize) {

        this.x = x;
        this.y = y;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
            Gdx.files.internal("font/Roboto-font.ttf")
        );

        FreeTypeFontGenerator.FreeTypeFontParameter p =
            new FreeTypeFontGenerator.FreeTypeFontParameter();

        p.size = textSize;
        p.color = Color.WHITE;
        // p.borderWidth = 2f;
        // p.borderColor = Color.BLACK;
        p.shadowOffsetX = 2;
        p.shadowOffsetY = 2;
        p.shadowColor = new Color(0, 0, 0,0.4f);

        font = generator.generateFont(p);

        generator.dispose();
    }

    void draw(SpriteBatch batch, String text) {
        font.draw(batch, text, x, y);
    }

    void dispose() {
        font.dispose();
    }

}
