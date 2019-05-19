package com.prs.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.prs.business.PurchaseRequestLineItem;

public class PurchaseRequestLineItemDB {
	
	public static List<PurchaseRequestLineItem> getAll() {
		List<PurchaseRequestLineItem> purchaseRequestLineItems = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			Query q = em.createQuery("Select prli from PurchaseRequestLineItem prli");
			purchaseRequestLineItems = q.getResultList();			
		}
		finally {
			em.close();
		}
		
		return purchaseRequestLineItems;
	}

}
