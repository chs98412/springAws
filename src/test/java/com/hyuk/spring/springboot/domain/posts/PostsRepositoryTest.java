package com.hyuk.spring.springboot.domain.posts;


import com.hyuk.spring.springboot.domain.Posts.Posts;
import com.hyuk.spring.springboot.domain.Posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        String title="테스트 게시글;";
        String content="테스트 본문";

        postsRepository.save(Posts.builder().title(title).content(content).author("chs98412@gmail.com").build());

        List<Posts> postsList=postsRepository.findAll();

        Posts posts= postsList.get(0);
    }
}
