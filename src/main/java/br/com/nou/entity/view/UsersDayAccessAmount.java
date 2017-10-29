package br.com.nou.entity.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Alisson Cruz
 *
 *@serial 14/10/17
 */

@Entity
@Table(name="vw_user_access_amount")
public class UsersDayAccessAmount implements Serializable{

	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="date")
	private Date lastAccess; 
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = -8673000631348319606L;

}
