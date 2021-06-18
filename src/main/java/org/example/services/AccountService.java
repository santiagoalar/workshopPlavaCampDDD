package org.example.services;

import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.Email;
import org.example.domain.account.values.PhoneNumber;

public interface AccountService {
    PhoneNumber getPhoneNumberByAccountId(AccountId accountId);
    Email getEmailByAccountId(AccountId accountId);
}
