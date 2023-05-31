package backend.service;

import backend.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CommentServiceIMPL implements ICommentService {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }

    @Override
    public List<Comment> findAll() {
        String SELECT_COMMENT = "select c from Comment c";
        TypedQuery<Comment> query = entityManager.createQuery(SELECT_COMMENT, Comment.class);
        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        Session session;
        Transaction transaction;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        if (comment.getId() != null) {
            Comment comment1 = findById(comment.getId());
            comment1.setLikes(comment1.getLikes());
            session.saveOrUpdate(comment1);
        } else
            session.saveOrUpdate(comment);
        transaction.commit();
        session.close();
    }

    @Override
    public Comment findById(Long id) {
        String SELECT_COMMENT_BY_ID = "select c from Comment c where c.id=:id";
        TypedQuery<Comment> query = entityManager.createQuery(SELECT_COMMENT_BY_ID, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
