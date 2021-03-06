package sk.tuke.kpi.oop.game;

public enum Direction {
    NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0), NONE(0, 0), NORTHEAST(1, 1), NORTHWEST(-1, 1), SOUTHEAST(1, -1), SOUTHWEST(-1, -1);

    private final int dx;
    private final int dy;
    private int newX;
    private int newY;
    Direction(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return this.dx;
    }
     public int getDy() {
        return  this.dy;
     }

    public float getAngle(){
        float angle = (float) Math.toDegrees(Math.atan2(dx, dy));
        return (this == EAST || this == WEST || this == NORTHEAST || this == NORTHWEST || this == SOUTHEAST || this == SOUTHWEST) ? angle * (-1) : angle;
    }

    public Direction combine(Direction other) {
        if (other.getDx() == this.getDx() && other.getDy() == this.getDy())
            return  this;

        newX = this.dx + other.dx;
        newY = this.dy + other.dy;
        reassign();
        if (check()) {
            for (Direction direction : Direction.values()) {
                if (direction.getDx() == newX && direction.getDy() == newY)
                    return direction;
            }
        }
        return Direction.NONE;
    }

    private boolean check() {
        return (newX < 2 && newX > -2 && newY < 2 && newY > -2);
    }

    private void reassign() {
        if(newX == 0 && newY == 2) {
            newY = 1;
        } else if(newX == 2 && newY == 0) {
            newX = 1;
        } else if(newX == -2 && newY == 0) {
            newX = -1;
        } else if(newX == 0 && newY == -2) {
            newY = -1;
        }

    }

    public static Direction getRandomDirection() {
        int rand = (int)(Math.random() * 4);
        return Direction.values()[rand];
    }

    public static Direction fromAngle(float angle) {
        float ang = angle;
        if (ang > 180)
            ang -= 360;
        for (Direction direction : Direction.values()) {
            if(direction.getAngle() == ang){
                return direction;
            }
        }
        return Direction.NONE;
    }

}



