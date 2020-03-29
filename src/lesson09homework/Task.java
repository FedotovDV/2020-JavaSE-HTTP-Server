package lesson09homework;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface Task {

	void start();
	
	void interrupt();
	
	int getPercentProgress();
}