
public class Sword2 extends HeroDecorator{
	Heroes hero;
	public Sword2(Heroes hero) {
		this.hero = hero;
		attack = hero.AttackPower()+20;
		url = hero.url;
		shoplink1 = hero.shoplink1;
		shoplink2 = hero.shoplink2;
		shoplink3 = hero.shoplink3;
		shoplink4 = hero.shoplink4;
		hp = hero.hp;
		Width = hero.Width;
		Height = hero.Height;
		Xhero=hero.Xhero;
		Yhero=hero.Yhero;
	}
	
	public int AttackPower() {
		return hero.AttackPower()+20;
	}
	public int getHP() {
		return hero.getHP();
	}
	public void SuperPower(FightAction action, Arena arena) {
		hero.attack = attack;
		hero.SuperPower(action, arena);
	}
}
