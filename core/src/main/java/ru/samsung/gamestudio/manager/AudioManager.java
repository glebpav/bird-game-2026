package ru.samsung.gamestudio.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import ru.samsung.gamestudio.common.GameResources;

public class AudioManager {

    public boolean isSoundOn;
    public boolean isMusicOn;

    private final Music backgroundMusic;
    private final Sound hitSound;
    private final Sound pressSound;

    public AudioManager() {

        backgroundMusic = Gdx.audio.newMusic(
            Gdx.files.internal(GameResources.BACKGROUND_MUSIC_PATH)
        );

        hitSound = Gdx.audio.newSound(
            Gdx.files.internal(GameResources.HIT_SOUND_PATH)
        );

        pressSound = Gdx.audio.newSound(
            Gdx.files.internal(GameResources.PRESS_SOUND_PATH)
        );

        backgroundMusic.setVolume(0.5f);
        backgroundMusic.setLooping(true);

        isSoundOn = MemoryManager.loadIsSoundOn();
        isMusicOn = MemoryManager.loadIsMusicOn();

    }

    public void playBackgroundMusicIfOn() {
        if (isMusicOn) {
            backgroundMusic.play();
        }
    }

    public void stopBackgroundMusic() {
        backgroundMusic.stop();
    }

    public void playHitSoundIfOn() {
        if (isSoundOn) {
            hitSound.play();
        }
    }

    public void playPressSoundIfOn() {
        if (isSoundOn) {
            pressSound.play();
        }
    }

    public void switchSound() {
        isSoundOn = !isSoundOn;
        MemoryManager.saveIsSoundOn(isSoundOn);
    }

    public void switchMusic() {
        isMusicOn = !isMusicOn;
        MemoryManager.saveIsMusicOn(isMusicOn);

        if (isMusicOn) {
            playBackgroundMusicIfOn();
        } else {
            stopBackgroundMusic();
        }
    }


}
