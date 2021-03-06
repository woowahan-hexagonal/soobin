package com.woowahanstudy.schoolvery.board.adapter.out.persistence;

import com.woowahanstudy.schoolvery.common.BaseEntity;
import com.woowahanstudy.schoolvery.board.domain.BoardCategory;
import com.woowahanstudy.schoolvery.board.domain.BoardStatus;
import com.woowahanstudy.schoolvery.chat.adapter.out.persistence.ChatRoomEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class BoardEntity extends BaseEntity {

    @Column
    private String title;

    @Enumerated(EnumType.STRING)
    private BoardCategory boardCategory;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus = BoardStatus.OPEN;
}
