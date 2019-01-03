import java.io.FileNotFoundException;
import java.util.Random;
import javafx.scene.text.*;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
public class Herald extends Heroes{
	FightAction action;
	Monsters monster;
	int monsterhp;
	Arena arena;
	Heroes hero;
	public Herald() throws FileNotFoundException {
		superurl = "HeroImgs//HeraldRage.jpg";
		url = "HeroImgs//HeraldFight.png";
		shoplink1 = "imgs//sword1.png";
		shoplink2 = "imgs//sword2.png";
		shoplink3 = "imgs//sword3.png";
		shoplink4 = "imgs//sword4.png";
		shoplink5 = "imgs//sword5.png";
		hp = 200;
		attack = 15;  
		Width = 850;
		Height = 600;
		Xhero=0;
		Yhero=70;
	}	
	public int AttackPower() {
		return 15;
	}
	public int getHP() {
		return 200;
	}
	public void SuperPower(FightAction action, Arena arena) {
		Random rand = new Random();
		int rng = rand.nextInt(15)+1;
		attack += rng;
		action.Attack();
		Text dmg = new Text("Counter Hit! -" + attack);
		
		dmg.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
		dmg.setFill(Color.RED);
		dmg.setX(460);
		dmg.setY(250);
		
		DropShadow glow = new DropShadow();
		glow.setColor(Color.RED);
		glow.setOffsetX(1f);
		glow.setOffsetY(1f);
		glow.setHeight(400);
		glow.setWidth(400);
		arena.monsterImg.setEffect(glow);
		
		FadeTransition ft = new FadeTransition(Duration.millis(1000), dmg);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		arena.getChildren().add(dmg);
		ft.play();
		ft.setOnFinished(e->{
			attack = AttackPower();
			arena.getChildren().remove(dmg);
			arena.monsterImg.setEffect(null);
		});	
		
	}
}