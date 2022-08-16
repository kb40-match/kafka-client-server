package com.matching.kb40.chatting.kafkaserver.model;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Alias("PrevChatReq")
public class PrevChatReq {
    private long matchId;
    private int startRow;
    private int rowNum;
}
