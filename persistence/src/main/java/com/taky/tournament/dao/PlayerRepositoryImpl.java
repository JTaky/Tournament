package com.taky.tournament.dao;

import com.taky.common.dao.GenericHibernateDao;
import com.taky.tournament.entity.Player;
import org.springframework.stereotype.Repository;

/**
 * @author onitavskyi
 */
@Repository
public class PlayerRepositoryImpl extends GenericHibernateDao<Player, Long> {

    public PlayerRepositoryImpl(){
        super(Player.class);
    }

}
