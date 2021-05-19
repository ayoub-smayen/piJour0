package com.project0.esprit.util.generators;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project0.esprit.entity.Facture;
import com.project0.esprit.entity.Lignecommandeproduit;

import java.util.Date;
import java.util.List;


 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class GeneratePdfReport {

    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

    public static ByteArrayInputStream citiesReport(List<Lignecommandeproduit> l_CommandeP,Facture f)  {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
        	
        	PdfWriter.getInstance(document, out);
            document.open();
           
			///////////////////////////////////////////////////////////////////////////////////////////////
			 Font font = FontFactory.getFont("Cooper Black", 15, BaseColor.BLUE);
			 LocalDate aujourdhui = f.getDate();
			 document.add(new Paragraph("Destinataire :   "));
			 SimpleDateFormat formater = null;
			 formater = new SimpleDateFormat("dd-MM-yy");
			 Paragraph nomClient=new Paragraph(" "+f.getCommande().getIdUser().getUsername()+" "+f.getCommande().getIdUser().getLprofile().getTel(),font);
			 document.add(nomClient);
			 Paragraph adresse=new Paragraph("Adresse : "+f.getCommande().getIdUser().getLprofile().getAdreese()+"                                                               Date de facturation : "+f.getDate());
			 document.add(adresse);
			 document.add(new Paragraph("Code Postal : 8080                                                                                Echéance : "+f.getCommande().getDate()));
			 Font mainFont = FontFactory.getFont("Cooper Black",35, BaseColor.BLACK);
			 Paragraph parag=new Paragraph("FACTURE N° "+f.getId(),mainFont);
			 parag.setAlignment(Element.ALIGN_CENTER);
			 parag.setIndentationLeft(10);
			 parag.setIndentationRight(10);
			 parag.setSpacingAfter(10);
			 document.add(parag);
			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
			 document.add(new Paragraph(" "));
			 document.add(new Paragraph(" "));
			//////////////////////////////////////////////////////////////////
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(80);
            table.setWidths(new int[]{1, 2, 2 ,1});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Name", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Quantity", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Price", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Total", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
///////////////////////////////////////////////////////////////////
            Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
            Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
            for(Lignecommandeproduit c : l_CommandeP)
        	{
            	 PdfPCell quantiteval = new PdfPCell(new Paragraph(c.getNomProduit(), tableHeader));
         	    quantiteval.setBorderColor(BaseColor.BLACK);
         	    quantiteval.setPaddingLeft(10);
         	    quantiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
         	    quantiteval.setVerticalAlignment(Element.ALIGN_CENTER);
         	    quantiteval.setBackgroundColor(BaseColor.WHITE);
         	    quantiteval.setExtraParagraphSpace(5f);
         	    table.addCell(quantiteval);
         	    PdfPCell produiteval = new PdfPCell(new Paragraph(String.valueOf(c.getQuantity()), tableHeader));
         	    produiteval.setBorderColor(BaseColor.BLACK);
         	    produiteval.setPaddingLeft(10);
         	    produiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
         	    produiteval.setVerticalAlignment(Element.ALIGN_CENTER);
         	    produiteval.setBackgroundColor(BaseColor.WHITE);
         	    produiteval.setExtraParagraphSpace(5f);
         	    table.addCell(produiteval);
         	    PdfPCell prixval = new PdfPCell(new Paragraph(String.valueOf(c.getPrice()), tableHeader));
         	    prixval.setBorderColor(BaseColor.BLACK);
         	    prixval.setPaddingLeft(10);
         	    prixval.setHorizontalAlignment(Element.ALIGN_CENTER);
         	    prixval.setVerticalAlignment(Element.ALIGN_CENTER);
         	    prixval.setBackgroundColor(BaseColor.WHITE);
         	    prixval.setExtraParagraphSpace(5f);
         	    table.addCell(prixval);
         	    PdfPCell Totaleval = new PdfPCell(new Paragraph(String.valueOf(c.getTotal()), tableHeader));
         	    Totaleval.setBorderColor(BaseColor.BLACK);
         	    Totaleval.setPaddingLeft(10);
         	    Totaleval.setHorizontalAlignment(Element.ALIGN_CENTER);
         	    Totaleval.setVerticalAlignment(Element.ALIGN_CENTER);
         	    Totaleval.setBackgroundColor(BaseColor.WHITE);
         	    Totaleval.setExtraParagraphSpace(5f);
         	    table.addCell(Totaleval);
        	}

            ///////////////////////////////////////////////////////////
            PdfPTable table2 = new PdfPTable(3);
            PdfPCell PrixTotale = new PdfPCell(new Paragraph("Prix_Totale", tableHeader));
            PrixTotale.setBorderColor(BaseColor.BLACK);
            PrixTotale.setPaddingLeft(10);
            PrixTotale.setHorizontalAlignment(Element.ALIGN_CENTER);
            PrixTotale.setVerticalAlignment(Element.ALIGN_CENTER);
            PrixTotale.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PrixTotale.setExtraParagraphSpace(5f);
            table2.addCell(PrixTotale);
            PdfPCell Pourcentage = new PdfPCell(new Paragraph("Reduction", tableHeader));
            Pourcentage.setBorderColor(BaseColor.BLACK);
            Pourcentage.setPaddingLeft(10);
            Pourcentage.setHorizontalAlignment(Element.ALIGN_CENTER);
            Pourcentage.setVerticalAlignment(Element.ALIGN_CENTER);
            Pourcentage.setBackgroundColor(BaseColor.LIGHT_GRAY);
            Pourcentage.setExtraParagraphSpace(5f);
            table2.addCell(Pourcentage);
            PdfPCell Prixfinal = new PdfPCell(new Paragraph("Prix_finale", tableHeader));
            Prixfinal.setBorderColor(BaseColor.BLACK);
            Prixfinal.setPaddingLeft(10);
            Prixfinal.setHorizontalAlignment(Element.ALIGN_CENTER);
            Prixfinal.setVerticalAlignment(Element.ALIGN_CENTER);
            Prixfinal.setBackgroundColor(BaseColor.LIGHT_GRAY);
            Prixfinal.setExtraParagraphSpace(5f);
            table2.addCell(Prixfinal);
            PdfPCell prix_totalval = new PdfPCell(new Paragraph(String.valueOf(f.getCommande().getMontant()), tableHeader));
            prix_totalval.setBorderColor(BaseColor.BLACK);
            prix_totalval.setPaddingLeft(10);
            prix_totalval.setHorizontalAlignment(Element.ALIGN_CENTER);
            prix_totalval.setVerticalAlignment(Element.ALIGN_CENTER);
            prix_totalval.setBackgroundColor(BaseColor.WHITE);
            prix_totalval.setExtraParagraphSpace(5f);
        	    table2.addCell(prix_totalval);
        	   PdfPCell Pourcentageval = new PdfPCell(new Paragraph(String.valueOf(f.getCommande().getPourcentageDeRemise()), tableHeader));
        	  Pourcentageval.setBorderColor(BaseColor.BLACK);
        	 Pourcentageval.setPaddingLeft(10);
        	Pourcentageval.setHorizontalAlignment(Element.ALIGN_CENTER);
        	Pourcentageval.setVerticalAlignment(Element.ALIGN_CENTER);
        	Pourcentageval.setBackgroundColor(BaseColor.WHITE);
        	Pourcentageval.setExtraParagraphSpace(5f);
            table2.addCell(Pourcentageval);
            double prixfn = f.getCommande().getMontant()-((f.getCommande().getPourcentageDeRemise()/100)*f.getCommande().getMontant());
            PdfPCell prix_finalval = new PdfPCell(new Paragraph(String.valueOf(prixfn)));
            prix_finalval.setBorderColor(BaseColor.BLACK);
            prix_finalval.setPaddingLeft(10);
            prix_finalval.setHorizontalAlignment(Element.ALIGN_CENTER);
            prix_finalval.setVerticalAlignment(Element.ALIGN_CENTER);
            prix_finalval.setBackgroundColor(BaseColor.WHITE);
            prix_finalval.setExtraParagraphSpace(5f);
        	    table2.addCell(prix_finalval);
            
        	    
        	    document.add(table);
                document.add(table2);
            ////////////////////////////////////////////////////////////////////////////////////////////////////
            
        	    document.add(new Paragraph("  "));
        	    document.add(new Paragraph("  "));
        		 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
        		 document.add(new Paragraph("  "));
        		 document.add(new Paragraph("  "));
        		 document.add(new Paragraph("Telephone  :(+216) 72 755 885   "+"                                                             Adresse : Ariana Soghra /Tunis "));
        		 document.add(new Paragraph("Fax          :(+216) 72 063 906   "+"                                                               Code Postal :2081  ")); 
        		 document.add(new Paragraph("Email       :ConsommiToounsi.619@gmail.com  "));
        	    
          

           
            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}
