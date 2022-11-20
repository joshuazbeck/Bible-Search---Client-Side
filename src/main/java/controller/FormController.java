package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.BibleResults;

import business.BibleAPIInterface;


/**
 * The controller in charge of manipulating the FormController
 * @author Josh Beck
 *
 */
@ManagedBean
@ViewScoped
public class FormController {
	
	@EJB
	BibleAPIInterface service;
	
	public BibleAPIInterface getService() {
		return this.service;
	}
	public String searchBible() {
		
		//Service pulls the word off of the partially constructed BibleResults contained in the API service module
		BibleResults results = service.searchBible();
		if (results.getTotalResults() > 0) {
			return "Response.xhtml";
		} else {
			return "Failure.xhtml";
		}
		
	}
	
}
