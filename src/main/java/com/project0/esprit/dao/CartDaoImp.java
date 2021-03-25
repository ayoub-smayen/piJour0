package com.project0.esprit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project0.esprit.model.*;

@Repository
public class CartDaoImp implements CartDao {

	
	private SessionFactory sessionFactory;

	@Override
	public Cart findBy(Long idCart) {
		String queryString = "FROM Cart WHERE idCart = :idCart";
		return (Cart) sessionFactory.getCurrentSession()
								.createQuery(queryString)
								.setParameter("idCart", idCart)
								.uniqueResult();
	}

	@Override
	public Long save(Cart cart) {
		return (Long) sessionFactory.getCurrentSession().save(cart);
	}

	@Override
	public void update(Cart cart) {
		sessionFactory.getCurrentSession().update(cart);
	}
}
