package com.Back.controllere;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Back.exception.ResourceNotFoundException;
import com.Back.model.Ticket;
import com.Back.model.User;
import com.Back.repository.TicketRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/V1")
public class TicketController {
	
	
		
		@Autowired
		private TicketRepository ticketRepository ;
		
		@GetMapping("/tickets")
		public  List<Ticket> getAllUser(){
			 System.out.print( ticketRepository.findAll());
			return ticketRepository.findAll();
			
		}
		
		@CrossOrigin(origins = "http://localhost:4200")
		//@PostMapping("/tickets")
		@RequestMapping(value = "/tickets" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
		@ResponseStatus(HttpStatus.OK)
		public Ticket createTicket(@RequestBody Ticket ticket) {
			
			return ticketRepository.save(ticket);
		}
		
		/*
		  @PutMapping("/user/{id}") public ResponseEntity<User>
		  updateUser(@PathVariable int id,@RequestBody User userDetaits){ User user =
		  userRepository.findById(id) .orElseThrow(()->new
		  ResourceNotFoundException("user with this id is not found please enter valid id "
		  )); if (userDetaits.getFirstName() !=null ){
		  user.setFirstName(userDetaits.getFirstName());} if
		  (userDetaits.getLastName()!=null ){
		  user.setLastName(userDetaits.getLastName());} if
		  (userDetaits.getMatrecule()!=null ){
		  user.setMatrecule(userDetaits.getMatrecule());} if
		  (userDetaits.getEmails()!=null ){ user.setEmails(userDetaits.getEmails());}
		  if (userDetaits.getCompany()!=null ){
		  user.setCompany(userDetaits.getCompany());}
		  
		  User updateUser = userRepository.save(user);
		  
		  return ResponseEntity.ok(updateUser) ; }
		 */
		@CrossOrigin(origins = "http://localhost:4200")
		@PutMapping("/tickets/{id}")
	     public ResponseEntity<Ticket> updateTicket(@PathVariable Long id ,@RequestBody Ticket ticketDetails,String ticketStatus){
	    	 Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> 
	    	 						new ResourceNotFoundException("the ticket with this user is not found "));
	    	 
	    	 ticketStatus = "in progress"; 
	          if (ticketStatus== "in progress") {
	        	  ticket.setSatuts("in progress");
	        	  ticket.setDateAssign();
	          }
	          
	          if (ticketStatus == "closed") {
	        	  ticket.setSatuts("closed");
	        	  ticket.setDateEndOfAssit();
	          }
	          
	    
	          
	    
	       
	    	 
	    	 Ticket updateTicket = ticketRepository.save(ticket);
	    	
	    	 
	    	 return ResponseEntity.ok(updateTicket) ;
	    	 
	     }
		
	     
		
		/*
		@GetMapping("/tickets/{id}")
		public ResponseEntity<Ticket> getUserById(@PathVariable Long id){
			Ticket ticket = ticketRepository.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("ticket with this id is not found please enter valid id "));
			return ResponseEntity.ok(ticket) ;
		}*/
		
		
		
	
	
	

}
