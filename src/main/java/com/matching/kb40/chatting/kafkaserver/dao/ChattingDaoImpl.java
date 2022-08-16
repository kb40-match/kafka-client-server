package com.matching.kb40.chatting.kafkaserver.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matching.kb40.chatting.kafkaserver.dto.ChatDto;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatReq;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatRes;
import com.matching.kb40.chatting.kafkaserver.model.ReadChat;

@Repository
public class ChattingDaoImpl implements ChattingDao {
	String nameSpace = "chatting.";

    @Autowired
	SqlSessionTemplate SqlSessionTemplate;

	@Override
	public int insertChat(ChatDto chatDto) throws SQLException{	
		return SqlSessionTemplate.insert(nameSpace.concat("insertChat"),chatDto);
	}

	@Override
	public int updateChat(ReadChat readChat) throws SQLException{
		return SqlSessionTemplate.update(nameSpace.concat("updateChat"),readChat);
	}

	@Override
	public List<PrevChatRes> findPrevChat(PrevChatReq prevChatReq) throws SQLException{ 
		return SqlSessionTemplate.selectList(nameSpace.concat("findPrevChatList"),prevChatReq);
	}
}