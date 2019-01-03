import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Heroes {
	String superurl = "";
	String url = "";
	String shoplink1  = "";
	String shoplink2  = "";
	String shoplink3  = "";
	String shoplink4  = "";
	String shoplink5  = "";
	int hp = 0;
	int attack = 0;
	int Width = 850;
	int Height = 600;
	int Xhero=6;
	int Yhero=70;
	public abstract int AttackPower();
	public abstract int getHP();
	public abstract void SuperPower(FightAction action,Arena arena);
}
