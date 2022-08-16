package com.matching.kb40.chatting.kafkaserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.matching.kb40.chatting.kafkaserver.dao.ChattingDao;
import com.matching.kb40.chatting.kafkaserver.dto.ChatDto;
import com.matching.kb40.chatting.kafkaserver.model.NewChat;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatReq;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatRes;
import com.matching.kb40.chatting.kafkaserver.model.ReadChat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChattingServiceImpl implements ChattingService{

    @Autowired
	private ChattingDao chattingDao;

    @KafkaListener(topics = "${param.kafka.topic.total.insert}")
	@Transactional
	@Override
	public void  receiveChat(String message, Acknowledgment ack) {
		Gson gson = new Gson();
		try {
			log.info("from message:{}", message);
			NewChat newChat = gson.fromJson(message, NewChat.class);
			log.info("chat obj from kafka:{}", newChat.toString());

			ChatDto chatDto = new ChatDto();
			chatDto.setMatchId(newChat.getMatchId());
			chatDto.setUserId(newChat.getUserId());
			chatDto.setContent(newChat.getContent());
			chatDto.setCreatedDate(newChat.getCreatedDate());
			chatDto.setReadFlag("N");
			int rowCount = chattingDao.insertChat(chatDto);

			log.info("update account row count:{}", rowCount);
			ack.acknowledge();

		} catch(Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}
    

	@KafkaListener(topics = "${param.kafka.topic.total.update}")
	@Transactional
	@Override
	public void  updateChat(String message, Acknowledgment ack) {
		Gson gson = new Gson();
		try {
			log.info("from message:{}", message);
			ReadChat readChat = gson.fromJson(message, ReadChat.class);
			log.info("chat obj from kafka:{}", readChat);

			int rowCount = chattingDao.updateChat(readChat);

			log.info("update account row count:{}", rowCount);
			ack.acknowledge();

		} catch(Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<PrevChatRes> findPrevChat(PrevChatReq prevChatReq) throws Exception {
		return chattingDao.findPrevChat(prevChatReq);
	}
}
