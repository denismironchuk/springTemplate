package app;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("testEntityDao")
public class TestEntityDao {
    @Autowired
    private SessionFactory factory;

    @Transactional(readOnly = true)
    public TestEntity get(Long id) {
        return factory.getCurrentSession().find(TestEntity.class, id);
    }

    @Transactional(readOnly = true)
    public List<TestEntity> getAll() {
        return factory.getCurrentSession().createQuery("select t from TestEntity t", TestEntity.class).getResultList();
    }

    @Transactional
    public void save(TestEntity entity) {
        factory.getCurrentSession().save(entity);
    }
}
