package com.ubb.gymapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "rating")
public class Rating implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2266855771818984699L;
	private Long idRating;
	private Double total;
	private Long nrpers;
	
	public Rating() {}
	
	public Rating(Double total, Long nrpers)
	{
		this.total = total;
		this.nrpers = nrpers;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idRating", unique = true, nullable = false)
	public Long getIdRating() {
		return idRating;
	}
	public void setIdRating(Long idRating) {
		this.idRating = idRating;
	}
	
	@Column (name = "total")
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	@Column (name = "nrpers")
	public Long getNrpers() {
		return nrpers;
	}
	public void setNrpers(Long nrpers) {
		this.nrpers = nrpers;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRating == null) ? 0 : idRating.hashCode());
		result = prime * result + ((nrpers == null) ? 0 : nrpers.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		if (idRating == null) {
			if (other.idRating != null)
				return false;
		} else if (!idRating.equals(other.idRating))
			return false;
		if (nrpers == null) {
			if (other.nrpers != null)
				return false;
		} else if (!nrpers.equals(other.nrpers))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	

}
