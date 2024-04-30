package hibernate.dao;

import hibernate.Client;
import hibernate.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDAO {
    public List<Client> getClientList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("from Client", Client.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public Client getClientById(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Client getClientByName(String name) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Client) session.createQuery("FROM Client WHERE name = :name")
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Client getClientByNumber(String number) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Client) session.createQuery("FROM Client WHERE number = :number")
                    .setParameter("number", number)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveClient(Client client) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.save(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(Client client) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
