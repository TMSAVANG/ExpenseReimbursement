package com.revature.repository;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateSessionFactory;
import java.util.List;

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
	
	public void submitReimbursement(int employee_id, double amount, String reason)
	{
		Session s = null;
		Transaction tx = null;

		
		try
		{
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			NativeQuery<Reimbursement> nq = s.createNativeQuery("INSERT INTO reimbursements (employee_id, amount, reason, approval) "
					+ "VALUES (?, ?, ?, ?)");
			nq.setParameter(1, employee_id);
			nq.setParameter(2, amount);
			nq.setParameter(3, reason);
			nq.setParameter(4, 0);
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
