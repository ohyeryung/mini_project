package com.ohye.mini_pj.service;

import com.ohye.mini_pj.domain.posts.Posts;
import com.ohye.mini_pj.domain.posts.PostsRepository;
import com.ohye.mini_pj.web.dto.PostsResponseDto;
import com.ohye.mini_pj.web.dto.PostsSaveRequestDto;
import com.ohye.mini_pj.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글입니다. + id = " + id)
        );
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글입니다. + id = " + id)
        );
        return new PostsResponseDto(entity);
    }
}
