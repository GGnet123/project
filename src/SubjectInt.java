public interface SubjectInt {
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObserver();
	
}
