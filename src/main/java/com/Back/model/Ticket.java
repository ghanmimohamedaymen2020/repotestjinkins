package com.Back.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import com.sun.istack.Nullable;



@Entity
@Table(name="Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id  ;
	@Nullable
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	Long ReclamationNumber;
   	String eamil ;
   	String name;
   	String detectedBy ;
   	
   	String Client ;
   	
	String satuts = "open" ;
    String Commentaires ;
    String ActionImmediate ;
    String ActionAmlioration ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    Date dateCreatinTicket ;
    
    @Temporal(TemporalType.TIMESTAMP)
    Date dateAssign ;
    @Temporal(TemporalType.TIMESTAMP)
    Date dateEndOfAssit ;
   	
   	
  /*  public Ticket(Long id, Long ticketNumber, String eamil, String name, String satuts, String description, String note,
			Date dateCreatinTicket, Date dateAssign, Date dateEndOfAssit) {
		super();
		this.id = id;
		this.ReclamationNumber = ticketNumber;
		this.eamil = eamil;
		this.name = name;
		this.satuts = satuts ;
		this.Commentaires = description;
		this.ActionImmediate = note;
		this.dateCreatinTicket = dateCreatinTicket;
		this.dateAssign = dateAssign;
		this.dateEndOfAssit = dateEndOfAssit;
	}*/






	public Ticket(Long id, Long reclamationNumber, String eamil, String name, String detectedBy, String client,
			String satuts, String commentaires, String actionImmediate, String actionAmlioration,
			Date dateCreatinTicket, Date dateAssign, Date dateEndOfAssit) {
		super();
		this.id = id;
		this.ReclamationNumber = reclamationNumber;
		this.eamil = eamil;
		this.name = name;
		this.detectedBy = detectedBy;
		this.Client = client;
		this.satuts = satuts;
		this.Commentaires = commentaires;
		this.ActionImmediate = actionImmediate;
		this.ActionAmlioration = actionAmlioration;
		this.dateCreatinTicket = dateCreatinTicket;
		this.dateAssign = dateAssign;
		this.dateEndOfAssit = dateEndOfAssit;
	}






	public Long getReclamationNumber() {
		return ReclamationNumber;
	}






	public void setReclamationNumber(Long reclamationNumber) {
		ReclamationNumber = reclamationNumber;
	}






	public String getDetectedBy() {
		return detectedBy;
	}






	public void setDetectedBy(String detectedBy) {
		this.detectedBy = detectedBy;
	}






	public String getClient() {
		return Client;
	}






	public void setClient(String client) {
		Client = client;
	}






	public String getCommentaires() {
		return Commentaires;
	}






	public void setCommentaires(String commentaires) {
		Commentaires = commentaires;
	}






	public String getActionImmediate() {
		return ActionImmediate;
	}






	public void setActionImmediate(String actionImmediate) {
		ActionImmediate = actionImmediate;
	}






	public String getActionAmlioration() {
		return ActionAmlioration;
	}






	public void setActionAmlioration(String actionAmlioration) {
		ActionAmlioration = actionAmlioration;
	}






	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public Long getTicketNumber() {
		return ReclamationNumber;
	}






	public void setTicketNumber(Long ticketNumber) {
		this.ReclamationNumber = ticketNumber;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public void setDateAssign(Date dateAssign) {
		this.dateAssign = dateAssign;
	}






	public void setDateEndOfAssit(Date dateEndOfAssit) {
		this.dateEndOfAssit = dateEndOfAssit;
	}



    
    @PrePersist
    public void Oncreate() {
    	dateCreatinTicket = new Date();
    }
    
    
    
 
    

    public Ticket() {}
    
    
	public Ticket(Long id, Long ticketNumber, String eamil, String satuts, String description, String note,
			Date dateCreatinTicket, Date dateAssign, Date dateEndOfAssit) {
		super();
		this.id = id;
		this.ReclamationNumber = ticketNumber;
		this.eamil = eamil;
		this.satuts = satuts;
		this.Commentaires = description;
		this.ActionImmediate = note;
		this.dateCreatinTicket = dateCreatinTicket;
		this.dateAssign = dateAssign;
		this.dateEndOfAssit = dateEndOfAssit;
	}





	public String getEamil() {
		return eamil;
	}



	public void setEamil(String eamil) {
		this.eamil = eamil;
	}



	public String getSatuts() {
		return satuts;
	}



	public void setSatuts(String satuts) {
		this.satuts = satuts;
	}



	public String getDescription() {
		return Commentaires;
	}



	public void setDescription(String description) {
		this.Commentaires = description;
	}



	public String getNote() {
		return ActionImmediate;
	}



	public void setNote(String note) {
		this.ActionImmediate = note;
	}



	public Date getDateCreatinTicket() {
		return dateCreatinTicket;
	}



	public void setDateCreatinTicket(Date dateCreatinTicket) {
		this.dateCreatinTicket = new Date();
	}



	public Date getDateAssign() {
		return dateAssign;
	}



	public void setDateAssign() {
		this.dateAssign = new Date();
	}



	public Date getDateEndOfAssit() {
		return dateEndOfAssit;
	}



	public void setDateEndOfAssit() {
		this.dateEndOfAssit = new Date() ;
	}
    
	
	
	
    
    
    
    

	
}
