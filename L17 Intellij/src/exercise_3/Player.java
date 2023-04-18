package exercise_3;

public class Player {

    private final String name;
    private final int age;
    private int score;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return "Player(" +
                name +
                ", age=" + age +
                ", score=" + score +
                ')';
    }
}
