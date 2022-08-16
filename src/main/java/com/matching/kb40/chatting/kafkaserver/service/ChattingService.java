package com.matching.kb40.chatting.kafkaserver.service;

import java.util.List;

import org.springframework.kafka.support.Acknowledgment;

import com.matching.kb40.chatting.kafkaserver.model.PrevChatReq;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatRes;

public interface ChattingService {

	public void  receiveChat(String message, Acknowledgment ack) throws Exception;

    public void  updateChat(String message, Acknowledgment ack) throws Exception;

    public List<PrevChatRes> findPrevChat(PrevChatReq prevChatReq) throws Exception;

}
