package com.dedorewan.website.service;

import java.util.List;

import com.dedorewan.website.dom.Mess;

public interface IMessageService {
	List<Mess> getMessages();
	Mess addMessage(Mess mess);
	Mess editMessage(Mess mess);
	void deleteMessage(Mess mess);
}
