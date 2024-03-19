package src.elements.weapons.abs;

public abstract class Weapon implements ElementWeapon {

    protected int damage;
    protected int size;
    protected int speed;
    protected double positionX;
    protected double positionY;
    protected double angle;
    private boolean isCollided;


    public Weapon() {

    }
    protected Weapon(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.isCollided = false;
   
    }


    public int getPositionX(){
        return (int) this.positionX;
    }

    public void setPositionX(double x) {
        this.positionX = x;
    }

    public int getPositionY() {
        return (int) this.positionY;
    }

    public void setPositionY(double y) {
        this.positionY = y;
    }

    public void setAngle(double x) {
        this.positionX = x;
    }

    public Weapon copy(int positionX, int positionY, double angle) {
        return null;
    }

    public int getSize() {
        return this.size;
    }

    public int getDamage() {
        return this.damage;
    }

    public boolean getIsCollided(){
        return this.isCollided;
    }

    public void setIsCollided(boolean collided) {
        this.isCollided = collided;
    }


}
