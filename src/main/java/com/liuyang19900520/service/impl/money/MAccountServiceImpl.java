package com.liuyang19900520.service.impl.money;

import com.liuyang19900520.dao.money.MAccountDao;
import com.liuyang19900520.domain.money.MAccount;
import com.liuyang19900520.service.money.MAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class MAccountServiceImpl implements MAccountService {

    @Autowired
    private MAccountDao mAccountDao;

    @Override
    public List<MAccount> listAccountsByUserId(String userId) {
        return null;
    }

    @Override
    @Transactional
    public List<MAccount> createAccounts(MAccount mAccount) {

        mAccount.setAccountId(UUID.randomUUID().toString());
        return null;
    }
}
