package ru.samsung.gamestudio.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.GameSettings;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.componets.TextButton;

public class MenuScreen implements Screen {

    MyGdxGame myGdxGame;

    TextButton buttonStart;

    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        buttonStart = new TextButton(100, 100, 400, 150, "Start");

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        handelInput();

        ScreenUtils.clear(Color.BLUE);

        myGdxGame.batch.begin();
        buttonStart.draw(myGdxGame.batch);
        myGdxGame.batch.end();

    }

    void handelInput() {

        if (Gdx.input.justTouched()) {
            if (buttonStart.isHit(
                Gdx.input.getX(),
                GameSettings.SCREEN_HEIGHT - Gdx.input.getY())
            ) {
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }
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

    }

}
