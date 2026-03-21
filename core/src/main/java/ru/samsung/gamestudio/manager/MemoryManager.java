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

    public static void saveBestResults(Integer[] bestScores) {
        String savingStr = "";

        for (Integer bestScore : bestScores) {
            savingStr += bestScore + ";";
        }

        preference.putString("bestScores", savingStr);
    }

    public static Integer[] getBestResults() {
        String gottenStr = preference.getString("bestScores", "0;0;0;0;0;");
        String[] resultsStr = gottenStr.split(";");
        Integer[] resultsInt = new Integer[resultsStr.length];

        for (int i = 0; i < resultsStr.length; i++) {
            resultsInt[i] = Integer.valueOf(resultsStr[i]);
        }

        return resultsInt;
    }

}
