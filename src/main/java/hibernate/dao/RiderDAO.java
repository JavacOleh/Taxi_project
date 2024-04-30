package hibernate.dao;

import hibernate.Rider;
import hibernate.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RiderDAO {
    public List<Rider> getRiderList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Rider> query = session.createQuery("from Rider", Rider.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Rider getRiderById(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Rider.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveRider(Rider rider) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.save(rider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
