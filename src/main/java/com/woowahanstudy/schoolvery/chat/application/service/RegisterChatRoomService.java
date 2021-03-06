package com.woowahanstudy.schoolvery.chat.application.service;

import com.woowahanstudy.schoolvery.chat.application.port.in.RegisterChatRoomServicePort;
import com.woowahanstudy.schoolvery.chat.application.port.out.RegisterChatRoomPort;
import com.woowahanstudy.schoolvery.chat.application.port.in.converter.RegisterChatRoomRequestDtoConverter;
import com.woowahanstudy.schoolvery.chat.application.port.in.dto.RegisterChatRoomRequestDto;
import com.woowahanstudy.schoolvery.chat.domain.ChatRoom;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class RegisterChatRoomService implements RegisterChatRoomServicePort {

    private final RegisterChatRoomPort registerChatRoomPort;

    @Override
    public Long addChatRoom(RegisterChatRoomRequestDto registerChatRoomRequestDto) {

        final ChatRoom chatRoom = RegisterChatRoomRequestDtoConverter
            .INSTANCE.registerChatRoomRequestDtoToChatRoom(registerChatRoomRequestDto);
        Long chatRoomId = registerChatRoomPort.add(chatRoom);
        return chatRoomId;
    }
}
