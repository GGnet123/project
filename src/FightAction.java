import java.io.FileInputStream;
import javafx.scene.shape.*;
import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;  
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.event.*;
import javafx.scene.control.Button;

public class FightAction extends Pane {
	Arena arena;
	Heroes hero;
	Monsters monster;
	int herohp;
	int monsterhp;
	public FightAction(Heroes hero, Monsters monster) {
		this.hero = hero;
		this.monster = monster;
		herohp = hero.hp;
		monsterhp = monster.getHP();
	}
	public void gotAttacked() {
		herohp = herohp - monster.attack;
	}
	public void Attack() {
		monsterhp = monsterhp - hero.attack;
	}
}
