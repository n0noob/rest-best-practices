package com.learn.restbestpractices.repositories;

import com.learn.restbestpractices.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
