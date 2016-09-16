package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.dao.RoleDAO;
import vn.hoangptit.learningframework.entities.Account;
import vn.hoangptit.learningframework.entities.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class AccountDAOImpl extends CrudDAOImpl<Account> implements AccountDAO {

    @Autowired
    private RoleDAO roleDAO;

    private Session session;
    private SessionFactory sessionFactory;

    public AccountDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Account.class);
        this.sessionFactory = sessionFactory;
    }

    private void openSession() {
        this.session = this.sessionFactory.getCurrentSession();
    }

    @Override
    public Account findByUsername(String username) {
        openSession();
        Account user;
        List<Account> users = session.
                createQuery("from Account where username = ?").
                setParameter(0, username).
                list();// truyền câu lệnh query + setParameter + lấy về list
        if (users.size() > 0) {
            user = users.get(0);
            return user;
        }
        return null;
    }

    @Override
    public Account saveUser(Account account, String roleUser) {
        openSession();

        Set<Role> roles = new HashSet<>();
        Role role = roleDAO.findByName(roleUser);
        roles.add(role);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        account.setPassword(encoder.encode(account.getPassword()));
        account.setRoles(roles);

        session.save(account);
        return account;
    }

    @Override
    public Account updateUser(Account account) {
        openSession();
        session.update(account);
        return account;
    }

    @Override
    public List<Account> findAll() {
        openSession();
        List<Account> accounts = session.createQuery("FROM Account ").list();
        return accounts;
    }

    @Override
    public void delete(int userId) {
        openSession();
        Account account = (Account) session.get(Account.class, userId);
        session.delete(account);
    }

}
