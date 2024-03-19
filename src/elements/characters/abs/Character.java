package src.elements.characters.abs;

import src.elements.weapons.abs.Weapon;

public abstract class Character implements ElementCharacter {
    private int size;
    protected int speed;
    protected int life;
    protected int positionX;
    protected int positionY;

    public Character(int size, int speed, int life) {
        this.size = size;
        this.speed = speed;
        this.life = life;
    }


    public boolean collided(Character character) {
        return this.positionX < character.positionX + character.size &&
        this.positionX + this.size > character.positionX &&
        this.positionY < character.positionY + character.size &&
        this.positionY + this.size > character.positionY;
    }

    public boolean collidedProjetile(Weapon projetile) {
        return this.positionX < projetile.getPositionX() + projetile.getSize() &&
        this.positionX + this.size > projetile.getPositionX() &&
        this.positionY < projetile.getPositionY() + projetile.getSize() &&
        this.positionY + this.size > projetile.getPositionY();
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size;
    }
    public int getSpeed(){
        return this.speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getLife() {
        return this.life;
    }

    public void healLife(int heal) {
        this.life += heal;

        if (this.life > 100) {
            this.life = 100;
        }
    }

    public void takeDamage(int damage) {
        this.life -= damage;
    }

    public boolean isDead() {
        return this.life <= 0;
    }

    public int getPositionX(){
        return this.positionX;
    }

    public void setPositionX(int positionX){
        this.positionX = positionX;
    }

    public int getPositionY(){
        return this.positionY;
    }

    public void setPositionY(int positionY){
        this.positionY = positionY;
    }
}
