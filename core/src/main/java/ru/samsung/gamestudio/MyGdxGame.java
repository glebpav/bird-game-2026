package ru.samsung.gamestudio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.screen.GameScreen;
import ru.samsung.gamestudio.screen.MenuScreen;

public class MyGdxGame extends Game {

    public SpriteBatch batch;

    public GameScreen gameScreen;
    public MenuScreen menuScreen;


    @Override
    public void create() {
        batch = new SpriteBatch();

        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);

        setScreen(menuScreen);
    }

}
