package mybatis.factory;

import mybatis.config.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisSessionFactory {

  private static SqlSessionFactory sqlSessionFactory = null;

  static {
    MyBatisConfig myBatisConfig = new MyBatisConfig();
    sqlSessionFactory = myBatisConfig.getSqlSessionFactory();
  }

  public static SqlSession getSqlSession() {
    return sqlSessionFactory.openSession();
  }
}