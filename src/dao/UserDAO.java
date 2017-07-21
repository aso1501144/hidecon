package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.User;

public class UserDAO {
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

		public User login(String id, String pass) {
			User us = new User();

			try { // DB接続
				connection();
				// INSERT文の設定・実行
				// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
				String sql = "SELECT * FROM user WHERE user_id = ? AND password = ?;";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, id);
				stmt.setString(2, pass);
				ResultSet rs = stmt.executeQuery();

				rs.next();

				us.setUser_id(rs.getString("user_id"));
				us.setPassword(rs.getString("password"));

			} catch (Exception e) {
				us = null;
			} finally {
				try {
					close();
				} catch (Exception e) {

				}
			}
			return us;
		}
}
