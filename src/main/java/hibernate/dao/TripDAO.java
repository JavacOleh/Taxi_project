package hibernate.dao;

import hibernate.Trip;
import hibernate.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TripDAO {

    public List<Trip> getTripList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Trip> query = session.createQuery("from Trip", Trip.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Trip getTripById(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Trip.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveTrip(Trip trip) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.save(trip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTrip(Trip trip) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(trip);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTrip(Trip trip) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(trip);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Trip getFirstTrip() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Trip> query = session.createQuery("from Trip order by Trip_id asc", Trip.class);
            query.setMaxResults(1);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Trip getLastTrip() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Trip> query = session.createQuery("from Trip order by Trip_id desc", Trip.class);
            query.setMaxResults(1);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getNextTripId(int currentTripId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "SELECT min(Trip_id) FROM Trip WHERE Trip_id > :currentTripId";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            query.setParameter("currentTripId", currentTripId);
            session.getTransaction().commit();
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getPreviousTripId(int currentTripId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "SELECT max(Trip_id) FROM Trip WHERE Trip_id < :currentTripId";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            query.setParameter("currentTripId", currentTripId);
            session.getTransaction().commit();
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
