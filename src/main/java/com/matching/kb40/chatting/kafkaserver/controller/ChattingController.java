package com.matching.kb40.chatting.kafkaserver.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matching.kb40.chatting.kafkaserver.model.NewChatFlagReq;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatReq;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatRes;
import com.matching.kb40.chatting.kafkaserver.service.ChattingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/chatting")
public class ChattingController {

    @Autowired
	private ChattingService chattingService;
   
    @GetMapping("/{matchId}/{startRow}/{rowNum}")
	public List<PrevChatRes> findPrevChat(@PathVariable String matchId, @PathVariable String startRow, @PathVariable String rowNum) throws Exception {
        log.debug("Request: matchId=" + matchId +", startRow=" + startRow + ", rowNum=" + rowNum);
        PrevChatReq prevChatReq = new PrevChatReq();
        prevChatReq.setMatchId(Long.parseLong(matchId));
        prevChatReq.setStartRow(Integer.parseInt(startRow));
        prevChatReq.setRowNum(Integer.parseInt(rowNum));
        List<PrevChatRes> prevChatReslist = new ArrayList<PrevChatRes>();
        log.debug("Reponse: " + prevChatReslist.toString());
		return prevChatReslist;
	}

    @GetMapping("/{matchId}/{userId}")
	public String findNewChat(@PathVariable String matchId, @PathVariable String userId) throws Exception {
        log.debug("Request: matchId=" + matchId +", userId=" + userId);
        NewChatFlagReq newChatFlagReq = new NewChatFlagReq();
        newChatFlagReq.setMatchId(Long.parseLong(matchId));
        newChatFlagReq.setUserId(userId);
        String newChatYN = chattingService.findNewChat(newChatFlagReq);
        log.debug("Reponse: " + newChatYN);
		return newChatYN;
	}

}
