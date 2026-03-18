package ru.samsung.gamestudio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.manager.AudioManager;
import ru.samsung.gamestudio.screen.GameScreen;
import ru.samsung.gamestudio.screen.MenuScreen;
import ru.samsung.gamestudio.screen.RestartScreen;
import ru.samsung.gamestudio.screen.SettingsScreen;

public class MyGdxGame extends Game {

    public SpriteBatch batch;

    public GameScreen gameScreen;
    public MenuScreen menuScreen;
    public RestartScreen restartScreen;
    public SettingsScreen settingsScreen;

    public AudioManager audioManager;


    @Override
    public void create() {
        batch = new SpriteBatch();

        audioManager = new AudioManager();
        audioManager.playBackgroundMusicIfOn();

        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        restartScreen = new RestartScreen(this);
        settingsScreen = new SettingsScreen(this);

        setScreen(menuScreen);
    }

}
