package src.elements.characters.player;

import java.awt.event.KeyEvent;
import java.util.List;

import src.elements.characters.abs.Character;
import src.elements.weapons.abs.Weapon;

public class Player extends Character {

    private int keyCode;
    private boolean mouseClick;
    private double angleMouse;
    private List<Weapon> weapons;
    private int equippedWeapon;
    public Player(int size, int speed, int life, List<Weapon> weapons) {
        super(size, speed, life);
        this.weapons = weapons;
        this.equippedWeapon = this.weapons.indexOf(this.weapons.get(0));
    }

    @Override
    public void move() {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                this.positionY -= this.speed;
                break;
            case KeyEvent.VK_DOWN:
                this.positionY += this.speed;
                break;
            case KeyEvent.VK_LEFT:
                this.positionX -= this.speed;
                break;
            case KeyEvent.VK_RIGHT:
                this.positionX += this.speed;
                break;
        }
    }

    @Override
    public Weapon atack() {
        if (this.mouseClick) {
            int projectileX = this.positionX + this.getSize() / 2 - this.weapons.get(this.equippedWeapon).getSize() / 2;
            int projectileY = this.positionY + this.getSize() / 2 - this.weapons.get(this.equippedWeapon).getSize()  / 2;
            return this.weapons.get(this.equippedWeapon).copy(projectileX,projectileY,this.angleMouse);
        }

        return null;
    }

    public void setKeyCode(int key){
        this.keyCode = key;
    }

    public void setMouseClick(boolean click) {
        this.mouseClick = click;
    }

    public void setMouseAngle(double angle) {
        this.angleMouse = angle;
    }

}
