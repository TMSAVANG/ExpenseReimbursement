package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity

@Table(name = "reimbursements")
public class Reimbursement 
{
	
	@Id
	@Column(name = "reference_num")
	private int reference_num;
	@Column
	private int employee_id;
	@Column
	private double amount;
	@Column
	private String reason;
	@Column
	private int approval; // 00 not reviewed, 01 under review, 10 rejected, 11 approved. 
	
	public int getReference_num() 
	{
		return reference_num;
	}
	
	public void setReference_num(int reference_num) 
	{
		this.reference_num = reference_num;
	}
	
	public int getEmployee_id() 
	{
		return employee_id;
	}
	
	public void setEmployee_id(int employee_id) 
	{
		this.employee_id = employee_id;
	}
	
	public double getAmount() 
	{
		return amount;
	}
	
	public void setAmount(double amount) 
	{
		this.amount = amount;
	}
	
	public String getReason() 
	{
		return reason;
	}
	
	public void setReason(String reason) 
	{
		this.reason = reason;
	}
	
	public int getApproved()
	{
		return approval;
	}
	
	public void setApproved(int approval) 
	{
		this.approval = approval;
	}

	
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(amount, approval, employee_id, reason, reference_num);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && approval == other.approval
				&& employee_id == other.employee_id && Objects.equals(reason, other.reason)
				&& reference_num == other.reference_num;
	}

	@Override
	public String toString() 
	{
		return "Reimbursement [reference_num = " + reference_num + ", employee_id = " + employee_id + ", amount = " + amount
				+ ", reason = " + reason + ", approved = " + approval + "]";
	}

	public Reimbursement()
	{
		
	}
	
	public Reimbursement(int reference_num, int employee_id, double amount, String reason, int approval) 
	{
		super();
		this.reference_num = reference_num;
		this.employee_id = employee_id;
		this.amount = amount;
		this.reason = reason;
		this.approval = approval;
	}
	
	
	
}
