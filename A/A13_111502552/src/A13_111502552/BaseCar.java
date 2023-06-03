package A13_111502552;

public class BaseCar {
	public String driver;
	public int speed, boost, driver_boost;
	
	public int boostTimer = 0;
	
	public int curLength = 0;
	
	public BaseCar(String driver, int speed, int boost, int driver_boost) {
		this.driver = driver;
		this.speed = speed;
		this.boost = boost;
		this.driver_boost = driver_boost;
	}
	
	public void startBoost() {
		this.boostTimer = 10;
	}
	
	public void proceed() {
		if (boostTimer > 0) {
			boostTimer--;
			
			curLength += speed + boost + driver_boost;
			return;
		}
		
		curLength += speed + driver_boost;
	}
}
