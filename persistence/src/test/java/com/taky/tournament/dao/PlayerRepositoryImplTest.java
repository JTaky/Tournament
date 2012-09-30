package com.taky.tournament.dao;

import com.taky.common.dao.GenericHibernateDao;
import com.taky.tournament.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author onitavskyi
 */
public class PlayerRepositoryImplTest extends AbstractRepositoryTest<Player, Long> {

    @Autowired
    PlayerRepositoryImpl playerRepository;

    @Override
    public GenericHibernateDao<Player, Long> getRepository() {
        return playerRepository;
    }

    @Override
    protected List<Player> getFixtureInstance() {
        return Arrays.asList(
                new Player().setName("Nikolay"),
                new Player().setName("Buffer")
        );
    }

}
