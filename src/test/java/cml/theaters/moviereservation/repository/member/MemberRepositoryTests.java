package cml.theaters.moviereservation.repository.member;

import cml.theaters.moviereservation.domain.member.Member;
import cml.theaters.moviereservation.domain.member.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    public void teardown() {
        memberRepository.deleteAll();
    }

    @Test
    public void member_findAll_test() {
        String name = "savetest";
        String email = "savetest@savetest.com";
        String password = "savetest";
        String telNumber = "000-0000-0001";

        Member member = createMemberEntity(name, email, password, telNumber);

        memberRepository.save(member);

        List<Member> memberList = memberRepository.findAll();
        assertNotNull(memberList);
        assertNotSame(0, memberList.size());

        System.out.println(member.toString());
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

    @Transactional
    @Test
    public void member_update_test() {
        String name = "updatetest_before";
        String email = "updatetest@updatetest.com";
        String password = "updatetest_before";
        String telNumber = "000-0000-0000";

        Member member = createMemberEntity(name, email, password, telNumber);

        System.out.println(member.toString());

        Member savedMember = memberRepository.save(member);

        name = "updatetest_after";
        password = "updatetest_after";
        telNumber = "999-9999-9999";

        savedMember.setName(name);
        savedMember.setPassword(password);
        savedMember.setTelNumber(telNumber);

        memberRepository.save(savedMember);

        Member updatedMember = memberRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException());

        System.out.println(updatedMember.toString());

        assertEquals(updatedMember.getName(), name);
        assertEquals(updatedMember.getPassword(), password);
        assertEquals(updatedMember.getTelNumber(), telNumber);

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

    private Member createMemberEntity(String name, String email, String password, String telNumber) {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .telNumber(telNumber)
                .build();
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
