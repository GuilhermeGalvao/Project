package com.example.projectspendingcontrol.repoTest;

import com.example.projectspendingcontrol.repository.AccountRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
public class AccountTest {

    @Autowired
    AccountRepo accountRepo;



    @Test
    public void testSaveAccount(){

    }
}
