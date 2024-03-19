package src.elements.weapons.bow;

import src.elements.weapons.abs.Weapon;

public class Bow extends Weapon {

    
   
    public Bow() {
        this.damage = 5;
        this.speed = 5;
        this.size = 5;
    }

    private Bow(int positionX, int positionY, double angle) {
        this.damage = 5;
        this.speed = 5;
        this.size = 5;
        this.positionX = positionX;
        this.positionY = positionY;
        this.angle = angle;
    }

    @Override
    public void move() {
        this.positionX += this.speed * Math.cos(angle);
         this.positionY += this.speed  * Math.sin(angle);
    }

    public Weapon copy(int positionX, int positionY, double angle) {
        return new Bow(positionX, positionY, angle);
    }
    
}
