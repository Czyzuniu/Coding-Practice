
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
	private Player player = new Player(this, 500, 850);
	private Background bg = new Background(0, -1000, new ImageIcon("../Images/bg-moving.png"));
	private Background bgpart = new Background(0, 0, new ImageIcon("../Images/bg-moving.png"));
	private boolean gameover;
	private int counter;
	private int spawnerX;
	private int spawnerY;
	private int amountToSpawn;
	private int time;
	private int level;
	private boolean levelFinished;
	private Ammo ammo = new Ammo(this);
	private Gun guns = new Gun(this);
	private ArrayList<Bullet> bullets;
	private ArrayList<Enemy> enemies;
	private ArrayList<EnemyBullet> enemiesBullets;
	private ArrayList<Boss> bosses;
	private ArrayList<BossBullets> bossBullets;
	private ArrayList<Bonus> bonuses;

	public Game() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

				player.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					fire();

				}
				ammo.keyPressed(e);
				guns.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {

				player.keyReleased(e);

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

		});
		setFocusable(true);
		bullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		enemiesBullets = new ArrayList<EnemyBullet>();
		bossBullets = new ArrayList<BossBullets>();
		bosses = new ArrayList<Boss>();
		bonuses = new ArrayList<Bonus>();
		counter = 0;
		spawnerX = 1000;
		spawnerY = -100;
		time = 0;
		level = 1;
		levelFinished = false;
		amountToSpawn = 20;

	}

	public void startGame() {
		new Game();
	}

	public void spawnEnemies(int amount) {

		Random rand = new Random();

		for (int a = 0; a < amount; a++) {

			int p = (rand.nextInt(3000) + 100) * -1;

			{
				p = (rand.nextInt(5000) + 100) * -1;
			}
			enemies.add(new Enemy(this, rand.nextInt(900) + 1, p));

		}

		// System.out.println(spawnerX);
		// System.out.println(counter);
	}

	public void move() {
		player.move();

		for (Boss b : bosses) {
			b.move();
		}

		for (Enemy e : enemies) {
			e.move();
			e.checkOfScreen();
		}
		for (Bullet b : bullets) {
			b.move();
		}
		for (EnemyBullet eb : enemiesBullets) {
			eb.move();

		}

		for (BossBullets bb : bossBullets) {
			bb.move();

		}

		for (Bonus bonus : bonuses) {
			bonus.move();
		}

		// background1.move();
	}

	{

	}
	
	public void checkBullets()
	{
		if(bullets.size() > 0)
		{
			for(int a = 0; a < bullets.size(); a++)
			{
				if(bullets.get(a).isDestroyed())
				{
					bullets.remove(a);
				}
				}
				
		}
	}

	public int randomNum() {
		Random rand = new Random();
		return rand.nextInt(100) + 1;
	}

	public int randomNum2() {
		Random rand = new Random();
		return rand.nextInt(200) + 0;
	}

	public void detectCollision() {
		if (bullets.size() > 0) {
			for (int x = 0; x < bullets.size(); x++) {
				Rectangle bullet = bullets.get(x).bounds();
				for (int y = 0; y < enemies.size(); y++) {
					Rectangle e = enemies.get(y).bounds();

					if (bullet.intersects(e)) {
						bullets.get(x).setDestroyed(true);
						switch(guns.getGun())
						{
						case "Missiles":
							enemies.get(y).loseHP(30);
						break;
						
						case "Rocket Launcher": 
							enemies.get(y).loseHP(50);
							break;
							
						case "Fireballs": 
							enemies.get(y).loseHP(80);
							break;
						
						case "Double Missile": 
							enemies.get(y).loseHP(90);
							
							break;
						case "Plasma": 
							enemies.get(y).loseHP(100);
							break;
						//enemies.get(y).loseHP(100);
						}
						Rectangle bonus = enemies.get(y).bounds();

						if (enemies.get(y).isDestroyed()) {

							enemies.remove(y);
							int r = randomNum();

							if (r <= 105) {
								bonuses.add(new Bonus(this, (int) bonus.getX(), (int) bonus.getY()));

							}

						}
						if (bullets.get(x).isDestroyed()) {
							bullets.remove(x);
						}

					}
				}
			}

		}
		if (enemiesBullets.size() > 0) {
			for (int x = 0; x < enemiesBullets.size(); x++) {
				Rectangle enemyBullet = enemiesBullets.get(x).bounds();
				Rectangle player = this.player.bounds();
				if (enemyBullet.intersects(player)) {

					enemiesBullets.remove(x);
					this.player.loseHP(10);
				}

				for (int y = 0; y < bonuses.size(); y++) {
					Rectangle bonus_Collision = bonuses.get(y).bounds();
					if (bonus_Collision.intersects(player)) {
						bonuses.remove(y);
						int random = randomNum();
						if(random <= 50)
						{
							System.out.println("life");
						}
						else
						{
							System.out.println("dupa");
						}
					}
				}
			}
		}
	}

	public int getLevel() {
		return level;
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		
		bg.paint(g);
		bgpart.paint(g);

		/*
		 * 
		 * switch(getLevel()) { case 1: bg.paint(g); bgpart.paint(g); break;
		 * 
		 * case 2:
		 * 
		 * bg1.paint(g); bg1part.paint(g); break;
		 * 
		 * case 3:
		 * 
		 * bg2.paint(g); bg2part.paint(g); break;
		 * 
		 * 
		 * 
		 * }
		 */

		player.paint(g);

		for (Bullet b : bullets) {
			b.paint(g);
			if (b.isDestroyed() == true) {
				// bullets.remove(b);
			}
		}
		ammo.paint(g);
		guns.paint(g);

		for (int i = 0; i < enemies.size(); i++) {

			enemies.get(i).paint(g);

		}

		for (int a = 0; a < enemiesBullets.size(); a++) {

			enemiesBullets.get(a).paint(g);

		}

		for (Boss b : bosses) {
			b.paint(g);
		}

		for (int w = 0; w < bossBullets.size(); w++) {
			bossBullets.get(w).paint(g);
		}

		for (Bonus bonus : bonuses) {
			bonus.paint(g);
		}

	}

	public void spawnBoss(int amount) {
		int hp = 500;
		for (int q = 0; q < amount; q++)
			bosses.add(new Boss(this, 200, -400, hp));

	}

	public void fire() {
		if (ammo.getAmmo() > 0) {
			bullets.add(new Bullet(this, player.getxPos() + (player.getWidth() / 2), player.getyPos(), guns.getGun()));
			//ammo.takeAway(1);

		} else {
			System.out.println("Your out of ammo mate");
			System.out.println("Press R to reload");
		}
		System.out.println(bullets.size());
	}

	public void enemyFire() {

		while (enemiesBullets.size() < 1) {
			if (enemies.size() > 0) {
				for (int a = 0; a < enemies.size(); a++) {

					enemiesBullets.add(new EnemyBullet(this, enemies.get(a).getxPos() + enemies.get(a).getWidth() / 2,
							enemies.get(a).getyPos() + enemies.get(a).getHeight() / 2));
				}

			}
		}
		for (int i = 0; i < enemiesBullets.size(); i++) {
			if (enemiesBullets.get(i).isDestroyed()) {
				enemiesBullets.remove(i);

			}
		}

		// sayHello();

	}

	public void BossFire() {
		System.out.println(bosses.size());
		while (bossBullets.size() < 1) {
			if (bosses.size() > 0) {

				int pos = bosses.get(0).getxPos() - 200;

				for (int a = 0; a < 8; a++) {

					bossBullets.add(new BossBullets(this, pos + bosses.get(0).getWidth() / 2,
							bosses.get(0).getyPos() + bosses.get(0).getHeight() / 2 + 200));

					pos += 50;
				}

			}
		}

		for (int i = 0; i < bossBullets.size(); i++) {
			if (bossBullets.get(i).isDestroyed()) {
				bossBullets.remove(i);

			}
		}

		// sayHello();

	}

	public String currentGun()
	{
		return guns.getGun();
	}
	
	public int getSpawnerY() {
		return spawnerY;
	}

	public void setSpawnerY(int spawnerY) {
		this.spawnerY = spawnerY;
	}

	public int getSpawnerX() {
		return spawnerX;
	}

	public void setSpawnerX(int spawnerX) {
		this.spawnerX = spawnerX;
	}

	public void checkEnd() {

		if (enemies.isEmpty()) {
			while (bosses.size() < 1 && levelFinished == false) {
				spawnBoss(1);
			}

		}

		{
			if (enemies.size() == 0 && bosses.size() == 0 && levelFinished == true) {
				enemies.clear();
				bullets.clear();
				bossBullets.clear();
				levelFinished = false;
				JOptionPane.showMessageDialog(null, "Well Done, you have completed level : " + level);
				level++;
				spawnEnemies(level * amountToSpawn);
			}
		}
	}
	
	

	public void gameOver() {
		int reply = JOptionPane.showConfirmDialog(null, "Would you like to try again?", "Game Over",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {

		} else {
			gameover = true;

		}
	}

	public void detectCollisionWithBoss() {
		if (bullets.size() > 0) {
			for (int x = 0; x < bullets.size(); x++) {
				Rectangle bullet = bullets.get(x).bounds();
				if (bosses.size() > 0) {
					for (int t = 0; t < bosses.size(); t++) {
						Rectangle Boss = bosses.get(t).bounds();
						if (Boss.intersects(bullet)) {
							bullets.remove(x);
							bosses.get(t).loseHP(10);
							{
								if (bosses.get(t).getHp() <= 0) {
									bosses.get(t).setDestroyed(true);
									if (bosses.get(t).isDestroyed()) {
										bosses.remove(t);
										levelFinished = true;

									}
								}
							}

						}
					}
				}
			}
		}

		for (int bossAmmo = 0; bossAmmo < bossBullets.size(); bossAmmo++) {
			Rectangle Ammo = bossBullets.get(bossAmmo).bounds();
			Rectangle player = this.player.bounds();

			if (Ammo.intersects(player)) {
				this.player.loseHP(10);
				bossBullets.remove(bossAmmo);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Menu menu = new Menu();
		// menu.draw();

		// JFrame main_menu = new JFrame();
		// main_menu.setVisible(true);
		// main_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// main_menu.setSize(1000, 1000);
		// main_menu.setTitle("Main Menu");
		// main_menu.add(menu);

		Game game = new Game();
		JFrame window = new JFrame();
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.add(game);
		window.setVisible(true);
		game.setBackground(Color.BLACK);
		game.gameover = false;
		game.spawnEnemies(game.level * game.amountToSpawn);
		while (!game.gameover) {
			
			game.checkBullets();
			game.detectCollision();
			if (game.bosses.size() > 0) {
				game.detectCollisionWithBoss();
				game.BossFire();
			}
			game.move();

			if (game.enemies.size() > 0) {
				game.enemyFire();
			}
			game.checkEnd();
			game.repaint();
			Thread.sleep(7);

		}

		if (game.gameover == true) {
			window.dispose();
			window.setVisible(false);
		}
	}

}
