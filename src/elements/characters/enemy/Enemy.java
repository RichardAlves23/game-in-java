package src.elements.characters.enemy;

import src.elements.characters.abs.Character;
import src.elements.weapons.abs.Weapon;

public class Enemy extends Character {

    public Enemy(int size, int speed, int life) {
        super(size, speed, life);
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public Weapon atack() {
        return null;
    }
    
}
