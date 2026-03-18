package ru.samsung.gamestudio.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class MemoryManager {

    private static final Preferences preference = Gdx.app.getPreferences("UserPreference");

    public static void saveIsMusicOn(boolean isMusicOn) {
        preference.putBoolean("isMusicOn", isMusicOn);
        preference.flush();
    }

    public static void saveIsSoundOn(boolean isSoundOn) {
        preference.putBoolean("isSoundOn", isSoundOn);
        preference.flush();
    }

    public static boolean loadIsMusicOn() {
        return preference.getBoolean("isMusicOn", true);
    }

    public static boolean loadIsSoundOn() {
        return preference.getBoolean("isSoundOn", true);
    }

}
