package weather;

/**
 * CumulusCloud class represents a cumulus cloud and extends the cloud class
 * @author Caitlyn Chau
 * CS 46B HW2
 */
public class CumulusCloud extends Cloud{
	
	/**
	 * Constructor calls superclass constructor with two floats
	 * @param bottom - bottom height of cloud
	 * @param top - top height of cloud
	 */
	public CumulusCloud(float bottom, float top){
		super(bottom, top);
	}

}
