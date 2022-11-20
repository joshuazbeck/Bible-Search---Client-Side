package business;


import javax.ejb.Local;

import beans.BibleResults;

/**
 * Interface to define some API reader methods
 * @author Josh Beck
 *
 */
@Local
public interface BibleAPIInterface {

	public void setWord(String word);
	
	public String getWord();
	
	public BibleResults getResults();
	
	public BibleResults searchBible();

}
