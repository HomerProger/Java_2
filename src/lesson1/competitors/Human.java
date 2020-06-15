package lesson1.competitors;

public class Human implements RunJump,Competitors{
    private String name;
    private int maxDist;
    private int maxJump;

    public Human(String name, int maxDist, int maxJump) {
        this.name = name;
        this.maxDist = maxDist;
        this.maxJump = maxJump;
    }

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s бежит\n", name);
    }

    @Override
    public void jump() {
        System.out.printf("%s прыгает\n", name);
    }


    @Override
    public void jump(int height) {
        if (height<=maxJump){
            System.out.printf("%s успешно прыгнул на %d м\n", name, height);
        }else {
            System.out.printf("%s не смог прыгнуть на %d м\n", name, height);
        }
    }

    @Override
    public void run(int dist) {
        if (dist<=maxDist){
            System.out.printf("%s успешно пробежал %d м\n", name, dist);
        }else {
            System.out.printf("%s не смог пробежать %d м\n", name, dist);
        }
    }
}
