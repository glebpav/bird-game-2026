package ru.samsung.gamestudio.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.Bird;
import ru.samsung.gamestudio.GameResources;
import ru.samsung.gamestudio.GameSettings;
import ru.samsung.gamestudio.MovingBackground;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.TextView;
import ru.samsung.gamestudio.Tube;

public class GameScreen implements Screen {

    Bird bird;

    Tube[] tubeArray;

    MovingBackground background;

    TextView pointCounterText;

    int gameScore;

    MyGdxGame myGdxGame;

    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

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
    public void show() {

    }

    @Override
    public void render(float delta) {
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
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i].draw(myGdxGame.batch);
        }
        pointCounterText.draw(myGdxGame.batch, "Count of points: " + gameScore);
        myGdxGame.batch.end();

    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        myGdxGame.batch.dispose();
        bird.dispose();
        background.dispose();
        for (int i = 0; i < GameSettings.COUNT_OF_TUBES; i++) {
            tubeArray[i].dispose();
        }
        pointCounterText.dispose();
    }
}
