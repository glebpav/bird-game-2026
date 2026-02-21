package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Tube {

    Texture textureUpperTube;
    Texture textureDownTube;

    int x;
    int gapY;

    int width;
    int height;

    boolean haveAddedPoints;


    public Tube(int x, int width) {
        this.x = x;
        this.width = width;
        gapY = generateRandomGapY();
        height = 700;

        textureDownTube = new Texture(GameResources.TUBE_TEXTURE_PATH);
        textureUpperTube = new Texture(GameResources.FLIPPED_TUBE_TEXTURE_PATH);

    }

    private int generateRandomGapY() {
        Random random = new Random();
        int constHeight = GameSettings.TUBE_PADDING + GameSettings.TUBE_GAP_HEIGHT / 2;
        return constHeight + random.nextInt(GameSettings.SCREEN_HEIGHT - 2 * constHeight);
    }

    void move() {
        x -= GameSettings.TUBE_SPEED;

        if (x <= -width) {
            x = GameSettings.SCREEN_WIDTH;
            gapY = generateRandomGapY();
            haveAddedPoints = false;
        }
    }

    void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(
            textureUpperTube,
            x,
            gapY + GameSettings.TUBE_GAP_HEIGHT / 2.f,
            width,
            height
        );
        spriteBatch.draw(
            textureDownTube,
            x,
            gapY - GameSettings.TUBE_GAP_HEIGHT / 2.f - height,
            width,
            height
        );
    }

    boolean isHit(Bird bird) {

        boolean hitTubeByX = bird.x + bird.width >= x && bird.x <= x + width;

        // for down tube
        if (bird.y <= gapY - GameSettings.TUBE_GAP_HEIGHT / 2 && hitTubeByX) {
            return true;
        }
        // upper upper collision
        if (bird.y + bird.height >= gapY + GameSettings.TUBE_GAP_HEIGHT / 2 && hitTubeByX) {
            return true;
        }

        return false;
    }

    void dispose() {
        textureUpperTube.dispose();
        textureDownTube.dispose();
    }

    boolean shouldAddPoints(Bird bird) {
        if ((bird.x > x + width) && !haveAddedPoints) {
            haveAddedPoints = true;
            return true;
        }

        return false;
    }

}
