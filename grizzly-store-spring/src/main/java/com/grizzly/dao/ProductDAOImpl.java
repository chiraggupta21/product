package com.grizzly.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grizzly.entity.Product;


@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	
	@Override
	public List<Product> listProduct() 
	{
		Session s=sf.getCurrentSession();
		CriteriaBuilder cb=s.getCriteriaBuilder();
		CriteriaQuery<Product> cq=cb.createQuery(Product.class);
		Root<Product> root=cq.from(Product.class);
		cq.select(root);
		Query query =s.createQuery(cq);
		return query.getResultList();		
	}

	@Override
	public void addProduct(Product p) {
		Session currentSession=sf.getCurrentSession();
		currentSession.saveOrUpdate(p);
	}

	@Override
	public void deleteProduct(int id) {
		Session currentSession=sf.getCurrentSession();
		Product p=currentSession.byId(Product.class).load(id);
		currentSession.delete(p);
	}

	@Override
	public Product getProduct(int id) {
		Session currentSession=sf.getCurrentSession();
		Product p=currentSession.get(Product.class, id);
		return p;
	}

}
