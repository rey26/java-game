package sk.tuke.kpi.oop.game.weapons;

public abstract class Firearm {
    private int actual, max;
    public Firearm(int initial, int max) {
        actual = initial;
        this.max = max;
    }
    public Firearm(int initial) {
        actual = max = initial;
    }

    public int getAmmo() {
        return actual;
    }

    public void reload(int newAmmo) {
        if(newAmmo < 1) return;
        actual += newAmmo;
        if(actual > max)
            actual = max;
    }

    public Fireable fire() {
        if (this.getAmmo() > 0) {
            actual--;
            return this.createBullet();
        } else {
            return null;
        }
    }

    protected abstract Fireable createBullet();

}
