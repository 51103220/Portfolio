package com.dedorewan.website.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dedorewan.website.dao.MessageRepository;
import com.dedorewan.website.dom.Mess;
import com.dedorewan.website.dom.Message;

@Service
@Transactional
public class MessageService implements IMessageService {
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public List<Mess> getMessages() {
		List<Message> list = messageRepository.findAll();
		List<Mess> result = new ArrayList<Mess>();
		for (Message msg : list) {
			result.add(mapper.map(msg, Mess.class));
		}
		return result;
	}

	@Override
	public Mess addMessage(Mess mess) {
		Message msg = mapper.map(mess, Message.class);
		return mapper.map(messageRepository.saveAndFlush(msg), Mess.class);
	}

	@Override
	public Mess editMessage(Mess mess) {
		Message msg = mapper.map(mess, Message.class);
		return mapper.map(messageRepository.saveAndFlush(msg), Mess.class);
	}

	@Override
	public void deleteMessage(Mess mess) {
		Message msg = mapper.map(mess, Message.class);
		messageRepository.delete(msg);
	}

}
