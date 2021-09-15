package com.benz.consumer.request.service;

import org.springframework.stereotype.Service;

@Service
public interface ConsumerRequestService {

	public void saveData(String inputJson, String fileType);

}
