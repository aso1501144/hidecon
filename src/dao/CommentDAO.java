package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Comment;

public class CommentDAO {

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

			public Comment getcomment(String user_id, String works_id) {
				Comment cm = new Comment();

				try { // DB接続
					connection();
					// INSERT文の設定・実行
					// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
					String sql = "SELECT * FROM comment WHERE user_id = ? AND works_id = ?;";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, user_id);
					stmt.setString(2, works_id);
					ResultSet rs = stmt.executeQuery();

					rs.next();

					cm.setUser_id(rs.getString("user_id"));
					cm.setWorks_id(rs.getString("works_id"));
					cm.setComment(rs.getString("comment"));

				} catch (Exception e) {
					cm = null;
				} finally {
					try {
						close();
					} catch (Exception e) {

					}
				}
				return cm;
			}

			public ArrayList<Comment> getcomments(String works_id) {
				ArrayList<Comment> list = new ArrayList<Comment>();
				Comment cm = new Comment();
				try { // DB接続
					connection();
					// INSERT文の設定・実行
					// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
					String sql = "SELECT * FROM comment WHERE works_id = ?;";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, works_id);
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
					cm.setWorks_id(rs.getString("works_id"));
					cm.setUser_id(rs.getString("user_id"));
					cm.setComment(rs.getString("comment"));

					list.add(cm);
					}
				} catch (Exception e) {
					list = null;
				} finally {
					try {
						close();
					} catch (Exception e) {

					}
				}
				return list;
		}

			public void insertcomment(String user_id,String works_id,String comment) {


			try {
				// DB接続
				connection();
				// INSERT文の設定・実行
				// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
				String sql = "INSERT INTO comment VALUES(?,?,?);";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, user_id);
				stmt.setString(2, works_id);
				stmt.setString(3, comment);
				stmt.executeUpdate();
			} catch (Exception e) {
			} finally {
				try {
					close();
				} catch (Exception e) {
				}
			}
		}
}
