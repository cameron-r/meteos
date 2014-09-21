package com.meteos.game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool;

public class Raindrop implements Pool.Poolable {
    public float x;
    public float y;
    private float width = 64;
    private float height = 64;
    public boolean alive;

    public Raindrop() {
        alive = false;
    }

    public void init() {
        x = MathUtils.random(0, 800 - 64);
        y = 480;
        alive = true;
    }

    @Override
    public void reset() {
        x = 0;
        y = 0;
        alive = false;
    }

    public boolean overlaps(Rectangle r) {
        return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
    }

    public void update(float delta) {
        y -= 200 * delta;
    }

    public boolean hasFallen() {
        return y + 64 < 0;
    }
}
