package mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisConfig {

  private static SqlSessionFactory sqlSessionFactory = null;

  static  {
    String resource = "mybatis/config/mybatis-config.xml";
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  }

  public SqlSessionFactory getSqlSessionFactory() {
    return sqlSessionFactory;
  }
}