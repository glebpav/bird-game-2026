package ru.samsung.gamestudio.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.common.GameResources;
import ru.samsung.gamestudio.common.GameSettings;
import ru.samsung.gamestudio.component.Image;
import ru.samsung.gamestudio.component.MovingBackground;
import ru.samsung.gamestudio.component.TextView;
import ru.samsung.gamestudio.component.Toggle;

public class SettingsScreen extends ScreenAdapter {

    MyGdxGame myGdxGame;

    MovingBackground movingBackground;
    TextView isMusicOnTextView;
    TextView isSoundOnTextView;
    Toggle soundToggle;
    Toggle musicToggle;
    Image blackoutImage;


    public SettingsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        movingBackground = new MovingBackground(GameResources.MENU_SCREEN_BACKGROUND_TEXTURE_PATH);
        isMusicOnTextView = new TextView(100, 400, 40);
        isSoundOnTextView = new TextView(100, 300, 40);
        soundToggle = new Toggle(
            400, 350,
            100, 50,
            myGdxGame.audioManager.isSoundOn,
            myGdxGame.audioManager
        );
        musicToggle = new Toggle(
            400, 250,
            100, 50,
            myGdxGame.audioManager.isMusicOn,
            myGdxGame.audioManager
        );
        blackoutImage = new Image(
            GameResources.BLACKOUT_TEXTURE_PATH,
            20, 20,
            600, 700
        );

    }

    @Override
    public void render(float delta) {

        handleInput();

        movingBackground.move();
        ScreenUtils.clear(Color.WHITE);

        myGdxGame.batch.begin();
        movingBackground.draw(myGdxGame.batch);
        blackoutImage.draw(myGdxGame.batch);
        isSoundOnTextView.draw(myGdxGame.batch, "Is music on");
        soundToggle.draw(myGdxGame.batch);
        isMusicOnTextView.draw(myGdxGame.batch, "Is sound on");
        musicToggle.draw(myGdxGame.batch);
        myGdxGame.batch.end();

    }

    void handleInput() {

        if (Gdx.input.justTouched()) {

            int touchX = Gdx.input.getX();
            int touchY = GameSettings.SCREEN_HEIGHT - Gdx.input.getY();

            if (musicToggle.isHit(touchX, touchY)) {
                System.out.println("music toggle was touched");
                myGdxGame.audioManager.switchMusic();
            }

            if (soundToggle.isHit(touchX, touchY)) {
                System.out.println("sound toggle was touched");
                myGdxGame.audioManager.switchSound();
            }

        }

    }

    @Override
    public void dispose() {
        movingBackground.dispose();
        musicToggle.dispose();
        soundToggle.dispose();
        isMusicOnTextView.dispose();
        isSoundOnTextView.dispose();
    }

}
