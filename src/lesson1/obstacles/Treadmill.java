package lesson1.obstacles;

import lesson1.competitors.Competitors;

public class Treadmill extends Obstacles{

   private int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitors c) {
        c.run(dist);

    }
}
