package cml.theaters.moviereservation.service.member;

import cml.theaters.moviereservation.domain.member.Member;
import cml.theaters.moviereservation.domain.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberServiceTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void member_save_test() {
        String name = "membertest";
        String email = "membertest@membertest.com";
        String password = "membertest";
        String telNumber = "000-0000-0000";

        Member member = Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .telNumber(telNumber)
                .build();


        Member savedMember = memberRepository.save(member);

        Assertions.assertEquals(savedMember.getName(), "membertest");
        Assertions.assertEquals(savedMember.getEmail(), "membertest@membertest.com");
    }
}
