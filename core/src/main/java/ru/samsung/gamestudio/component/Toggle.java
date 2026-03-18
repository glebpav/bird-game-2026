package ru.samsung.gamestudio.component;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.common.GameResources;
import ru.samsung.gamestudio.manager.AudioManager;

public class Toggle {

    AudioManager audioManager;

    Texture onTexture;
    Texture offTexture;

    int x;
    int y;

    int width;
    int height;

    boolean isOn;

    public Toggle(int x, int y, int width, int height, boolean isOn, AudioManager audioManager) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isOn = isOn;
        this.audioManager = audioManager;

        onTexture = new Texture(GameResources.TOGGLE_ON_TEXTURE_PATH);
        offTexture = new Texture(GameResources.TOGGLE_OFF_TEXTURE_PATH);
    }

    public boolean isHit(int touchX, int touchY) {
        boolean isHitX = touchX > x && touchX < x + width;
        boolean isHitY = touchY > y && touchY < y + height;
        boolean isHit = isHitX && isHitY;

        if (isHit) {
            isOn = !isOn;
            audioManager.playPressSoundIfOn();
        }

        return isHit;
    }

    public void draw(SpriteBatch batch) {
        if (isOn) {
            batch.draw(onTexture, x, y, width, height);
        } else {
            batch.draw(offTexture, x, y, width, height);
        }
    }

    public void dispose() {
        onTexture.dispose();
        offTexture.dispose();
    }



}
