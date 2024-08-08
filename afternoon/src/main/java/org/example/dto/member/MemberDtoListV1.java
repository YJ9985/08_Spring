package org.example.dto.member;

import java.util.ArrayList;
import java.util.List;

public class MemberDtoListV1 {
    private static MemberDtoListV1 instance;
    private List<org.example.dto.member.MemberDto> memberDtoList;

    private MemberDtoListV1() {
        this.memberDtoList = new ArrayList<>();
        this.addList("tetz", "이효석");
        this.addList("siwan", "김시완");
    }

    public static synchronized MemberDtoListV1 getInstance() {
        if (instance == null) {
            instance = new MemberDtoListV1();
        }

        return instance;
    }

    public void addList(String id, String name) {
        memberDtoList.add(new org.example.dto.member.MemberDto(id, name));
    }

    public List<MemberDto> getList() {
        return memberDtoList;
    }
}
