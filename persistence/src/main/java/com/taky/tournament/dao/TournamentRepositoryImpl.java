package com.taky.tournament.dao;

import com.taky.common.dao.GenericHibernateDao;
import com.taky.tournament.entity.Tournament;
import org.springframework.stereotype.Repository;

/**
 * @author onitavskyi
 */
@Repository
public class TournamentRepositoryImpl extends GenericHibernateDao<Tournament, Long> implements TournamentRepository {
}
