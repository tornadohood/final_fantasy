import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton starButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, monsterHP;
	String weapon, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {
		
		new Game();

	}
	public Game() {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("最終幻想VI");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		
		JButton startButton = new JButton("開始遊戲");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		window.setVisible(true);
		
	}
	
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		mainTextArea = new JTextArea("This is the main text area. This game is going to be great. I am sure of it");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.black);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.black);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("生命值:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("武器:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
		
	}
	public void playerSetup() {
		playerHP = 100;
		monsterHP = 50;
		weapon = "钢铁剑";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" +playerHP);
		
		townGate();
	}
	
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("在「米德加」這個擁有八座魔晄爐的階層都市，\n" + 
				"藉由魔晄掌握世界的巨大企業「神羅公司」與\n" + 
				"為了保護星球挺身而出的反神羅組織「雪崩」爆發激烈衝突。\n\n"
				+ "前方有傭兵....");
		
		choice1.setText("和傭兵聊天");
		choice2.setText("攻擊傭兵");
		choice3.setText("離開");
		choice4.setText("");
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \n I'm sorry I cannot let you in");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: hey dont be stupid!\n\nThe guard fought back and hit you hard.\n(You recieved 3 damage");
		playerHP = playerHP -3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void north() {
		position = "north";
		mainTextArea.setText("There is a river. \nYou drink the water at the riverside. \n\n(Your HP is recoeved by 2)");
		playerHP = playerHP + 2;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go south");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void east() {
		position = "east";
		mainTextArea.setText("You walked into a forest and found a long Sword!\n\n(You  obtained a Long Sword");
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go west");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void west() {
		position = "west";
		mainTextArea.setText("You encounter a goblin!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void fight() {
		position = "fight";
		mainTextArea.setText("Monster HP:" + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void playerAttack() {
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.contentEquals("钢铁剑")) {
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.contentEquals("Long Sword")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		mainTextArea.setText("You attaced the monster and gave " + playerDamage + "damage!");
		
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void monsterAttack() {
		position = "monsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(4);
		
		mainTextArea.setText("The monster attacked you and gave " + monsterDamage + "damage!");
		
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "c1": talkGuard(); break;
				case "c2": attackGuard(); break;
				case "c3": crossRoad(); break;
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice) {
				case "c1": townGate(); break;
				}
			case "crossRoad":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": east(); break;
				case "c3": townGate(); break;
				case "c4": west(); break;
				}
				break;
			case "north":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice) {
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
			case "fight":
				switch(yourChoice) {
				case "c1": playerAttack(); break;
				case "c2": crossRoad(); break;				
				}
				break;
			case "playerAttack":
				switch(yourChoice) {
				case "c1": monsterAttack(); break;			
				}
			case "monsterAttack":
				switch(yourChoice) {
				case "c1": fight(); break;
				}
				break;
			}
		}
	}
}
