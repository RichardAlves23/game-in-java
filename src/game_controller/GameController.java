package src.game_controller;

import javax.swing.*;

import src.elements.characters.player.Player;
import src.elements.weapons.abs.Weapon;
import src.elements.characters.abs.Character;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GameController extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
    private int widthScreen;
    private int heightScreen;

    private Player player;
    private List<Character> enemies;
    private List<Weapon> weapons;
    private int keyPress;
    private double angleMouse;
    private boolean clickMouse = false;

    public GameController(int widthScreen, int heightScreen, Player player, List<Character> enemies) {
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        this.configScreen();

        this.player = player;
        this.enemies = enemies;
        this.weapons = new ArrayList<Weapon>();
        Timer timer = new Timer(1000 / 60, this);
        timer.start();
    }


    private void configScreen() {
        setPreferredSize(new Dimension(this.widthScreen, this.heightScreen));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        this.controllerPlayer(g2d);
        this.controllerEnemy(g2d);
        this.controllerWeapon(g2d);
    }


    private void controllerPlayer(Graphics2D g2d) {
        this.drawPlayer(g2d);
    }

    private void controllerEnemy(Graphics2D g2d) {
        this.removeEnemiesDead();
        this.drawEnemies(g2d);
    }

    private void drawPlayer(Graphics2D g2d) {

        
        g2d.setColor(Color.BLUE);
        g2d.fillRect(this.player.getPositionX(), this.player.getPositionY(), this.player.getSize(), this.player.getSize());
    }
    private void removeEnemiesDead() {
        this.enemies.removeIf(enemy -> enemy.isDead());
    }
    private void drawEnemies(Graphics2D g2d) {
        for (Character enemy : this.enemies) {
            g2d.setColor(Color.RED);
            g2d.fillRect(enemy.getPositionX(), enemy.getPositionY(), enemy.getSize(), enemy.getSize());
        }
    }

    private void controllerWeapon(Graphics2D g2d) {
        this.removeProjetile();
        this.drawWeapons(g2d);
    }
    private void drawWeapons(Graphics2D g2d) {
        for (Weapon weapon : this.weapons) {
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(weapon.getPositionX(), weapon.getPositionY(), weapon.getSize(), weapon.getSize());
        }
    }

    private void removeProjetile() {
        this.weapons.removeIf(projetile -> this.projetileOutsideArea(projetile) || projetile.getIsCollided());
    }
    
    private boolean projetileOutsideArea(Weapon projetile) {
        return projetile.getPositionX() < 0 || 
            projetile.getPositionX() > this.widthScreen || 
            projetile.getPositionY() < 0 || 
            projetile.getPositionY() > this.heightScreen;
    }

    private void update() {
        this.updatePlayer();
        this.updateWeapon();
        this.collisionsPlayerAndEnemy();
        this.collisionsProjetileAndEnemy();
    }

    private void collisionsPlayerAndEnemy() {
        for (Character enemy : this.enemies) {
            if (enemy.collided(this.player)) {
                enemy.takeDamage(2);
            }
        }
    }

    private void collisionsProjetileAndEnemy() {
        this.weapons.forEach(projetile -> {
            this.enemies.forEach(enemy -> {
                if (enemy.collidedProjetile(projetile) && !projetile.getIsCollided()) {
                    enemy.takeDamage(projetile.getDamage());
                    projetile.setIsCollided(true);
                }
            });
        });
    }

    private void updatePlayer() {
        this.movedPlayer();
        this.atackPlayer();
    }

    private void movedPlayer() {
        this.player.setKeyCode(keyPress);
        this.player.move();
        this.keyPress = 0;
    }

    private void atackPlayer() {
        this.player.setMouseAngle(this.angleMouse);
        this.player.setMouseClick(this.clickMouse);
        Weapon atack = this.player.atack();
        if (atack != null) {
            this.weapons.add(atack);
        }
        this.clickMouse = false;
    }

    private void updateWeapon() {
        for (Weapon weapon : this.weapons) {
            weapon.move();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        this.keyPress = keyCode;
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
    }


    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        int playerCenterX = this.player.getPositionX() + this.player.getSize() / 2;
        int playerCenterY = this.player.getPositionY() + this.player.getSize()/ 2;
        this.angleMouse = Math.atan2(mouseY - playerCenterY, mouseX - playerCenterX);
    }


    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        this.clickMouse = true;
    }


    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
      
    }


    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }


    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
       
    }


    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

  

}
