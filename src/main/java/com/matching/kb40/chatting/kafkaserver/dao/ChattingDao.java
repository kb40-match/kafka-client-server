package com.matching.kb40.chatting.kafkaserver.dao;

import java.sql.SQLException;
import java.util.List;

import com.matching.kb40.chatting.kafkaserver.dto.ChatDto;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatReq;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatRes;
import com.matching.kb40.chatting.kafkaserver.model.ReadChat;

public interface ChattingDao {

    public int insertChat(ChatDto chatDto) throws SQLException;

    public int updateChat(ReadChat readChat) throws SQLException;

	public List<PrevChatRes> findPrevChat(PrevChatReq prevChatReq) throws SQLException;
}
