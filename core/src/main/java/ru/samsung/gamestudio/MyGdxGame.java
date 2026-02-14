package ru.samsung.gamestudio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    Bird bird;

    Tube[] tubeArray;


    @Override
    public void create() {
        batch = new SpriteBatch();
        bird = new Bird(100, 100, 100, 75);
        tubeArray = new Tube[GameSettings.COUNT_OF_TUBES];

        int tubeWidth = 200;
        int distanceBetweenTubes = (GameSettings.SCREEN_HEIGHT + tubeWidth)
            / (GameSettings.COUNT_OF_TUBES - 1);

        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i] = new Tube(
                GameSettings.SCREEN_WIDTH + distanceBetweenTubes * i,
                tubeWidth
            );
        }

    }

    @Override
    public void render() {

        handleInput();

        bird.move();
        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i].move();
            if(tubeArray[i].isHit(bird)) {
                System.out.println("Hit tube");
            }
        }


        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        bird.draw(batch);
        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i].draw(batch);
        }
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
        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i].dispose();
        }
    }

}
