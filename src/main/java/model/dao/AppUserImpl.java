package model.dao;

import java.util.List;
import model.AppUser;
import org.hibernate.Session;

/** Clase con el DAO generico, CommonDaoImpl */
public class AppUserImpl extends CommonDaoImpl<AppUser> implements AppUserDAOInt {
  public AppUserImpl(Session session) {
    super(session);
  }

  @Override
  public List<AppUser> searchByUsername(String username) {
    session.beginTransaction();
    String hql = "FROM AppUser WHERE username='" + username + "'";
    List<AppUser> appUsers = session.createQuery(hql, AppUser.class).list();
    session.getTransaction().commit();
    return appUsers;
  }

  @Override
  public List<AppUser> searchByMail(String mail) {
    session.beginTransaction();
    String hql = "FROM AppUser WHERE mail='" + mail + "'";
    List<AppUser> appUsers = session.createQuery(hql, AppUser.class).list();
    session.getTransaction().commit();
    return appUsers;
  }
}
