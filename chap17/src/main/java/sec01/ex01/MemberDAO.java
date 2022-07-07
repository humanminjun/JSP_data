package sec01.ex01;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection conn;
	private OreoaredStatement pstmt;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers() {
		List membersList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = "select * from t_member order by joinData desc";
			System.out.println(query);
		}
	}
}
