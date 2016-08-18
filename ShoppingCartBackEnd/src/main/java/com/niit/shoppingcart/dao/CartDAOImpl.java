package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(Cart cart)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}
	
	@Transactional
	public String delete(String id)
	{
		Cart CartToDelete=new Cart();
		CartToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CartToDelete);
		return null;
	}
	
	@Transactional
	public Cart get(String id)
	{
		String hql = "from Cart where userID=" + "'" + id + "'  and status = " + "'N'";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
        List<Cart> listCart = (List<Cart>) query.list();

		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}

		return null;
	}
	
	@Transactional
	public List<Cart> listCart() {
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	public int getTotal(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
