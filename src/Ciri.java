import javafx.scene.control.*;
import java.io.FileNotFoundException;
import javafx.animation.FadeTransition;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.util.Duration;
public class Ciri extends Heroes {
	public Ciri() throws FileNotFoundException {
		superurl = "HeroImgs//CiriPower.jpeg";
		url = "HeroImgs//CiriFight.png";
		shoplink1 = "imgs//sword1.png";
		shoplink2 = "imgs//sword2.png";
		shoplink3 = "imgs//sword3.png";
		shoplink4 = "imgs//sword4.png";
		shoplink5 = "imgs//sword5.png";
		attack = 15;
		hp = 200;
		Width = 560;
		Height = 690;
		Xhero=30;
		Yhero=5;
	}
	public int AttackPower() {
		return 15;
	}
	public int getHP() {
		return 200;
	}
	
	public void SuperPower(FightAction action, Arena arena){
		action.monster.attack = 0;
		
		DropShadow glow = new DropShadow();
		glow.setColor(Color.BLUE);
		glow.setOffsetX(5f);
		glow.setOffsetY(5f);
		glow.setHeight(300);
		glow.setWidth(300);
		arena.HeroImg.setEffect(glow);
		
		Text timer = new Text("whatever");
		FadeTransition ft = new FadeTransition(Duration.millis(6300), timer);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		
		arena.getChildren().addAll(timer);
		ft.play();
		ft.setOnFinished(e->{
			arena.getChildren().remove(timer);
			arena.HeroImg.setEffect(null);
			action.monster.attack += action.monster.AttackPower();
		});
	}
}
