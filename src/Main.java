package src;

import java.util.ArrayList;

import javax.swing.JFrame;

import src.elements.characters.abs.Character;
import src.elements.characters.enemy.Enemy;
import src.elements.characters.player.Player;
import src.elements.weapons.abs.Weapon;
import src.elements.weapons.bow.Bow;
import src.game_controller.GameController;

/**
 * Main
 */
public class Main  {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        int widthScreen = 800;
        int heightScreen = 600;
        ArrayList<Weapon> weaponsPlayer = new ArrayList<Weapon>();
        weaponsPlayer.add(new Bow());
        Player player = new Player(30, 5, 50, weaponsPlayer);
        player.setPositionX(widthScreen / 2);
        player.setPositionY(heightScreen / 2);

        Enemy enemyOne = new Enemy(30, 3, 10);
        enemyOne.setPositionX(widthScreen / 4);
        enemyOne.setPositionY(heightScreen / 2);

        ArrayList<Character> enemies = new ArrayList<Character>();
        enemies.add(enemyOne);

        GameController game = new GameController(widthScreen, heightScreen, player, enemies);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}