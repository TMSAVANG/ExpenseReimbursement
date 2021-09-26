package com.revature.repository;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateSessionFactory;

import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;


public class ReimbursementRepository 
{
	List<Reimbursement> reimbursements = null;

	public List<Reimbursement> findAll()
	{
		Session s = null;
		Transaction tx = null;
		
		try
		{
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			reimbursements = s.createQuery("FROM Reimbursement", Reimbursement.class).getResultList();
		}
		
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			s.close();
		}
		
		return reimbursements;
	}
	
	public void updateApproval(int reference_num, int approval_state)
	{
		Session s = null;
		Transaction tx = null;

		
		try
		{
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			NativeQuery<Reimbursement> nq = s.createNativeQuery("UPDATE reimbursements SET approval = ? WHERE reference_num = ?");
			nq.setParameter(1, approval_state);
			nq.setParameter(2, reference_num);
			nq.uniqueResult();
			
		}
		
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			s.close();
		}
	}
}
