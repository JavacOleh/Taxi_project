package hibernate.dao;

import hibernate.Taxi;
import hibernate.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TaxiDAO {
    public List<Taxi> getTaxiList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Taxi> query = session.createQuery("from Taxi", Taxi.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Taxi getTaxiById(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Taxi.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void saveTaxi(Taxi taxi) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.save(taxi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
