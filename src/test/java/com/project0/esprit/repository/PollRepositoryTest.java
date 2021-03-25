/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.repository;

import com.project0.esprit.datentity.*;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest()
public class PollRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private PollRepository pollRepository;

    public PollRepositoryTest() {
    }

    @Test
    public void testFindAllByUsernameSuccess() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //given
        User user1 = em.persist(new User("TestUser1", bCryptPasswordEncoder.encode("12345")));
        User user2 = em.persist(new User("TestUser2", bCryptPasswordEncoder.encode("12345")));

        Poll poll1 = new Poll();
        poll1.setTitle("test1");
        poll1.setUser(user1);

        Poll poll2 = new Poll();
        poll2.setTitle("test2");
        poll2.setUser(user2);

        em.persist(poll1);
        em.persist(poll2);

        em.flush();

        //when
        List<Poll> polls1 = pollRepository.findAllByUser(user1);
        List<Poll> polls2 = pollRepository.findAllByUser(user2);
        List<Poll> pollsAll = pollRepository.findAll();
        //then
        assertThat(polls1.size()).isEqualTo(1);
        assertThat(polls2.size()).isEqualTo(1);
        assertThat(pollsAll.size()).isEqualTo(2);
    }

}
