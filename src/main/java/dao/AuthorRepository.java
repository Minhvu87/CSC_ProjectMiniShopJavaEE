package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import domain.Author;
import utils.HibernateUtils;

public class AuthorRepository {

	public List<Author> findAll() {
		Session session = HibernateUtils.getSessionfactory().openSession();
		Query query = session.createQuery("from Author");
		return query.getResultList();
	}

	public Author findById(int id) {
		Session session = HibernateUtils.getSessionfactory().openSession();
		return session.find(Author.class, id);
	}

	public Integer insert(Author author) {
		Transaction tran = null;
		try (Session session = HibernateUtils.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.save(author);
			tran.commit();
			return 1;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}

	public boolean update(Author author) {
		Transaction tran = null;
		try (Session session = HibernateUtils.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.merge(author);
			tran.commit();
			return true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		}

		return false;
	}

	public void delete(Integer id) {

		Transaction trans = null;
		try (Session session = HibernateUtils.getSessionfactory().openSession()) {
			trans = session.beginTransaction();

			Author author = session.find(Author.class, id);
			session.delete(author);

			trans.commit();
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Author> search(String q) {
		try (Session session = HibernateUtils.getSessionfactory().openSession()) {
			final Query query = session.createQuery("From Author WHERE AuthorName LIKE :q");
			query.setParameter("q", '%' + q + '%');
			return query.list();
		}
	}

}
