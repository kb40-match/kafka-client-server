package com.matching.kb40.chatting.kafkaserver.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Alias("ChatDto")
public class ChatDto {
    private Long chatId;           // auto_increment
    private Long matchId;
    private String userId;
    private String content;
    private String readFlag;
    private String createdDate;
}
