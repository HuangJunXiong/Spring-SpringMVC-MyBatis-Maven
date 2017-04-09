package com.gray;

import com.gray.service.BaseSevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * Created by gray on 2017/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
public class TransactionTest{
    @Resource
    private TransactionTemplate transactionTemplate;
    @Autowired
    private BaseSevice baseSevice;

//    @Test
//    public void transTest() {
//        System.out.println("before transaction");
//        Integer sum1 = baseSevice.sum();
//        System.out.println("before transaction sum: "+sum1);
//        System.out.println("transaction....");
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus status) {
//                try{
//                    baseSevice.insert("INSERT INTO tbl_account VALUES (100);",false);
//                    baseSevice.insert("INSERT INTO tbl_account VALUES (100);",false);
//                } catch (Exception e){
//                    //对于抛出Exception类型的异常且需要回滚时，需要捕获异常并通过调用status对象的setRollbackOnly()方法告知事务管理器当前事务需要回滚
//                    status.setRollbackOnly();
//                    e.printStackTrace();
//                }
//           }
//        });
//        System.out.println("after transaction");
//        Integer sum2 = baseSevice.sum();
//        System.out.println("after transaction sum: "+sum2);
//    }

    @Test
    public void transTest() {
        System.out.println("before transaction");
        Integer sum1 = baseSevice.sum();
        System.out.println("before transaction sum: "+sum1);
        System.out.println("transaction....");
        try{
            baseSevice.insert("INSERT INTO tbl_account VALUES (100);",false);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("after transaction");
        Integer sum2 = baseSevice.sum();
        System.out.println("after transaction sum: "+sum2);
    }

}
