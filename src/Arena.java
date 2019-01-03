import java.io.BufferedReader;
import java.io.FileInputStream;
import javafx.animation.ScaleTransition;
import javafx.scene.shape.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.*;
import javafx.scene.ImageCursor;
public class Arena extends Pane {//our Arena is also pane
	String url;
	Heroes hero;
	int Width,Height,widthMonster,heightMonster,X,Y,Xhero,Yhero;
	String arenalvl;
	String monster;
	Monsters mnstr;
	Shop shop;
	FightAction action;
	ImageView HeroImg;
	ImageView monsterImg;
	DropShadow gotHit;
	boolean freeze = false;
	boolean permission = true;
	int hitcount = 0;
	Text MonsterHp = new Text("1");
	Text HeroHp = new Text("1");
	public Arena(int lvl,Stage stage,Heroes hero) throws FileNotFoundException{
		//glow effect
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.RED);
		shadow.setOffsetX(1f);
		shadow.setOffsetY(1f);
		shadow.setHeight(50);
		shadow.setWidth(50);
		
		Image cursor = new Image(new FileInputStream("Imgs/Cursor.png"));//Image of new Cursor
		
		if(lvl == 1) {
			arenalvl = "backgrounds/Arena1.jpg";
			monster = "monsterImgs/gnoll.png";
			mnstr = new Gnoll();
			widthMonster=440;
			heightMonster=560;
			X=770;
			Y=90;
		}
		if(lvl == 2) {
			arenalvl = "backgrounds/Arena2.jpg";
			monster = "monsterImgs/harpy.png";
			mnstr = new Harpy();
			widthMonster=520;
			heightMonster=670;
			X=740;
			Y=10;
		}
		if(lvl == 3) {
			arenalvl = "backgrounds/Arena3.jpg";
			monster = "monsterImgs/ogre.png";
			mnstr = new Ogre();
			widthMonster=500;
			heightMonster=600;
			X=770;
			Y=80;
		}
		if(lvl == 4) {
			arenalvl = "backgrounds/Arena4.jpg";
			monster = "monsterImgs/ghoul.png";
			mnstr = new Ghoul();
			widthMonster=600;
			heightMonster=780;
			X=700;
			Y=80;
		}
		if(lvl == 5) {
			arenalvl = "backgrounds/Arena5.jpg";
			monster = "monsterImgs/dragon.png";
			mnstr = new Dragon();
			widthMonster=1700;
			heightMonster=950;
			X=450;
			Y=-195;
		}
		Image Arena = new Image(new FileInputStream(arenalvl));  
		ImageView ArenaImg = new ImageView(Arena);
		ArenaImg.setFitHeight(780);
		ArenaImg.setFitWidth(1380);
		getChildren().add(ArenaImg);
		
		action = new FightAction(hero,mnstr);
		
		Image Hero1 = new Image(new FileInputStream(hero.url));  
		HeroImg = new ImageView(Hero1);
		HeroImg.setFitWidth(hero.Width);
		HeroImg.setFitHeight(hero.Height);
		HeroImg.setX(hero.Xhero);
		HeroImg.setY(hero.Yhero);
		getChildren().add(HeroImg);
		
		Image mn = new Image(new FileInputStream(monster));  
		monsterImg = new ImageView(mn);
		
		//need to correct also
		monsterImg.setFitWidth(widthMonster);
		monsterImg.setFitHeight(heightMonster);
		monsterImg.setX(X);
		monsterImg.setY(Y);
		getChildren().add(monsterImg);
		
		//swords
		Image fight = new Image(new FileInputStream("Imgs/sword.png"));
		Circle upper = new Circle();
		upper.setCenterX(520);
		upper.setRotate(-90);
		upper.setCenterY(140);
		upper.setRadius(50);
		upper.setStroke(Color.GREEN);
		upper.setStrokeWidth(3);
		upper.setFill(new ImagePattern(fight));

		Circle mid = new Circle();
		mid.setCenterX(520);
		mid.setCenterY(370);
		mid.setRadius(50);
		mid.setRotate(-40);
		mid.setStroke(Color.GREEN);
		mid.setStrokeWidth(3);
		mid.setFill(new ImagePattern(fight));

		Circle bot = new Circle();
		bot.setCenterX(520);
		bot.setCenterY(630);
		bot.setRadius(50);
		bot.setStroke(Color.GREEN);
		bot.setStrokeWidth(3);
		bot.setFill(new ImagePattern(fight));
		getChildren().addAll(upper,mid,bot);
		
		upper.setOnMouseEntered(e ->{   
				upper.setEffect(shadow); 
		});
		upper.setOnMouseExited(e ->{
			upper.setEffect(null); 
		});
		mid.setOnMouseEntered(e -> 
		{   
			mid.setEffect(shadow); 
		});
		mid.setOnMouseExited(e ->{
			mid.setEffect(null); 
		});
		
		bot.setOnMouseEntered(e -> 
		{   
			bot.setEffect(shadow); 
		});
		bot.setOnMouseExited(e ->{
			bot.setEffect(null); 
		});
		
