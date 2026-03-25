package ru.samsung.gamestudio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.common.GameSettings;
import ru.samsung.gamestudio.manager.AudioManager;
import ru.samsung.gamestudio.screen.GameScreen;
import ru.samsung.gamestudio.screen.MenuScreen;
import ru.samsung.gamestudio.screen.RestartScreen;
import ru.samsung.gamestudio.screen.SettingsScreen;

public class MyGdxGame extends Game {

    public SpriteBatch batch;
    public OrthographicCamera camera;

    public GameScreen gameScreen;
    public MenuScreen menuScreen;
    public RestartScreen restartScreen;
    public SettingsScreen settingsScreen;

    public AudioManager audioManager;


    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);

        audioManager = new AudioManager();
        audioManager.playBackgroundMusicIfOn();

        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        restartScreen = new RestartScreen(this);
        settingsScreen = new SettingsScreen(this);

        setScreen(menuScreen);
    }

}
