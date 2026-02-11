package ru.samsung.gamestudio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    Bird bird;
    Tube tube;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bird = new Bird(100, 100, 200, 150);
        tube = new Tube(GameSettings.SCREEN_WIDTH);
    }

    @Override
    public void render() {

        handleInput();

        bird.move();
        tube.move();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        bird.draw(batch);
        tube.draw(batch);
        batch.end();

    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        bird.dispose();
        tube.dispose();
    }

}
