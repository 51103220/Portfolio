package com.dedorewan.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dedorewan.website.aspect.NotifyClients;
import com.dedorewan.website.dom.Mess;
import com.dedorewan.website.service.IMessageService;

@Controller
public class ProjectController {
	@Autowired
	private IMessageService messageService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home() {
		return "portfolio";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/messages")
	@ResponseBody
	public List<Mess> getMessages() {
		return messageService.getMessages();
	}

	@NotifyClients
	@RequestMapping(method = RequestMethod.PUT, value = "/messages/{id}")
	@ResponseBody
	public Mess update(@RequestBody Mess mess) {
		return messageService.editMessage(mess);
	}

	@NotifyClients
	@RequestMapping(method = RequestMethod.POST, value = "/messages")
	@ResponseBody
	public Mess add(@RequestBody Mess mess) {
		return messageService.addMessage(mess);
	}

	@NotifyClients
	@RequestMapping(method = RequestMethod.DELETE, value = "/messages/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Mess mess) {
		messageService.deleteMessage(mess);
	}
}
