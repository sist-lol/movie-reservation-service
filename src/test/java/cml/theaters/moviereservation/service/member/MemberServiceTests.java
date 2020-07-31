package cml.theaters.moviereservation.service.member;

import cml.theaters.moviereservation.domain.member.Member;
import cml.theaters.moviereservation.domain.member.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberServiceTests {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void startUp() {
        String name = "inittest";
        String email = "inittest@inittest.com";
        String password = "inittest";
        String telNumber = "000-0000-0000";

        Map<String, String> memberParams = new HashMap<>();
        memberParams.put("name", name);
        memberParams.put("email", email);
        memberParams.put("password", password);
        memberParams.put("telNumber", telNumber);

        Member member = createMemberEntity(memberParams);
        memberRepository.save(member);
    }

    @AfterEach
    public void teardown() {
        memberRepository.deleteAll();
    }

    @Test
    public void member_findAll_test() {
        List<Member> memberList = memberRepository.findAll();
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());

        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }

    @Test
    public void member_save_test() {
        String name = "savetest";
        String email = "savetest@savetest.com";
        String password = "savetest";
        String telNumber = "000-0000-0001";

        Map<String, String> memberParams = new HashMap<>();
        memberParams.put("name", name);
        memberParams.put("email", email);
        memberParams.put("password", password);
        memberParams.put("telNumber", telNumber);

        Member member = createMemberEntity(memberParams);

        Member savedMember = memberRepository.save(member);

        assertEquals(savedMember.getName(), name);
        assertEquals(savedMember.getEmail(), email);
    }

    @Test
    public void member_delete_test() {
        Map<String, String> memberParams = new HashMap<>();
        memberParams.put("name", "deletetest");
        memberParams.put("email", "deletetest@deletetest.com");
        memberParams.put("password", "deletetest");
        memberParams.put("telNumber", "000-0000-0000");

        Member member = createMemberEntity(memberParams);

        assertDoesNotThrow(() -> memberRepository.delete(member));
    }

    private Member createMemberEntity(Map<String, String> params) {
        return Member.builder()
                .name(params.get("name"))
                .email(params.get("email"))
                .password(params.get("password"))
                .telNumber(params.get("telNumber"))
                .build();
    }
}
