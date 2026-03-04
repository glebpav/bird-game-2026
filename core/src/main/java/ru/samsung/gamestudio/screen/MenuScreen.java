package ru.samsung.gamestudio.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.common.GameResources;
import ru.samsung.gamestudio.common.GameSettings;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.component.MovingBackground;
import ru.samsung.gamestudio.component.TextButton;
import ru.samsung.gamestudio.component.TextView;

public class MenuScreen implements Screen {

    MyGdxGame myGdxGame;

    TextButton buttonStart;
    TextButton buttonExit;
    TextButton buttonSettings;
    TextView textViewTitle;

    MovingBackground movingBackground;

    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        buttonStart = new TextButton(100, 500, 400, 150, "Start");
        buttonSettings = new TextButton(100, 300, 400, 150, "Settings");
        buttonExit = new TextButton(100, 100, 400, 150, "Exit");
        textViewTitle = new TextView(700, 400, 80);
        movingBackground = new MovingBackground(GameResources.MENU_SCREEN_BACKGROUND_TEXTURE_PATH);

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        movingBackground.move();

        handelInput();

        ScreenUtils.clear(Color.BLUE);

        myGdxGame.batch.begin();
        movingBackground.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
        buttonStart.draw(myGdxGame.batch);
        buttonSettings.draw(myGdxGame.batch);
        textViewTitle.draw(myGdxGame.batch, "Bird Game");
        myGdxGame.batch.end();

    }

    void handelInput() {

        if (Gdx.input.justTouched()) {

            int transformedTouchY = GameSettings.SCREEN_HEIGHT - Gdx.input.getY();

            if (buttonStart.isHit(Gdx.input.getX(), transformedTouchY)) {
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }

            if (buttonExit.isHit(Gdx.input.getX(), transformedTouchY)) {
                Gdx.app.exit();
            }

            if (buttonSettings.isHit(Gdx.input.getX(), transformedTouchY)) {
                // TODO: implement - setScreen(settingsScreen);
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
