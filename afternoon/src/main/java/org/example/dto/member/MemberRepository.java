package org.example.dto.member;

//import lombok.RequiredArgsConstructor;
import org.example.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@RequiredArgsConstructor
public class MemberRepository {
    private final MemberMapper memberMapper;

    //RequiredArgsConstructor 해주면 없애도 됨
    @Autowired
    public MemberRepository(final MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    public List<MemberDto> findAll(){
        return memberMapper.findAll();
    }
}
