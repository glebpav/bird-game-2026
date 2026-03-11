package ru.samsung.gamestudio.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import ru.samsung.gamestudio.common.GameResources;

public class AudioManager {

    public Music backgroundMusic;
    public Sound hitSound;
    public Sound pressSound;

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

    }

}
