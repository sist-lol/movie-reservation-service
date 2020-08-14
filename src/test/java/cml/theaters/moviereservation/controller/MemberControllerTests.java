package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.domain.member.Member;
import cml.theaters.moviereservation.dto.MemberListResponseDto;
import cml.theaters.moviereservation.service.member.MemberService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@ActiveProfiles("test")
@WebMvcTest(MemberController.class)
public class MemberControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void findAll_test() throws Exception {
        Member member = Member.builder().name("testmember").build();
        MemberListResponseDto dto = new MemberListResponseDto(member);
        List<MemberListResponseDto> memberList = Arrays.asList(dto);

        BDDMockito.given(memberService.findAll()).willReturn(memberList);

        mockMvc.perform(MockMvcRequestBuilders.get("/member"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(member.getName())))
                .andDo(MockMvcResultHandlers.print());
    }
}
