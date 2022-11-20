package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is an object used to hold an order's information
 * @author Josh Beck
 *
 */

@XmlRootElement
@ManagedBean
@SessionScoped
public class BibleResults {

	/*************** DECLARATIONS *****************/
	@NotNull()
	@Size(min=1)
	String searchedWord = "";
	
	List<BibleResult> oldTestementResults = new ArrayList<BibleResult>();
	List<BibleResult> newTestementResults = new ArrayList<BibleResult>();
	int totalResults = -1;
	int verseResults = -1;
	
	/***************** GETTER/SETTERS *************/
	public int getVerseResults() {
		return verseResults;
	}
	public void setVerseResults(int verseResults) {
		this.verseResults = verseResults;
	}
	public String getSearchedWord() {
		return searchedWord;
	}
	public void setSearchedWord(String searchedWord) {
		this.searchedWord = searchedWord;
	}
	public List<BibleResult> getOldTestementResults() {
		return oldTestementResults;
	}
	public void setOldTestementResults(List<BibleResult> oldTestementResults) {
		this.oldTestementResults = oldTestementResults;
	}
	public List<BibleResult> getNewTestementResults() {
		return newTestementResults;
	}
	public void setNewTestementResults(List<BibleResult> newTestementResults) {
		this.newTestementResults = newTestementResults;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	
	/************** CONSTRUCTORS ***************/
	public BibleResults(String searchedWord, int verseResults, int totalResults, List<BibleResult> oldTestementResults, 
			List<BibleResult> newTestementResults) {
		super();
		this.searchedWord = searchedWord;
		this.oldTestementResults = oldTestementResults;
		this.newTestementResults = newTestementResults;
		this.totalResults = totalResults;
		this.verseResults = verseResults;
	}
	public BibleResults() {
		super();
	}
	
	
}
