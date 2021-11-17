package ca.sheridancollege.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Adhrika Pai - 991451940

@NamedQuery(name = "Restaurant.byAll", query = "from Restaurant")
@NamedQuery(name = "Restaurant.byRestPrice", query = "from Restaurant WHERE restPrice LIKE :restPrice")
@NamedQuery(name = "Restaurant.byRestNote", query = "from Restaurant WHERE restNote LIKE  concat('%',:restNote,'%')")
@NamedQuery(name="Restaurant.byRestRate", query = "from Restaurant ORDER by restRate desc")
@NamedQuery(name = "Restaurant.byRestName", query = "from Restaurant WHERE restName LIKE :restName")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue
	private int restId;
	
	private String restName;
	private String restType;
	private String restNote;
	private String restPrice;
	private String restRate;
	
	public Restaurant(String restName, String restType, String restNote, String restPrice, String restRate) {
		super();
		this.restName = restName;
		this.restType = restType;
		this.restNote = restNote;
		this.restPrice = restPrice;
		this.restRate = restRate;
	}
	
	
	
}
