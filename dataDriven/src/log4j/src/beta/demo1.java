package beta;
import org.apache.logging.log4j.*;

public class demo1 {
	
	private static Logger log=LogManager.getLogger(demo1.class.getClass());
	public static void main(String[] args)
	{
		log.debug("i am debugging");
		
		
			log.debug("object is present");
		
		
		
			log.error("no object present");
		
	}

}
