package lesson1.competitors;

public class Robot implements RunJump,Competitors{
    private String type;
    private String name;
    private int maxDist;
    private int maxJump;

    public Robot(String name) {
        this.type = "Робот";
        this.name = name;
    }

    public Robot( String name, int maxDist, int maxJump) {
        this.type = "Робот";
        this.name = name;
        this.maxDist = maxDist;
        this.maxJump = maxJump;
    }

    @Override
    public void run() {
        System.out.printf("%s %s бежит\n", type,name);
    }

    @Override
    public void jump() {
        System.out.printf("%s %s прыгает\n", type,name);
    }


    @Override
    public void jump(int height) {
        if (height<=maxJump){
            System.out.printf("%s %s успешно прыгнул на %d м\n", type, name, height);
        }else {
            System.out.printf("%s %s  не смог прыгнуть на %d м\n", type,name, height);
        }
    }

    @Override
    public void run(int dist) {
        if (dist<=maxDist){
            System.out.printf("%s %s успешно пробежал %d м\n",type, name, dist);
        }else {
            System.out.printf("%s %s не смог пробежать %d м\n",type, name, dist);
        }
    }
}
