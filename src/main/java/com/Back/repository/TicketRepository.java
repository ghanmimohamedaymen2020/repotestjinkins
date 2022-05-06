package com.Back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Back.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
