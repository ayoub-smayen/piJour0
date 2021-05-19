package com.project0.esprit.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project0.esprit.entity.Facture;
import com.project0.esprit.entity.Lignecommandeproduit;





public interface IFacture {
	
	public Facture findOne(Long id);
	
	public List<Facture> findAll();
	
	public Facture  save ( Facture f);
	
	public void Delete(Facture f);
	
	public List<Lignecommandeproduit> FactureParIdUser( long id);
	

}