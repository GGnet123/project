
public class Armor2 extends HeroDecorator{
	Heroes hero;
	public Armor2(Heroes hero) {
		this.hero = hero;
		url = hero.url;
		attack = hero.attack;
		shoplink1 = hero.shoplink1;
		shoplink2 = hero.shoplink2;
		shoplink3 = hero.shoplink3;
		shoplink4 = hero.shoplink4;
		shoplink5 = hero.shoplink5;
		hp = hero.getHP()+200;
		Width = hero.Width;
		Height = hero.Height;
		Xhero=hero.Xhero;
		Yhero=hero.Yhero;
	}
	
	public int AttackPower() {
		return hero.AttackPower();
	}
	public int getHP() {
		return hero.getHP();
	}
	public void SuperPower(FightAction action, Arena arena) {
		hero.attack = attack;
		hero.SuperPower(action, arena);
	}
}
