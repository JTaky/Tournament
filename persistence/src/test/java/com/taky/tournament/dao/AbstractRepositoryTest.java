package com.taky.tournament.dao;

import com.taky.common.dao.GenericHibernateDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.List;

/**
 * Base class for DAO unit test
 *
 * @author onitavskyi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring-test-dao.xml")
public abstract class AbstractRepositoryTest<T, PK extends Serializable> extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public abstract GenericHibernateDao<T, PK> getRepository();

    protected abstract List<T> getFixtureInstance();

    //test CRUD(simple mapping)
    @Test
    public void testInsert() {
        List<T> fixtureInstanceList = getFixtureInstance();
        if(fixtureInstanceList != null){
            logger.trace("Was got {} fixture entities", fixtureInstanceList.size());
            for(T curFixtureInstance : fixtureInstanceList){
                getRepository().create(curFixtureInstance);
            }
        }
        else {
            logger.trace("Was got 'null' list of fixture entities");
        }
    }


}
