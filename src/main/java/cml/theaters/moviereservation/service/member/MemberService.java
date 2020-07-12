package cml.theaters.moviereservation.service.member;

import cml.theaters.moviereservation.domain.member.MemberRepository;
import cml.theaters.moviereservation.dto.MemberListResponseDto;
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
}
