package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Works;

public class WorksDAO {

		// データソース
		DataSource ds = null;
		// データベース接続情報
		Connection con = null;

		// プリコンパイル用のステートメント
		PreparedStatement stmt = null;
		// SELECTの結果を格納するResultSet
		ResultSet rs = null;

		/**
		 * データベースへの接続処理を行うメソッド
		 *
		 * @return コネクション情報
		 */
		public Connection connection() throws Exception {
			// データソースがなければ、context.xmlから読み込んで設定する
			if (ds == null) {
				ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
			}
			con = ds.getConnection();
			return con;
		}

		/**
		 * データベースからの切断処理を行うメソッド
		 */
		public void close() throws Exception {

			// データベース接続されていれば、切断する
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		public Works getcomment(String user_id, String works_id) {
			Works wr = new Works();

			try { // DB接続
				connection();
				// INSERT文の設定・実行
				// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
				String sql = "SELECT * FROM works WHERE works_id = ?;";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, works_id);
				ResultSet rs = stmt.executeQuery();

				rs.next();

				wr.setWorks_id(rs.getString("works_id"));
				wr.setWorks_name(rs.getString("works_name"));
				wr.setCreator_name(rs.getString("creator_name"));
				wr.setWorks_count(rs.getInt("works_count"));
				wr.setPath(rs.getString("path"));

			} catch (Exception e) {
				wr = null;
			} finally {
				try {
					close();
				} catch (Exception e) {

				}
			}
			return wr;
	}
}
