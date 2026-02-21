package ru.samsung.gamestudio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    Bird bird;

    Tube[] tubeArray;

    MovingBackground background;

    TextView pointCounterText;

    int gameScore;


    @Override
    public void create() {
        batch = new SpriteBatch();
        bird = new Bird(100, 100, 100, 75);
        tubeArray = new Tube[GameSettings.COUNT_OF_TUBES];
        background = new MovingBackground(GameResources.GAME_SCREEN_BACKGROUND_TEXTURE_PATH);
        pointCounterText = new TextView(30, GameSettings.SCREEN_HEIGHT - 30, 45);

        int tubeWidth = 200;
        int distanceBetweenTubes = (GameSettings.SCREEN_WIDTH + tubeWidth)
            / (GameSettings.COUNT_OF_TUBES);

        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i] = new Tube(
                GameSettings.SCREEN_WIDTH + distanceBetweenTubes * i,
                tubeWidth
            );
        }

        gameScore = 0;

    }

    @Override
    public void render() {

        handleInput();

        bird.move();
        background.move();

        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i].move();
            if(tubeArray[i].isHit(bird)) {
                System.out.println("Hit tube");
            }

            if (tubeArray[i].shouldAddPoints(bird)) {
                gameScore += 1;
            }
        }


        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        background.draw(batch);
        bird.draw(batch);
        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i].draw(batch);
        }
        pointCounterText.draw(batch, "Count of points: " + gameScore);
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
        background.dispose();
        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i].dispose();
        }
        pointCounterText.dispose();
    }

}
