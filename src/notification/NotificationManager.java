package notification;

import java.util.ArrayList;
import java.util.List;



public class NotificationManager {
	private static NotificationManager instance;
	private List<Observer> liste_obs = new ArrayList<Observer>();
	
	
	private NotificationManager() {
		
	}	   
	
	public static NotificationManager getInstance() {
        if (instance == null) {
        	return new NotificationManager();
        }
        return instance;
	}
	
	public void suscribe(Observer o) {
		liste_obs.add(o);
	}
	
	
	public void NotifyObserver(String message, Observer o) {
			o.update(message);
	}
	
	public void NotifyAllObserver(String message) {
		for (Observer o : liste_obs) {
			o.update(message);
		}
	}

}


