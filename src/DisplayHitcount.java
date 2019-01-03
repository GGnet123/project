import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
public class DisplayHitcount implements Observer , Display{
	private Currency cr;
	private int hitcount;
	Arena arena;
	Text HeroHp;
	Heroes hero;
	Text MonsterHp;
	FightAction action;
	Circle SuperPower = new Circle();
	
	public DisplayHitcount(Currency cr,Arena arena,Heroes hero,FightAction action,Text HeroHp,Text MonsterHp) throws FileNotFoundException {
		
		this.HeroHp = HeroHp;
		this.MonsterHp = MonsterHp;
		this.hero = hero;
		this.action = action;
		this.arena = arena;
		this.cr = cr;
		cr.registerObserver(this);
	}
	public void Update(int hitcount,int diff) {
		this.hitcount = hitcount;
		hitcount = 0;
		display();
	}
	public void display(){
		SuperPower.setCenterX(705);
	    SuperPower.setCenterY(363);
	    SuperPower.setRadius(55);
	    SuperPower.setStroke(Color.BLUE);
	    SuperPower.setStrokeWidth(1);
	    Image power;
		try {
			power = new Image(new FileInputStream(hero.superurl));
			SuperPower.setFill(new ImagePattern(power));//it does not work without ImagePattern (that is how we put an image into SuperPower)
		} catch (FileNotFoundException e1) {}
		
		arena.hitcount = 0;
		if(!arena.getChildren().contains(SuperPower)) {
			arena.getChildren().add(SuperPower);
		}
		SuperPower.setOnMouseClicked(e->{
			hero.SuperPower(action,arena);
			arena.getChildren().remove(SuperPower);
			if(action.herohp>0) {
				HeroHp.setText(Integer.toString(action.herohp));
			}
			else {
				HeroHp.setText("0");
			}
			if(action.monsterhp>0) {
				MonsterHp.setText(Integer.toString(action.monsterhp));
			}
			else {
				MonsterHp.setText("0");
			}
		});
	}
}

