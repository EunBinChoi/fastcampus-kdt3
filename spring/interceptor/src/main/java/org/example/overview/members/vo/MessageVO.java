package org.example.overview.members.vo;


import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Builder
@Getter
public class MessageVO {
    private String INDEX_MESSAGE;

    private String INDEX_MESSAGE_WITH_USERID;

    private String INDEX_TIME;
    private String INDEX_MENU_HOME;
    private String INDEX_MENU_SEARCH;
    private String INDEX_MENU_SURVEY;
    private String PRIVATE_MENU_UPDATE;
    private String PRIVATE_MENU_WITHDRAW;
    private String PRIVATE_MENU_COOKIE;

    public MessageVO() {
    }

    public MessageVO(String INDEX_MESSAGE, String INDEX_MESSAGE_WITH_USERID, String INDEX_TIME, String INDEX_MENU_HOME, String INDEX_MENU_SEARCH, String INDEX_MENU_SURVEY, String PRIVATE_MENU_UPDATE, String PRIVATE_MENU_WITHDRAW, String PRIVATE_MENU_COOKIE) {
        this.INDEX_MESSAGE = INDEX_MESSAGE;
        this.INDEX_MESSAGE_WITH_USERID = INDEX_MESSAGE_WITH_USERID;
        this.INDEX_TIME = INDEX_TIME;
        this.INDEX_MENU_HOME = INDEX_MENU_HOME;
        this.INDEX_MENU_SEARCH = INDEX_MENU_SEARCH;
        this.INDEX_MENU_SURVEY = INDEX_MENU_SURVEY;
        this.PRIVATE_MENU_UPDATE = PRIVATE_MENU_UPDATE;
        this.PRIVATE_MENU_WITHDRAW = PRIVATE_MENU_WITHDRAW;
        this.PRIVATE_MENU_COOKIE = PRIVATE_MENU_COOKIE;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageVO messageVO = (MessageVO) o;
        return Objects.equals(INDEX_MESSAGE, messageVO.INDEX_MESSAGE) && Objects.equals(INDEX_MESSAGE_WITH_USERID, messageVO.INDEX_MESSAGE_WITH_USERID) && Objects.equals(INDEX_TIME, messageVO.INDEX_TIME) && Objects.equals(INDEX_MENU_HOME, messageVO.INDEX_MENU_HOME) && Objects.equals(INDEX_MENU_SEARCH, messageVO.INDEX_MENU_SEARCH) && Objects.equals(INDEX_MENU_SURVEY, messageVO.INDEX_MENU_SURVEY) && Objects.equals(PRIVATE_MENU_UPDATE, messageVO.PRIVATE_MENU_UPDATE) && Objects.equals(PRIVATE_MENU_WITHDRAW, messageVO.PRIVATE_MENU_WITHDRAW) && Objects.equals(PRIVATE_MENU_COOKIE, messageVO.PRIVATE_MENU_COOKIE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(INDEX_MESSAGE, INDEX_MESSAGE_WITH_USERID, INDEX_TIME, INDEX_MENU_HOME, INDEX_MENU_SEARCH, INDEX_MENU_SURVEY, PRIVATE_MENU_UPDATE, PRIVATE_MENU_WITHDRAW, PRIVATE_MENU_COOKIE);
    }

    @Override
    public String toString() {
        return "MessageVO{" +
                "INDEX_MESSAGE='" + INDEX_MESSAGE + '\'' +
                ", INDEX_MESSAGE_WITH_USERID='" + INDEX_MESSAGE_WITH_USERID + '\'' +
                ", INDEX_TIME='" + INDEX_TIME + '\'' +
                ", INDEX_MENU_HOME='" + INDEX_MENU_HOME + '\'' +
                ", INDEX_MENU_SEARCH='" + INDEX_MENU_SEARCH + '\'' +
                ", INDEX_MENU_SURVEY='" + INDEX_MENU_SURVEY + '\'' +
                ", PRIVATE_MENU_UPDATE='" + PRIVATE_MENU_UPDATE + '\'' +
                ", PRIVATE_MENU_WITHDRAW='" + PRIVATE_MENU_WITHDRAW + '\'' +
                ", PRIVATE_MENU_COOKIE='" + PRIVATE_MENU_COOKIE + '\'' +
                '}';
    }
}

