package cml.theaters.moviereservation.service.member;

import cml.theaters.moviereservation.domain.member.Member;
import cml.theaters.moviereservation.domain.member.MemberRepository;
import cml.theaters.moviereservation.dto.MemberListResponseDto;
import cml.theaters.moviereservation.dto.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(MemberSignUpRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getMemberId();
    }

    @Transactional
    public void delete(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        memberRepository.deleteById(id);
    }
}
