package ru.samsung.gamestudio.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.common.GameResources;
import ru.samsung.gamestudio.common.GameSettings;
import ru.samsung.gamestudio.component.Image;
import ru.samsung.gamestudio.component.MovingBackground;
import ru.samsung.gamestudio.component.TextButton;
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

    TextButton menuButton;


    public SettingsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        movingBackground = new MovingBackground(GameResources.MENU_SCREEN_BACKGROUND_TEXTURE_PATH);
        isMusicOnTextView = new TextView(100, 600, 40);
        isSoundOnTextView = new TextView(100, 500, 40);
        soundToggle = new Toggle(
            400, 550,
            100, 50,
            myGdxGame.audioManager.isSoundOn,
            myGdxGame.audioManager
        );
        musicToggle = new Toggle(
            400, 450,
            100, 50,
            myGdxGame.audioManager.isMusicOn,
            myGdxGame.audioManager
        );
        blackoutImage = new Image(
            GameResources.BLACKOUT_TEXTURE_PATH,
            20, 20,
            600, 700
        );
        menuButton = new TextButton(
            100, 40,
            400, 150,
            "Menu",
            myGdxGame.audioManager
        );

    }

    @Override
    public void render(float delta) {

        handleInput();

        movingBackground.move();
        ScreenUtils.clear(Color.WHITE);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();
        movingBackground.draw(myGdxGame.batch);
        blackoutImage.draw(myGdxGame.batch);
        isSoundOnTextView.draw(myGdxGame.batch, "Is music on");
        soundToggle.draw(myGdxGame.batch);
        isMusicOnTextView.draw(myGdxGame.batch, "Is sound on");
        musicToggle.draw(myGdxGame.batch);
        menuButton.draw(myGdxGame.batch);
        myGdxGame.batch.end();

    }

    void handleInput() {

        if (Gdx.input.justTouched()) {

            Vector3 vector = myGdxGame.camera.unproject(
                new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)
            );

            int touchX = (int) vector.x;
            int touchY = (int) vector.y;

            if (musicToggle.isHit(touchX, touchY)) {
                System.out.println("music toggle was touched");
                myGdxGame.audioManager.switchMusic();
            }

            if (soundToggle.isHit(touchX, touchY)) {
                System.out.println("sound toggle was touched");
                myGdxGame.audioManager.switchSound();
            }

            if (menuButton.isHit(touchX, touchY)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
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
