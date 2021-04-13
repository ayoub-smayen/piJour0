package com.project0.esprit.service.panier;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project0.esprit.entity.panier.Commande;
import com.project0.esprit.entity.panier.Facture;
import com.project0.esprit.entity.panier.lignecommandeproduit;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.repository.panier.CommandeRepository;
import com.project0.esprit.repository.panier.FactureRepository;
import com.project0.esprit.repository.panier.LigneCommandeRepository;


@Service
public class FactureImpl implements IFacture {

@Autowired
FactureRepository factureRepository;

@Autowired
CommandeRepository commandeRepository;

@Autowired
LigneCommandeRepository ligneCommandeRepository;

@Autowired
EuserRepository userRepository;


public Facture  Ajouter (long idCommande)
{
	Commande c =commandeRepository.getOne(idCommande);
	Facture f = new Facture();
	f.setDate(LocalDate.now());
	f.setType("non");
	f.setCommande(c);
	return factureRepository.save(f);
}

public Facture findOne(Long id) {
	return factureRepository.getOne(id);
}


public List<Facture> findAll() {
	return factureRepository.findAll();
}


public Facture  save ( Facture f)
{
	f.setDate(LocalDate.now());
	return factureRepository.save(f);
}

public Facture  FactureByCommande ( Commande c)
{
	return factureRepository.FactureParCommander(c);
}


public void Delete(Facture f) {
	factureRepository.delete(f);
}


public List<lignecommandeproduit> FactureParIdUser( long id) {
	return factureRepository.FactureParIdUser(id);

}

public void ajouterUneFacture (long Commande_id){
	Commande c = commandeRepository.getOne(Commande_id);;
	  List<Facture> lf = factureRepository.findAll();
	  boolean verif = false;
	    for (Facture z : lf)
	    {
	    	if(z.getCommande().getId() == Commande_id)
	    	{
	    		verif = true;
	    	}
		}
	    if(verif == false){
	    Facture f = new Facture();
		f.setType(c.getTypedePayment());
		ZoneId zid = ZoneId.of("Africa/Tunis");
		f.setDate(LocalDate.now(zid));
		f.setCommande(c);
		factureRepository.save(f);
	    }
        }
 
public List<lignecommandeproduit> CreePDF (long id){
	List<lignecommandeproduit> l = ligneCommandeRepository.panierParIdCommande(id);
	return l;
}
}

