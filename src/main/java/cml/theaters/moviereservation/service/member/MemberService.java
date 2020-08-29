package cml.theaters.moviereservation.service.member;

import cml.theaters.moviereservation.domain.member.Member;
import cml.theaters.moviereservation.domain.member.MemberRepository;
import cml.theaters.moviereservation.dto.MemberListResponseDto;
import cml.theaters.moviereservation.dto.MemberResponseDto;
import cml.theaters.moviereservation.dto.MemberSignUpRequestDto;
import cml.theaters.moviereservation.dto.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
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

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long memberId) {
        return new MemberResponseDto(memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + memberId)));
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findByEmail(String email) {
        return new MemberResponseDto(memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. email = " + email)));
    }

    public MemberResponseDto save(MemberSignUpRequestDto requestDto) {
        return new MemberResponseDto(memberRepository.save(requestDto.toEntity()));
    }

    public MemberResponseDto update(MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + requestDto.getMemberId()));
        member.setName(requestDto.getName());
        member.setPassword(requestDto.getPassword());
        member.setTelNumber(requestDto.getTelNumber());

        return new MemberResponseDto(member);
    }

    public void delete(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + memberId));

        memberRepository.delete(member);
    }
}
