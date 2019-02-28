package weather;

/**
 * CirrusCloud class represents a cirrus cloud and extends the cloud class
 * @author Caitlyn Chau
 * CS 46B HW2
 */
public class CirrusCloud extends Cloud{
	
	/**
	 * Constructor calls superclass constructor with two floats
	 * @param bottom - bottom height of cloud
	 * @param top - top height of cloud
	 */
	public CirrusCloud(float bottom, float top){
		super(bottom, top);
	}
	
	/**
	 * rain method overrides its superclass' rain method
	 * @return String
	 */
	public String rain(){
		return "I cannot make rain";
	}

}
