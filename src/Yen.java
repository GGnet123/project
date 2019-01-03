import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Yen extends Heroes{
	public Yen() throws FileNotFoundException {
		superurl = "HeroImgs//YenPower.jpeg";
		url = "HeroImgs//YenFight.png";
		shoplink1 = "imgs//staff1.png";
		shoplink2 = "imgs//staff2.png";
		shoplink3 = "imgs//staff3.png";
		shoplink4 = "imgs//staff4.png";
		shoplink5 = "imgs//staff5.png";
		hp = 200;
		attack = 15;
		Width = 560;
		Height = 670;
		Xhero=12;
		Yhero=9;
	}
	
	public int AttackPower() {
		return 15;
	}
	public int getHP() {
		return 200;
	}

	public void SuperPower(FightAction action,Arena arena) {
		action.herohp += attack + 20;
		Text heal = new Text("Healing");
		heal.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
		heal.setFill(Color.GREEN);
		heal.setX(600);
		heal.setY(200);
		
		DropShadow glow = new DropShadow();
		glow.setColor(Color.GREEN);
		glow.setOffsetX(5f);
		glow.setOffsetY(5f);
		glow.setHeight(100);
		glow.setWidth(100);
		arena.HeroImg.setEffect(glow);
		FadeTransition ft = new FadeTransition(Duration.millis(1500), heal);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		arena.getChildren().add(heal);
		ft.play();
		ft.setOnFinished(e->{
			arena.getChildren().remove(heal);
			arena.HeroImg.setEffect(null);
		});
	}
	
}
