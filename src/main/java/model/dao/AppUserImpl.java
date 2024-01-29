package model.dao;

import connector.HibernateUtils;
import java.util.List;
import model.AppUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

/** Clase con el DAO generico, CommonDaoImpl */
public class AppUserImpl extends CommonDaoImpl<AppUser> implements AppUserDAOInt {
  public AppUserImpl(Session session) {
    super(session);
  }

  @Override
  public AppUser searchByUsername(String username) {
    HibernateUtils.startTransaction();
    String hql = "FROM AppUser WHERE username='" + username + "'";
    List<AppUser> appUsers = session.createQuery(hql, AppUser.class).list();
    HibernateUtils.commitTransaction();
    AppUser appUser = appUsers.get(0);
    return appUser;
  }

  @Override
  public List<AppUser> searchByMail(String mail) {
    session.beginTransaction();
    String hql = "FROM AppUser WHERE mail='" + mail + "'";
    List<AppUser> appUsers = session.createQuery(hql, AppUser.class).list();
    session.getTransaction().commit();
    return appUsers;
  }

  @Override
  public void updateLastLogin(AppUser usuario) {
    HibernateUtils.startTransaction();
    String hql =
        "UPDATE AppUser SET lastLogin = :lastLogin WHERE "
            + "(username = :userOrMail AND password = :password) OR "
            + "(mail = :userOrMail AND password = :password)";

    Query query = session.createQuery(hql);
    query.setParameter("lastLogin", usuario.getLastLogin());
    query.setParameter("userOrMail", usuario.getUsername());
    query.setParameter("password", usuario.getPassword());

    query.executeUpdate();
    HibernateUtils.commitTransaction();
  }
}
