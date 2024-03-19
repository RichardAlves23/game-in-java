package src.elements.characters.abs;

import src.elements.abs.Element;
import src.elements.weapons.abs.Weapon;
public interface ElementCharacter extends Element {
    public void move();
    public Weapon atack();
}
