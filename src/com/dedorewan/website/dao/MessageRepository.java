package com.dedorewan.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dedorewan.website.dom.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
