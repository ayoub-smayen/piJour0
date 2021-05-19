package com.project0.esprit.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Lignecommandeproduit  implements Serializable {

	
private static final long serialVersionUID = 1L;
	
	private long id;
	
	private long idp;
	
	private String nomProduit;
	
	private int quantity;
	
	private double price;
	
	
	
	
	
	public Lignecommandeproduit(long id, long idp, String nomProduit, int quantity, double price, double total,
			double montant) {
		super();
		this.id = id;
		this.idp = idp;
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.montant = montant;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Lignecommandeproduit [id=" + id + ", idp=" + idp + ", nomProduit=" + nomProduit + ", quantity="
				+ quantity + ", price=" + price + ", total=" + total + ", name=" + name + ", date=" + date
				+ ", montant=" + montant + ", remiseFidelite=" + remiseFidelite + ", porcentagederemise="
				+ porcentagederemise + ", nb_pointFidelite=" + nb_pointFidelite + "]";
	}

	private double total;

	private String name ;
	
	private LocalDate date;
	
	private double montant;
	
	private boolean remiseFidelite;
	
	private int porcentagederemise;
	
	private int nb_pointFidelite;
	

	public Lignecommandeproduit(boolean remiseFidelite, int porcentagederemise, int nb_pointFidelite) {
		super();
		this.remiseFidelite = remiseFidelite;
		this.porcentagederemise = porcentagederemise;
		this.nb_pointFidelite = nb_pointFidelite;
	}

	public boolean isRemiseFidelite() {
		return remiseFidelite;
	}

	public void setRemiseFidelite(boolean remiseFidelite) {
		this.remiseFidelite = remiseFidelite;
	}

	public int getPorcentagederemise() {
		return porcentagederemise;
	}

	public void setPorcentagederemise(int porcentagederemise) {
		this.porcentagederemise = porcentagederemise;
	}

	public int getNb_pointFidelite() {
		return nb_pointFidelite;
	}

	public void setNb_pointFidelite(int nb_pointFidelite) {
		this.nb_pointFidelite = nb_pointFidelite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}
	
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	

	public double getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	public Lignecommandeproduit(int quantity, float price) {
		super();
		this.quantity = quantity;
		this.price = price;
	
	}
	
	public Lignecommandeproduit() {
	
	}
	
	public Lignecommandeproduit( String nomProduit,int quantity, float price,float total) {
		super();
		
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		
	}
	
	
	

	

	public Lignecommandeproduit(LocalDate date, float montant) {
		this.date = date;
		this.montant = montant;
	}
	
	public Lignecommandeproduit( LocalDate date,String nomProduit,int quantity, float price,float total,String name,float montant) {
		super();
		this.date = date;
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.name=name;
		this. montant = montant;
		
	}
	
	/*public Lignecommandeproduit(long id,long idp,String nomProduit, int quantity, float price, float total, float montant) {
		super();
		this.id = id;
		this.idp = idp;
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.montant = montant;
	}*/
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	public Lignecommandeproduit( int quantity,String nomProduit) {
		super();
		this.quantity = quantity;
		this.nomProduit = nomProduit;
		
	}

	public long getIdp() {
		return idp;
	}

	public void setIdp(long idp) {
		this.idp = idp;
	}

	public Lignecommandeproduit(long id, long idp, String nomProduit, int quantity, float price, float total,
			String name, LocalDate date, float montant, boolean remiseFidelite, int porcentagederemise,
			int nb_pointFidelite) {
		super();
		this.id = id;
		this.idp = idp;
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.name = name;
		this.date = date;
		this.montant = montant;
		this.remiseFidelite = remiseFidelite;
		this.porcentagederemise = porcentagederemise;
		this.nb_pointFidelite = nb_pointFidelite;
	}
	
}
