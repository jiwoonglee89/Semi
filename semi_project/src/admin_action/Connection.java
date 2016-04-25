package admin_action;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Connection {
	String res = "sql/config.xml";

	public SqlSession connection() {
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
