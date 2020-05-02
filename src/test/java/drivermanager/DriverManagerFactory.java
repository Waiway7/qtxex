package drivermanager;

public class DriverManagerFactory {
	
	public static DriverManager getManager(String browserType) {
		
		if(browserType.equals(DriverType.Chrome)) {
			return new ChromeDriverManager();
		}
		else if(browserType.equals(DriverType.FireFox)) {
			return new FireFoxManager();
		}
			
		throw new RuntimeException(browserType + " is not a supported browser.");
	}
}