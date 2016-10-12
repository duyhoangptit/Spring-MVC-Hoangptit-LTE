package vn.hoangptit.learningframework.caches;

import org.springframework.beans.factory.annotation.Autowired;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.dto.AccountDto;

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

    private static Map<String, AccountDto> accountMap;

    public static void loadAccount() {
        accountMap = new HashMap<>();

        List<AccountDto> accounts = accountDAO.findAll();
        for (AccountDto ac : accounts) {
            accountMap.put(ac.getUsername(), ac);
        }
    }

    public Map<String, AccountDto> getAccountMap() {
        return accountMap;
    }

}
