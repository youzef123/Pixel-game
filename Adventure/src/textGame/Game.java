package textGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Game {
		
		private JFrame window;
		private Font titleFont = new Font("Times New Roman", Font.PLAIN, 45);
		private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
		private Font Tutor = new Font("Times New Roman", Font.PLAIN, 20);
		private JPanel titleNamePanel ,startButton ,mainTextPL ,choiceBtnPL ,playerPL;
		private JLabel titleLabel ,hpLabel ,hpLbNum ,weaponLabel ,weaponLbName ,enemyhps ,icon, icon2
		, icon3 ,icon4 ,icon5 ,icon6 ,icon7 , icon8 , icon9 ,icon10 ,icon11 ,icon12 ;
		private JButton startBtn ,choice1 ,choice2 ,choice3 ,choice4, Help ,bck;
		private JTextArea mainTextArea;
		private TitleHandler tHandler = new TitleHandler();
		private ChoiceHandler choiceHandler = new ChoiceHandler();
		private String choice ,temp;
		private int playerHP ,enemyHP ,ID;
		private String weapon, position;
		private String event;
		private int attackdamage;
		private int kalabanDamage ,monsterDamage ;
				Image dem_at , dem;
		//Tumala 
		private String[] enemies = {"Demonyo","Tikbalang","Duwende","White Lady"};
		private Random r = new Random();
		public static void main(String[] args) {
			 new Game();
		}
		//Tayuan
		public Game() {
			
			window = new JFrame();
			window.setSize(800 ,600);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().setBackground(Color.black);
			window.getContentPane().setLayout(null);
			window.setResizable(false);
			startBtn = new JButton("Start");
			startBtn.setBackground(Color.black);
			startBtn.setForeground(Color.white);
			startBtn.setFont(normalFont);
			startBtn.setBounds(339, 339, 100, 45);
			
			icon2 = new JLabel(""); //guard stand
			Image guard = new ImageIcon(this.getClass().getResource("/guard.png")).getImage();
			Image guardImage = guard.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon2.setIcon(new ImageIcon(guardImage));
			icon2.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon2);
			
			icon3 = new JLabel(""); //guard talking
			Image guard1 = new ImageIcon(this.getClass().getResource("/guardtalk.gif")).getImage();
			Image guardtalk = guard1.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon3.setIcon(new ImageIcon(guardtalk));
			icon3.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon3);
			
		    icon4 = new JLabel(""); //guard punching
			Image guard2 = new ImageIcon(this.getClass().getResource("/guardpunch.gif")).getImage();
			Image guardpunch = guard2.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon4.setIcon(new ImageIcon(guardpunch));
			icon4.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon4);
			
			icon5 = new JLabel(""); // water times beach
			Image water = new ImageIcon(this.getClass().getResource("/water.gif")).getImage();
			Image wt = water.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon5.setIcon(new ImageIcon(wt));
			icon5.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon5);
			
			icon6 = new JLabel(""); // sword
			Image pp = new ImageIcon(this.getClass().getResource("/pp.gif")).getImage();
			Image ppsword = pp.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon6.setIcon(new ImageIcon(ppsword));
			icon6.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon6);
			
			icon7 = new JLabel(""); // demon encounter
			Image demon = new ImageIcon(this.getClass().getResource("/demon_encounter.gif")).getImage();
			Image dm = demon.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon7.setIcon(new ImageIcon(dm));
			icon7.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon7);
			
			icon8 = new JLabel(""); // lady encounter
			Image lady = new ImageIcon(this.getClass().getResource("/lady_encounter.gif")).getImage();
			Image ld = lady.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon8.setIcon(new ImageIcon(ld));
			icon8.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon8);
			
			icon9 = new JLabel(""); // tikbalang encounter
			Image kabayo = new ImageIcon(this.getClass().getResource("/tikbalang_encounter.gif")).getImage();
			Image kb = kabayo.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon9.setIcon(new ImageIcon(kb));
			icon9.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon9);
			
			icon10 = new JLabel(""); // duwende encounter
			Image duwende = new ImageIcon(this.getClass().getResource("/duwende_encounter.gif")).getImage();
			Image dw = duwende.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			icon10.setIcon(new ImageIcon(dw));
			icon10.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon10);
			
			icon11 = new JLabel("");
			icon11.setBounds(0, 0, 796, 573);
			dem_at = new ImageIcon(this.getClass().getResource("/demon_attack.gif")).getImage();
			dem = dem_at.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
		 
			icon11.setIcon(new ImageIcon(dem));
			icon11.setBounds(444, 141, 300, 170);
			window.getContentPane().add(icon11);
		
	
			
			icon11.setVisible(false);
			icon10.setVisible(false);
			icon9.setVisible(false);
			icon8.setVisible(false);
			icon7.setVisible(false);
			icon6.setVisible(false);
			icon5.setVisible(false);
			icon4.setVisible(false);
			icon3.setVisible(false);
			icon2.setVisible(false);
			
			startBtn.setFocusPainted(false);
			window.getContentPane().add(startBtn);
			
			mainTextArea = new JTextArea("g");
			mainTextArea.setBounds(100, 100, 600, 250);
			mainTextArea.setBackground(Color.black);
			mainTextArea.setForeground(Color.white);
			mainTextArea.setFont(normalFont);
			mainTextArea.setLineWrap(true);
			mainTextArea.setVisible(false);
			mainTextArea.setEditable(false);
			window.getContentPane().add(mainTextArea);
				
			titleLabel = new JLabel("ADVENTURE IN ECOLAND");
			titleLabel.setBounds(100 ,100 , 600, 150);
			titleLabel.setForeground(Color.white);
			titleLabel.setFont(titleFont);
			window.getContentPane().add(titleLabel);
		
			Help = new JButton("Unsaon Pag Dula?");
			Help.setFont(new Font("Segoe Print", Font.PLAIN, 14));
			Help.setForeground(Color.white);
			Help.setBackground(Color.black);
			Help.setBounds(303, 462, 172, 38);
			window.getContentPane().add(Help);
			bck = new JButton("Back");
			bck.setFont(new Font("Segoe Print", Font.PLAIN, 14));
			bck.setForeground(Color.white);
			bck.setBackground(Color.black);
			bck.setBounds(303, 462, 172, 38);
			window.getContentPane().add(bck);
			Help.setActionCommand("help");
			startBtn.setActionCommand("start");
			bck.setActionCommand("back");
			
			icon = new JLabel("");
			icon.setBounds(0, 0, 796, 573);
			Image img = new ImageIcon(this.getClass().getResource("/main.gif")).getImage();
			Image modifiedImage = img.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
			icon.setIcon(new ImageIcon(modifiedImage));
			window.getContentPane().add(icon);
			
		
			
			Help.addActionListener(tHandler);
			startBtn.addActionListener(tHandler);
			bck.addActionListener(tHandler);
			Main();
		}
		public void Main() {
			icon.setVisible(true);
			window.setVisible(true);
			titleLabel.setVisible(true);
			bck.setVisible(false);
			Help.setVisible(true);
			startBtn.setVisible(true);
			mainTextArea.setVisible(false);
			

		}
		 //intro TABAY
		public void Screen() {
			icon2.setVisible(true);
			icon.setVisible(false);
			Help.setVisible(false);
			titleLabel.setVisible(false);
			startBtn.setVisible(false);
			
			choiceBtnPL = new JPanel();
			choiceBtnPL.setBounds(250, 350, 300, 150);
			choiceBtnPL.setBackground(Color.black);
			choiceBtnPL.setLayout(new GridLayout(4,1));
			
			choice1 = new JButton("One");		
			choice2 = new JButton("Two");
			choice3 = new JButton("Three");
			choice4 = new JButton("Four");
			
			choice1.setFont(normalFont);
			choice2.setFont(normalFont);
			choice3.setFont(normalFont);
			choice4.setFont(normalFont);
			
			choice1.setBackground(Color.black);
			choice1.setForeground(Color.white);
			choice2.setBackground(Color.black);
			choice2.setForeground(Color.white);
			choice3.setBackground(Color.black);
			choice3.setForeground(Color.white);
			choice4.setBackground(Color.black);
			choice4.setForeground(Color.white);
			
			choiceBtnPL.add(choice1);		
			choiceBtnPL.add(choice2);		
			choiceBtnPL.add(choice3);
			choiceBtnPL.add(choice4);
			
			choice1.setFocusPainted(false);
			choice2.setFocusPainted(false);
			choice3.setFocusPainted(false);
			choice4.setFocusPainted(false);

			window.getContentPane().add(choiceBtnPL);
			
			playerPL = new JPanel();
			playerPL.setBounds(100, 15, 600, 50);
			playerPL.setBackground(Color.black);
			playerPL.setLayout(new GridLayout(1,4));
			
			enemyhps = new JLabel("");
			enemyhps.setForeground(Color.red);
		    enemyhps.setBounds(625, 76, 100, 27);
			window.getContentPane().add(enemyhps);
			hpLabel = new JLabel("HP:");
			hpLabel.setFont(normalFont);
			hpLabel.setForeground(Color.white);	
			playerPL.add(hpLabel);
			hpLbNum = new JLabel();
			hpLbNum.setFont(normalFont);
			hpLbNum.setForeground(Color.white);
			playerPL.add(hpLbNum);			 
			weaponLabel = new JLabel("Weapon:");
			weaponLabel.setFont(normalFont);
			weaponLabel.setForeground(Color.white);
			playerPL.add(weaponLabel);
			weaponLbName = new JLabel();
			weaponLbName.setFont(normalFont);
			
			weaponLbName.setForeground(Color.white);
			playerPL.add(weaponLbName);
			window.getContentPane().add(playerPL);
			mainTextArea.setVisible(true);
			choice1.setActionCommand("c1");
			choice2.setActionCommand("c2");
			choice3.setActionCommand("c3");
			choice4.setActionCommand("c4");
			choice1.addActionListener(choiceHandler);
			choice2.addActionListener(choiceHandler);
			choice3.addActionListener(choiceHandler);
			choice4.addActionListener(choiceHandler);
			mainTextArea.setFont(normalFont);
			playerSetup();
		}
		//Asedilla
		public void Instructions() {
			
			icon.setVisible(false);
			titleLabel.setVisible(false);
			startBtn.setVisible(false);
			mainTextArea.setVisible(true);
			Help.setVisible(false);
			bck.setVisible(true);
			mainTextArea.setFont(Tutor);
			mainTextArea.setText("1. Kailangan nimo makasulod sa skwelahan (JP)"
					+ "\n\nBag-o ka makasulod pildehon sa nimo ang\nHALIMAW."
					+ "\n\n2. Pag mapildi nimo makuha nimo imong ID."
					+ "\nIstorayhi ang guard pag naa nakay ID"
					+ "\npara makasulod ka!");
			
		}
	
		public void playerSetup() {
			temp="";
			playerHP = 15;
			attackdamage = 5;
			kalabanDamage = 5;
			enemyHP = 15;
			weapon = "Kustilyo";
			event = "";
			weaponLbName.setText(weapon);
			hpLbNum.setText("" + playerHP);
			
			choice3.setVisible(true);
			choice4.setVisible(true);
			Gate();
		}
		public void GuardIstorya() {
			if(ID==1) {
				ending();
			}
			else {
			icon4.setVisible(false);
			icon2.setVisible(false);
			icon3.setVisible(true);
			position = "";
			position = "Istorya";

			mainTextArea.setText("Guard: Hi dong, wala kay ID dili ka kasulod!");
			icon3.setVisible(true);
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			}
		}
		public void AtakihonGuard() {
			
			icon4.setVisible(true);
			icon2.setVisible(false);
			icon3.setVisible(false);
			position = "";
			position = "AtakeGuard";

			mainTextArea.setText("Guard: Hoy! naunsa man ka dong. \ngisumbang ka sa Guard."
					+ "\n\n(na bawasan kag 6!)");
			playerHP = playerHP - 3;
			hpLbNum.setText("" + playerHP);
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		//locations
		public void Gate() {
			icon2.setVisible(true);
			position = "Skwelahan";

			mainTextArea.setText("Naa ka sa gate, gawas sa skwelahan\n"
					+ "naay Guard.\n\nUnsa imong gusto buhaton?");
			choice1.setText("Istoryahon ang guard.");
			choice2.setText("Atakihon ang guard.");
			choice3.setText("Muhawa.");
			choice4.setText("");
		}
		
		public void Kalsada() {
			icon10.setVisible(false);
			icon9.setVisible(false);
			icon8.setVisible(false);
			icon7.setVisible(false);
			icon6.setVisible(false); //espada pp
			icon5.setVisible(false); 
			icon4.setVisible(false);
			icon2.setVisible(false);
			icon3.setVisible(false);
			position = "Kalsada";
		
			mainTextArea.setText("Naa ka kalsada.\nAsa man nimo gusto muadto?");
			choice1.setText("Adto sa skwelahan");
			choice2.setText("Adto sa TimesBeach");
			choice3.setText("Adto sa SM ecoland");
			choice4.setText("Adto sa Peoples Park");
		}
		public void Timesbeach() {
			icon6.setVisible(false);
			position = "Tb";
			int circumstance = r.nextInt(3);
			if(circumstance == 0) {
			icon5.setVisible(true);
			mainTextArea.setText("Naay tubig. Giinom nimo ang tubig. \n\n"
					+ "(+ 2 HP)");
			playerHP = playerHP + 2;
			hpLbNum.setText(" "+playerHP);
			choice1.setText("Adto sa skwelahan");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			}
			else if(circumstance == 1){
				mainTextArea.setText("Naligo kag dagat chooya oy.");
				hpLbNum.setText(" "+playerHP);
				choice1.setText("Adto sa skwelahan");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("");
			}
			else
				mainTextArea.setText("Lingawa diri oy Video Oke Tirada!");
				hpLbNum.setText(" "+playerHP);
				choice1.setText("Adto sa skwelahan");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("");
		}
		public void SM() {
			icon6.setVisible(false);
			position = "SM";
		
			//String enemy = enemies[r.nextInt(enemies.length)];	
			String enemy = "Demonyo";
			temp = enemy;
			 if(temp.equals("Demonyo"))
				icon7.setVisible(true);
				
			 else if(temp.equals("White Lady")){
					icon8.setVisible(true);
			 }
			 else if(temp.equals("Tikbalang")){
					icon9.setVisible(true);
			 }
			 else if(temp.equals("Duwende")){
					icon10.setVisible(true);
			 }
			
		
			
			event = "Naay kalaban, Kaning "+temp+"!\n\nUnsa mang imong buhaton?";
		
			mainTextArea.setText(event);
			choice1.setText("Atakihon");
			choice2.setText("Mudagan");
			choice3.setText("");
			choice4.setText("");
		}
		public void Ppark() {
			icon5.setVisible(false);
			icon6.setVisible(true);
			position = "PP";
			
			mainTextArea.setText("Nag suroy-suroy ka naka kita kag bag ong weapon\n"
					+ "\n(Naka kuha kag \"Espada\")");
			weapon = "Espada";
			weaponLbName.setText(weapon);
			choice1.setText("Adto sa skwelahan");
			choice2.setText("Adto sa TimesBeach");
			choice3.setText("Adto sa SM ecoland");
			choice4.setText("");
			choice4.setVisible(false);
		}
		
		public void playerAttack(){
			position = "playerAttack";
			
			int playerDamage = 0;
			
			if(weapon.equals("Kustilyo")){
				playerDamage = r.nextInt(3);
			}
			else if(weapon.equals("Espada")){
				playerDamage = r.nextInt(12); 
			}
			
			mainTextArea.setText("Gi atake nimo ang "+ temp +" Na damage-an\n siyag ("+playerDamage+")!");
			
			enemyHP = enemyHP - playerDamage;
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");		
		}
		public void monsterAttack(){
			position = "monsterAttack";
		
			 monsterDamage = 0;
			
			monsterDamage = r.nextInt(6); 
		
			mainTextArea.setText("");
			if(temp.equals("Demonyo")) {
				icon7.setVisible(false);
		        icon11.setVisible(true);
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						playerHP = playerHP - monsterDamage;
						hpLbNum.setText(""+playerHP);
						mainTextArea.setText("Gi atake ka sa "+ temp +"!\nNabawasan kag ("+ monsterDamage + ") na kinabuhi!");
						icon7.setVisible(true);
				        icon11.setVisible(false);
				        dem_at.flush();
				    	dem = dem_at.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH); 
						icon11.setIcon(new ImageIcon(dem));
				    
				   
					}
				};
				timer.schedule(task , 6800);
				
			
			
				
				
			}
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");	
		}
		public void fight(){
			position = "fight";
			mainTextArea.setText("Halimaw HP: " + enemyHP + "\n\nUnsa imong buhaton?");
			choice1.setText("Atake");
			choice2.setText("Dagan");
			choice3.setText("");
			choice4.setText("");
		}
		public void win(){
			position = "win";
		
			mainTextArea.setText("Napildi nimo ang kalaban!\nNag tagak ug ID!\n\n(You obtained ID)");
			ID = 1;
			choice1.setText("Adto sa Kalsada");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			
		}
		public void lose(){
			position = "lose";
			
			mainTextArea.setText("Namatay ka!\nMudula paka? \n");
			
			choice1.setText("Oo");
			choice2.setText("Dili na");
			choice3.setText("");
			choice4.setText("");
			choice1.setVisible(true);
			choice2.setVisible(true);
			choice3.setVisible(false);
			choice4.setVisible(false);
		
		}
		//Rivera
		public void ending(){
			position = "ending";
			
			mainTextArea.setText("Guard: Oh Gipatay nimo tong "+ temp +" ?\nSalamat Kaayo. "
					+ "Naa nakay ID payts!\nPwede naka musulod sa JP!\n\n");
			
			choice1.setText("");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			choice1.setVisible(false);
			choice2.setVisible(false);
			choice3.setVisible(false);
			choice4.setVisible(false);
		}
		//Observers
		public boolean plDying() { 	return playerHP<1;}
		public boolean enemyDying() { return enemyHP>1;  }
		public class TitleHandler implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				String clicked = event.getActionCommand();
				if(clicked.equals("start")) {
				Screen();
				}
				else if(clicked.equals("help")) {
					Instructions();
				}
				else if(clicked.equals("back")) {
					Main();
				}
			}
		}
		public class ChoiceHandler implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				choice = event.getActionCommand();
				
				switch(position) {
				case "Tb":
					switch(choice) {
					case "c1": Gate(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
					}
					break;
				case "Skwelahan":
					switch(choice) {
					case "c1":
						GuardIstorya();
						break;
					case "c2": 
						AtakihonGuard();
						break;
					case "c3": 
						Kalsada();
						break;
					}
					break;
				case "playerAttack":
					switch(choice){
					case "c1": 
						if(enemyHP<1){
							win();
						}
						else{
							monsterAttack();
						}
						break;
					}
					break;
				case "Istorya":
					switch(choice) {
					case "c1": Gate(); break;
					}
					break;
				case "AtakeGuard":
					switch(choice) {
					case "c1": 
					if(plDying())
						lose();
					else
						Gate();	
					 break;
				}
					break;
				case "Kalsada":
					switch(choice) {
					case "c1": Gate(); break;
					case "c2": Timesbeach(); break;
					case "c3": SM();break;
					case "c4": Ppark();break;
					} 
					break;
				case "PP":
					switch(choice) {
					case "c1": Gate(); break;
					case "c2": Timesbeach();break;
					case "c3": SM(); break;
					case "c4": break;
					}
					break;
				case "SM":
					switch(choice){
					case "c1": fight();break;
					case "c2": Kalsada(); break;
					}
					break;
				case "monsterAttack":
					switch(choice){
					case "c1": 
						if(plDying()){
							lose();
						}
						else{
							fight();
						}
						break;
					}
					break;
				case "fight":
					switch(choice){
					case "c1": playerAttack();break;
					case "c2": Kalsada(); break;
					}
					break;
				case "win":
					switch(choice){
					case "c1": Kalsada();
					}
					break;
				case "lose":
					switch(choice) {
					case "c1": playerSetup(); break;
					case "c2": System.exit(0); break;
					}
					break;
				}
			
			}
		}
}
