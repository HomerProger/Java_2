package lesson1.obstacles;

import lesson1.competitors.Competitors;

public class Wall extends Obstacles {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitors c) {
        c.jump(height);
    }
}