		MonsterHp.setText(Integer.toString(action.monsterhp));
		HeroHp.setText(Integer.toString(action.herohp));
		getChildren().addAll(HeroHp,MonsterHp);
		HeroHp.setY(700);
		HeroHp.setFill(Color.GREEN);
		HeroHp.setFont(Font.font ("Verdana", 50));
		
		MonsterHp.setY(700);
		MonsterHp.setX(1200);
		MonsterHp.setFill(Color.GREEN);
		MonsterHp.setFont(Font.font ("Verdana", 50));
		
		Text miss = new Text("Miss");
		miss.setFill(Color.TRANSPARENT);
		miss.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
		getChildren().add(miss);
		
		//All the Fight Animation
		Path path = new Path();
	    path.getElements().add (new MoveTo (650f, 300f));
	    path.getElements().add (new CubicCurveTo (650f, -20f, 650f, 100f, 650f, -20f));
	    
		PathTransition pt = new PathTransition();
		pt.setOrientation(OrientationType.NONE);
		pt.setDuration(Duration.seconds(1.5));
	    pt.setDelay(Duration.seconds(.5));
	    pt.setPath(path);
	    pt.setNode(miss);
	    pt.setCycleCount(1);
	    pt.setAutoReverse(false);

		FadeTransition ft = new FadeTransition(Duration.millis(2000), miss);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);

		Text dmgnum = new Text("-"+Integer.toString(hero.AttackPower()));
		dmgnum.setFill(Color.RED);
		dmgnum.setX(620);
		dmgnum.setY(200);
		dmgnum.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
		
		
		FadeTransition dmg = new FadeTransition(Duration.millis(1000), dmgnum);
		dmg.setFromValue(1.0);
		dmg.setToValue(0.0);
		dmg.setCycleCount(1);
		dmg.setAutoReverse(false);
			
		gotHit = new DropShadow();
		gotHit.setColor(Color.RED);
		gotHit.setOffsetX(5f);
		gotHit.setOffsetY(5f);
		gotHit.setHeight(100);
		gotHit.setWidth(100);
		
		upper.setOnMousePressed(e->{
			double misschance = Math.random()*1;
			if(misschance<0.6  && permission == true){
				permission = false;
				hitcount=0;
				miss.setFill(Color.RED);
				pt.play();
				ft.play();
				ft.setOnFinished(e1->{
					action.gotAttacked();
					HeroImg.setEffect(gotHit);
					dmgnum.setText("-"+Integer.toString(mnstr.attack));
					getChildren().add(dmgnum);
					dmg.play();
					dmg.setOnFinished(e2->{
						getChildren().remove(dmgnum);
						HeroImg.setEffect(null);
						permission = true;
						if(action.herohp>0) {
							HeroHp.setText(Integer.toString(action.herohp));
						}
						else {
							HeroHp.setText("0");
						}
					});
				});
			}
			if(misschance>0.6  && permission == true) {
				permission = false;
				hero.attack = hero.AttackPower() + 30;
				action.Attack();
				dmgnum.setText("-"+Integer.toString(hero.attack));
				hitcount++;
				getChildren().add(dmgnum);
				dmg.play();
				monsterImg.setEffect(gotHit);
				dmg.setOnFinished(event->{
					monsterImg.setEffect(null);
					getChildren().remove(dmgnum);	
					if(action.monsterhp>0) {
						action.gotAttacked();
						HeroImg.setEffect(gotHit);
						dmgnum.setText("-"+Integer.toString(mnstr.attack));
						getChildren().add(dmgnum);
						dmg.play();
						dmg.setOnFinished(e1->{
							getChildren().remove(dmgnum);
							HeroImg.setEffect(null);
							if(action.herohp>0) {
								HeroHp.setText(Integer.toString(action.herohp));
							}
							else {
								HeroHp.setText("0");
							}
								permission = true;
						});
					}
				});
			}
		});
		
		mid.setOnMousePressed(e->{
			double misschance = Math.random()*1;
			if(misschance<0.4 && permission == true){
				permission = false;
				hitcount=0;
				miss.setFill(Color.RED);
				pt.play();
				ft.play();
				ft.setOnFinished(e1->{
					action.gotAttacked();
					HeroImg.setEffect(gotHit);
					dmgnum.setText("-"+Integer.toString(mnstr.attack));
					getChildren().add(dmgnum);
					dmg.play();
					dmg.setOnFinished(e2->{
						getChildren().remove(dmgnum);
						HeroImg.setEffect(null);
						if(action.herohp>0) {
							HeroHp.setText(Integer.toString(action.herohp));
						}
						else {
							HeroHp.setText("0");
						}
						permission = true;
					});
				});
			}
			if(misschance>0.4 && permission == true) {
				permission = false;
				hero.attack = hero.AttackPower() + 15;
				action.Attack();
				dmgnum.setText("-"+Integer.toString(hero.attack));
				hitcount++;
				getChildren().add(dmgnum);
				dmg.play();
				monsterImg.setEffect(gotHit);
				dmg.setOnFinished(event->{
					monsterImg.setEffect(null);
					getChildren().remove(dmgnum);	
					if(action.monsterhp>0) {
						action.gotAttacked();
						HeroImg.setEffect(gotHit);
						dmgnum.setText("-"+Integer.toString(mnstr.attack));
						getChildren().add(dmgnum);
						dmg.play();
						dmg.setOnFinished(e1->{
							permission = true;
							getChildren().remove(dmgnum);
							HeroImg.setEffect(null);
							if(action.herohp>0) {
								HeroHp.setText(Integer.toString(action.herohp));
							}
							else {
								HeroHp.setText("0");
							}
						});
					}
				});
			}
			
		});
		
		bot.setOnMousePressed(e->{
			double misschance = Math.random()*1;
			if(misschance<0.15 && permission == true){
				permission = false;
				hitcount=0;
				miss.setFill(Color.RED);
				pt.play();
				ft.play();
				ft.setOnFinished(e1->{
					action.gotAttacked();
					HeroImg.setEffect(gotHit);
					dmgnum.setText("-"+Integer.toString(mnstr.attack));
					getChildren().add(dmgnum);
					dmg.play();
					dmg.setOnFinished(e2->{
						getChildren().remove(dmgnum);
						HeroImg.setEffect(null);
						permission = true;
						if(action.herohp>0) {
							HeroHp.setText(Integer.toString(action.herohp));
						}
						else {
							HeroHp.setText("0");
						}
					});
				});
			}
			if(misschance>0.15 && permission == true) {
				permission = false;
				hero.attack = hero.AttackPower();
				action.Attack();
				dmgnum.setText("-"+Integer.toString(hero.attack));
				hitcount++;
				getChildren().add(dmgnum);
				dmg.play();
				monsterImg.setEffect(gotHit);
				dmg.setOnFinished(event->{
					monsterImg.setEffect(null);
					getChildren().remove(dmgnum);	
					if(action.monsterhp>0) {
						action.gotAttacked();
						HeroImg.setEffect(gotHit);
						dmgnum.setText("-"+Integer.toString(mnstr.attack));
						getChildren().add(dmgnum);
						dmg.play();
						dmg.setOnFinished(e1->{
							permission = true;
							getChildren().remove(dmgnum);
							HeroImg.setEffect(null);
							if(action.herohp>0) {
								HeroHp.setText(Integer.toString(action.herohp));
							}
							else {
								HeroHp.setText("0");
							}
						});
					}
				});
			}
		});
		Button back = new Button("Back to Map"); //need to decorate
		
		//ObserverPattern!
		Currency cr = new Currency();
		DisplayHitcount dh =new DisplayHitcount(cr,this,hero,action,HeroHp,MonsterHp);
		setOnMouseClicked(e->{	
			cr.differ(hitcount);
			if(action.monsterhp>0) {
				MonsterHp.setText(Integer.toString(action.monsterhp));
			}
			else {
				MonsterHp.setText("0");
			}
			
			if(action.herohp <= 0 && freeze!= true) {
				Text dead = new Text("You Died!");
				dead.setFill(Color.RED);
				dead.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
				dead.setX(600);
				dead.setY(300);
				getChildren().add(dead);
				ScaleTransition st = new ScaleTransition(Duration.millis(2000),dead);
				st.setByX(1.5f);
				st.setByY(1.5f);
				st.play();
				freeze = true;
				back.setOnAction(event->{
					try {
						Map	map = new Map(stage,hero);
						Scene scene = new Scene(map,1300,700);
						scene.setCursor(new ImageCursor(cursor));
						stage.setScene(scene);
						stage.setFullScreen(true);
						stage.setTitle("Hero Adventures!");
						stage.show();
					} catch (FileNotFoundException e1) {} 		
				});
				getChildren().add(back);	
			}
			if(action.monsterhp <= 0 && freeze!=true) {
				Text Won = new Text("Victory!");
				try {
					BufferedReader br = new BufferedReader(new FileReader("Money.txt"));
					String money = br.readLine();
					int gold = Integer.parseInt(money);
					gold += mnstr.getGold();
					PrintWriter writer = new PrintWriter("Money.txt", "UTF-8");
					writer.println(gold);
					writer.close();
				} catch (FileNotFoundException e2) {} catch (IOException e1) {}
				Won.setFill(Color.GREEN);
				Won.setFont(Font.font("Tahoma",FontWeight.BOLD, 50));
				Won.setX(600);
				Won.setY(300);
				getChildren().add(Won);
				ScaleTransition st = new ScaleTransition(Duration.millis(2000),Won);
				st.setByX(1.5f);
				st.setByY(1.5f);
				st.play();
				freeze = true;
				getChildren().add(back);	
		
				back.setOnAction(event->{
					try {
						Map	map = new Map(stage,hero);
						Scene scene = new Scene(map,1300,700);
						scene.setCursor(new ImageCursor(cursor));
						stage.setScene(scene);
						stage.setFullScreen(true);
						stage.setTitle("Hero Adventures!");
						stage.show();
					} catch (FileNotFoundException e1) {} 		
				});
			}
			stage.setOnCloseRequest(event->{
				PrintWriter writer;
				try {
					writer = new PrintWriter("Money.txt", "UTF-8");
					writer.println(0);
					writer.close();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {}			
			});	
		});
	}
}