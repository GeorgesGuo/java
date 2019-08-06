package com.guo;
import com.guo.mapper.OrdersExMapper;
import com.guo.po.Orders;
import com.guo.po.OrdersEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import java.io.InputStream;
import java.util.List;

public class Test {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInitial(){
        String sqlConfigFile = "sqlMapConfig.xml";
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream(sqlConfigFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @org.junit.Test
    public void testQueryOrdersUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersExMapper ordersExMapper = sqlSession.getMapper(OrdersExMapper.class);
            List<OrdersEx> ordersEx = ordersExMapper.queryOrderUser();
            System.out.println(ordersEx);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @org.junit.Test
    public void testQueryOrdersUserResultMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersExMapper ordersExMapper = sqlSession.getMapper(OrdersExMapper.class);
            List<Orders> ordersList = ordersExMapper.queryOrderUserResultMap();
            System.out.println(ordersList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
