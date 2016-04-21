package connection;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Connection {
	

	public SqlSession connection() {
		String res = "config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(res);

			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			System.out.println("factory ok");
			SqlSession session = factory.openSession();
			return session;
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
	}
}
