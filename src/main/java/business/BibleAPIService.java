package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.BibleResults;

/**
 * A service for reading from the API
 * @author Josh Beck
 *
 */
@Stateless
@Local(BibleAPIInterface.class)
@LocalBean
@Alternative
public class BibleAPIService implements BibleAPIInterface {

	String word = "";
	
	public String getWord() {
		return this.word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	BibleResults results = new BibleResults();
	
	public BibleResults getResults() {
		return this.results;
	}
	Client client;
	public BibleAPIService() {
	    this.client = ClientBuilder.newClient();
	}
	public BibleResults searchBible() {
		
		BibleResults results = null;
		
        try {
        	results = client.target("http://localhost:8080/biblemilestone/rest/bible/")
                    .path("search/" + this.getWord())
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<BibleResults>() {
            });
        } catch (WebApplicationException ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        this.results = results;
        
        return results;

	}
	
}

