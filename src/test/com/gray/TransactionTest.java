package com.gray;

import com.gray.service.BaseSevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by gray on 2017/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
public class TransactionTest{
//    @Resource
//    private TransactionTemplate transactionTemplate;
    @Autowired
    private BaseSevice baseSevice;

    @Test
    public void transTest() {
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus status) {
//                baseSevice.insert("INSERT INTO tbl_account VALUES (100);");
//            }
//        });
        System.out.println("test.....");
        baseSevice.insert("INSERT INTO tbl_account VALUES (100);");
    }
}
