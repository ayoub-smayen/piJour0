package com.project0.esprit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Stock;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.StockRepository;

@Service
public class StockServiceImpl implements StockServiceImp {
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public Long addStock(Stock s) {
		stockRepository.save(s);
		return s.getId();
	}

	@Override
	public void deleteStock(Long i) {
		stockRepository.deleteById(i);

	}

	@Override
	public Stock updateStock(Stock s) {
		stockRepository.save(s);
		return s ;
	}

	@Override
	public List<Stock> getAllStocks() {
		sendEmail();

		List<Stock> Stocks = (List<Stock>) stockRepository.findAll();	
		return Stocks;
	}

	@Override
	public List<Long> missingProduct() {

		Long  l1 = (long) 1.0;
		
		 List<Long>  l = new ArrayList<>();
		 
		 l.add(l1);
		return l;
		/*List<Long> products = (List<Long>) stockRepository.missingProduct();	

		return products;*/
	}


	public void orderProduct(long pid,int amount)
	{
		Product1 p = productRepository.findById(pid).get();

		p.getStock().setAmount(amount+p.getStock().getAmount());
		productRepository.save(p);
	}


	public void sendEmail() {
		/*try
		{
			String ch="";
			List <Product1> prods=new ArrayList<Product1>();
			List<Long> products =  (List<Long>) stockRepository.missingProduct();
			//Product p = productRepository.findById(products).get();
			System.out.println(products.size());
			for (int i = 0; i < products.size(); i++) {
				System.out.println(products.get(i));
				long p= products.get(i);
				Product1 product =productRepository.findById(p).get();

				prods.add(product);

			}

			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo("souelmiaa@gmail.com", "ameni.souelmia@esprit.tn");

			msg.setSubject("Missing Product");

			for(int i=0; i<prods.size(); i++)
			{  ch =ch + " Description :  "+prods.get(i).getProductdescription() +" \n Name :  "+prods.get(i).getProductname()+ "\n amount : "+prods.get(i).getStock().getAmount()+ " \n / \n  " ;
			System.out.println(prods.get(i));
			}
			msg.setText(ch);
			System.out.println(ch);

			javaMailSender.send(msg);

		}
		catch(Exception e) {

			System.out.println("erreur"+e);
		}
*/
	}



}
