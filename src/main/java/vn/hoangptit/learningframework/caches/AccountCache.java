package vn.hoangptit.learningframework.caches;

import org.springframework.beans.factory.annotation.Autowired;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.entities.Account;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author Hoangptit
 * Date 8/27/2016
 */
@Singleton
public class AccountCache {

    @Autowired
    private static AccountDAO accountDAO;

    private static Map<String, Account> accountMap;

    public static void loadAccount() {
        accountMap = new HashMap<>();

        List<Account> accounts = null;
        for (Account ac : accounts) {
            accountMap.put(ac.getUsername(), ac);
        }
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

}
