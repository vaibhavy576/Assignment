package com.benz.consumer.request.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.benz.consumer.request.model.FileDataDTO;
import com.benz.consumer.request.service.ConsumerRequestService;

@Service
public class ConsumerRequestServiceImpl  implements ConsumerRequestService {
	@Autowired
	private javax.jms.Queue queue;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void saveData(String jsonObj, String fileType) {
		FileDataDTO fileDTO= new FileDataDTO();
		fileDTO.setFileType(fileType);
		fileDTO.setJson(jsonObj);
		jmsTemplate.convertAndSend(queue, fileDTO);
	}
}
