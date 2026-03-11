package ru.samsung.gamestudio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.manager.AudioManager;
import ru.samsung.gamestudio.screen.GameScreen;
import ru.samsung.gamestudio.screen.MenuScreen;
import ru.samsung.gamestudio.screen.RestartScreen;

public class MyGdxGame extends Game {

    public SpriteBatch batch;

    public GameScreen gameScreen;
    public MenuScreen menuScreen;
    public RestartScreen restartScreen;

    public AudioManager audioManager;


    @Override
    public void create() {
        batch = new SpriteBatch();

        audioManager = new AudioManager();
        audioManager.backgroundMusic.play();

        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        restartScreen = new RestartScreen(this);

        setScreen(menuScreen);
    }

}
