
import java.util.Random;

public abstract class Player {

    protected static int id;
    protected String name;
    protected double damage;
    protected double healthPoint;
    protected boolean luck;
    protected boolean life;

    public static boolean getRandBool() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public Player(String name, double damage, double healthPoint) {
        this.name = name;
        this.damage = damage;
        this.healthPoint = healthPoint;
    }

    public Player(boolean luck) {
        this.luck = luck;
    }

    public Player(double healthPoint) {
        if (healthPoint > 0) {
            this.life = true;
        } else {
            this.life = false;
        }
    }

    public void Attack(Player player) {
        player.GetDamage(damage);
        if (healthPoint == 0) {
            System.out.println("Игрок мертв");
        }
    }

    public double GetDamage(double damage) {
        if (luck) { 
            return this.healthPoint;
        } else {
            if (this.healthPoint - damage > 0) {
                this.healthPoint -= damage;
                return this.healthPoint;
            }
            return 0;
        }
    }

    public double getHp() {
        return this.healthPoint;
    }

    @Override
    public String toString() {
        return "id=" + ++Player.id + "; name=" + name + "; damage=" + damage + "; Hp=" + healthPoint;
    }
}