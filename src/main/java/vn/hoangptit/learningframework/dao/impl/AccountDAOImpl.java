package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.dao.RoleDAO;
import vn.hoangptit.learningframework.dto.AccountDto;
import vn.hoangptit.learningframework.dto.RoleDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class AccountDAOImpl extends CrudDAOImpl<AccountDto> implements AccountDAO {

    @Autowired
    private RoleDAO roleDAO;

    private Session session;

    public AccountDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, AccountDto.class);
    }

    @Override
    public AccountDto findByUsername(String username) {
        session = openSession();

        AccountDto user;
        List<AccountDto> users = session.
                createQuery("from AccountDto where username = ?").
                setParameter(0, username).
                list();// truyền câu lệnh query + setParameter + lấy về list
        if (users.size() > 0) {
            user = users.get(0);
            return user;
        }

        return null;
    }

    @Override
    public AccountDto saveUser(AccountDto account) {
        session = openSession();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        account.setPassword(encoder.encode(account.getPassword()));
//        account.setRoles(roles);

        session.save(account);
        return account;
    }

    @Override
    public List<AccountDto> findAll() {
        return null;
    }

}
