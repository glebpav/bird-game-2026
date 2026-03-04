package ru.samsung.gamestudio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.screen.GameScreen;
import ru.samsung.gamestudio.screen.MenuScreen;
import ru.samsung.gamestudio.screen.RestartScreen;

public class MyGdxGame extends Game {

    public SpriteBatch batch;

    public GameScreen gameScreen;
    public MenuScreen menuScreen;
    public RestartScreen restartScreen;


    @Override
    public void create() {
        batch = new SpriteBatch();

        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        restartScreen = new RestartScreen(this);

        setScreen(menuScreen);
    }

}
