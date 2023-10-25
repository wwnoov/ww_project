import java.io.InputStream;
import java.util.ArrayList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	// 데이터베이스 연결 정보
	String url = "jdbc:mariadb://127.0.0.1:3306/addr_prj";
	String user = "root";
	String pass = "12345";
	// MyBatis를 사용하기 위한 SqlSessionFactory
	SqlSessionFactory sqlSessionFactory;
	// MyBatis 설정을 초기화하는 메서드
	public void init() {
		try {
			// MyBatis 설정 파일을 로드
			String resource = "./mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactory를 설정 파일을 통해 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
			e.printStackTrace();
		}
	}
	// 모든 주소록 데이터를 가져오는 메서드
	public ArrayList<Addr> getAddresses() {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		ArrayList<Addr> addrList = mapper.getAddresses();
		return addrList;
	}
	// 주소록에 새 주소를 추가하는 메서드
	public void insertAddress(String name, String address, String phone) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		Addr addr = new Addr(name, address, phone);
		mapper.insertAddress(addr);
		
		session.commit(); // update, delete, insert
	}
	// 주소록 데이터를 업데이트하는 메서드
	public void updateAddress(int id, String name, String address, String phone) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		Addr addr = new Addr(id, name, address, phone);
		mapper.updateAddress(addr);
		
		session.commit(); // update, delete, insert
	}
	// 주소록 데이터를 삭제하는 메서드
	public void deleteAddress(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		mapper.deleteAddress(id);
		
		session.commit(); // update, delete, insert
	}
	
}
