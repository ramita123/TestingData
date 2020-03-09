package alpha;
import org.apache.logging.log4j.*;

public class demo {
	
	private static Logger log=LogManager.getLogger(demo.class.getClass());
	public static void main(String[] args)
	{
		log.debug("i am debugging");
		
		
			log.debug("object is present");
		
		
		
			log.error("no object present");
		
	}

}
