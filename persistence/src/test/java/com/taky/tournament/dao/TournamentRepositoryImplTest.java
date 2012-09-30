package com.taky.tournament.dao;

import com.taky.common.dao.GenericHibernateDao;
import com.taky.tournament.entity.Tournament;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author onitavskyi
 */
public class TournamentRepositoryImplTest extends AbstractRepositoryTest<Tournament, Long> {

    @Autowired
    private TournamentRepositoryImpl tournamentRepository;

    @Override
    public GenericHibernateDao<Tournament, Long> getRepository() {
        return tournamentRepository;
    }

    @Override
    protected List<Tournament> getFixtureInstance() {
        return Arrays.asList(
                new Tournament().setName("Winter cup"),
                new Tournament().setName("Luxoft open")
        );
    }

}
