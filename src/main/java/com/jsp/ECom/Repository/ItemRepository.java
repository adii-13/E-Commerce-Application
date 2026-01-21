package com.jsp.ECom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ECom.Entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}