package lesson1;


import lesson1.competitors.Cat;
import lesson1.competitors.Competitors;
import lesson1.competitors.Human;
import lesson1.competitors.Robot;
import lesson1.obstacles.Obstacles;
import lesson1.obstacles.Treadmill;
import lesson1.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik",234,5);
        Human human1=new Human("Boris", 4566,4);
        Robot robot1=new Robot("Fedor",3433,7);

        cat1.jump();
        cat1.run();
        human1.jump();
        human1.run();
        robot1.jump();
        robot1.run();

        Wall wall1=new Wall(6);
        Treadmill treadmill1=new Treadmill(1000);

        wall1.doIt(((Competitors)human1));
        treadmill1.doIt(((Competitors)human1));
        wall1.doIt(((Competitors)cat1));
        treadmill1.doIt(((Competitors)cat1));
        wall1.doIt(((Competitors)robot1));
        treadmill1.doIt(((Competitors)robot1));

    Competitors[] competitors = {
            new Human("Gosha",1000,3),
            new Cat("Murzik",500,5),
            new Robot("Dronny",3000,1)
    };
    Obstacles[]obstacles={

            new Wall(4),
            new Treadmill(1000)
    };

    for (Competitors c: competitors){
        for (Obstacles o: obstacles) {
            o.doIt(c);
        }
    }

    }
}
