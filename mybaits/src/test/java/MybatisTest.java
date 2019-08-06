import com.guo.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    private SqlSessionFactory sqlSessionFactory = null;

    //初始化
    @Before
    public void testInit(){
        String file ="sqlMapConfig.xml";
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUserInfoByid(){
        SqlSession sqlSession =null;
        try {
            sqlSession =sqlSessionFactory.openSession();
        }catch (Exception ex){
        ex.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }




}
