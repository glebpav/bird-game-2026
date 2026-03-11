package ru.samsung.gamestudio.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.common.GameResources;
import ru.samsung.gamestudio.common.GameSettings;
import ru.samsung.gamestudio.component.MovingBackground;
import ru.samsung.gamestudio.component.TextButton;
import ru.samsung.gamestudio.component.TextView;

public class RestartScreen implements Screen {

    MovingBackground movingBackground;
    TextButton menuTextButton;
    TextButton restartTextButton;
    TextView scoreTextView;

    MyGdxGame myGdxGame;

    public RestartScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        movingBackground = new MovingBackground(GameResources.MENU_SCREEN_BACKGROUND_TEXTURE_PATH);

        int padding = 70;

        menuTextButton = new TextButton(
            GameSettings.SCREEN_WIDTH / 2 + padding, 150,
            400, 150,
            "menu",
            myGdxGame.audioManager
        );
        restartTextButton = new TextButton(
            GameSettings.SCREEN_WIDTH / 2 - padding - 400, 150,
            400, 150,
            "restart",
            myGdxGame.audioManager
        );

        scoreTextView = new TextView(300, 450, 70);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        handleInput();

        movingBackground.move();

        ScreenUtils.clear(Color.BLUE);

        myGdxGame.batch.begin();

        movingBackground.draw(myGdxGame.batch);
        menuTextButton.draw(myGdxGame.batch);
        restartTextButton.draw(myGdxGame.batch);
        scoreTextView.draw(myGdxGame.batch, "You earned 100 points");

        myGdxGame.batch.end();

    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            int touchX = Gdx.input.getX();
            int touchY = GameSettings.SCREEN_HEIGHT - Gdx.input.getY();

            if (restartTextButton.isHit(touchX, touchY)) {
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }
            if (menuTextButton.isHit(touchX, touchY)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
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
