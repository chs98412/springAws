package com.hyuk.spring.springboot.service.posts;

import com.hyuk.spring.springboot.domain.Posts.Posts;
import com.hyuk.spring.springboot.domain.Posts.PostsRepository;
import com.hyuk.spring.springboot.web.dto.PostResponseDto;
import com.hyuk.spring.springboot.web.dto.PostSaveRequestDto;
import com.hyuk.spring.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

        private final PostsRepository postsRepository;

        @Transactional
        public Long save(PostSaveRequestDto requestDto){
            return postsRepository.save(requestDto.toEntity()).getId();
        }

        @Transactional
        public Long update(Long id, PostsUpdateRequestDto requestDto){
                Posts posts= postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

                posts.update(requestDto.getTitle(),requestDto.getContent());
                return id;
        }

        public PostResponseDto findById (Long id){
                Posts entity= postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

                return new PostResponseDto(entity);
        }

}
