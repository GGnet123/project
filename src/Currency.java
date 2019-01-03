import java.util.*;

public class Currency implements SubjectInt  {
	private ArrayList<Observer> observers;
	private int value1;
	private int hitcount;
	public Currency() {
		observers = new ArrayList<Observer>();
	}
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	public void ValuesChanged() {
		notifyObserver();
	}
	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
		observers.remove(i);
		}
	}
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.Update(value1,hitcount);
		}
	}
	public void differ(int hitcount) {
		this.hitcount=hitcount;
		if(hitcount==3) {
			ValuesChanged();
			this.hitcount = 0;
		}
	}
}
