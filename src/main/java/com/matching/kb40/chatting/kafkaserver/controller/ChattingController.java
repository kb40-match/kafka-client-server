package com.matching.kb40.chatting.kafkaserver.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matching.kb40.chatting.kafkaserver.model.PrevChatReq;
import com.matching.kb40.chatting.kafkaserver.model.PrevChatRes;
import com.matching.kb40.chatting.kafkaserver.service.ChattingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/chatting")
public class ChattingController {

    @Autowired
	private ChattingService chattingService;
   
    @GetMapping("/{matchId}/{startRow}/{rowNum}")
	public List<PrevChatRes> findPrevChat(@PathVariable String matchId, @PathVariable String startRow, @PathVariable String rowNum) throws Exception {
        log.info("Controller START!!");
        log.debug("Request: ");
        PrevChatReq prevChatReq = new PrevChatReq();
        prevChatReq.setMatchId(Long.parseLong(matchId));
        prevChatReq.setStartRow(Integer.parseInt(startRow));
        prevChatReq.setRowNum(Integer.parseInt(rowNum));
		return chattingService.findPrevChat(prevChatReq);
	}
}
