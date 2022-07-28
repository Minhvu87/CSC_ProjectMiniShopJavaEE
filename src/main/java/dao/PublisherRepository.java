package dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Publisher;

public class PublisherRepository extends Repository {
	public Publisher getPublisher(int id) throws SQLException{
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Publisher WHERE PublisherId = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Publisher(rs.getInt("PublisherId"),
				rs.getString("PublisherName"));
			}
			return null;
		}finally {
			close();
		}
	}
	public int edit(Publisher obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("UPDATE Publisher SET PublisherName = ? WHERE PublisherId = ?");
			pstmt.setString(1, obj.getName());
			pstmt.setInt(2, obj.getId());
			return pstmt.executeUpdate();
		}finally {
			close();
		}
	}
	public List<Publisher> getPublishers() throws SQLException {
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Publisher");
			List<Publisher> list = new LinkedList<Publisher>();
			while (rs.next()) {
				list.add(new Publisher(rs.getInt("PublisherId"), rs.getString("PublisherName")));
			}
			return list;
		} finally {
			close();
		}
	}

	public int add(Publisher obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("INSERT INTO Publisher(PublisherName) VALUES(?)");
			pstmt.setString(1, obj.getName());
			return pstmt.executeUpdate();
		} finally {
			close();
		}
	}

	public int delete(int id) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("DELETE FROM Publisher WHERE PublisherId = ?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} finally {
			close();
		}
	}

	public int[] delete(List<Integer> list) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("DELETE FROM Publisher WHERE PublisherId = ?");
			for (Integer id : list) {
				pstmt.setInt(1, id);
				pstmt.addBatch();
			}
			return pstmt.executeBatch();
		}finally {
			close();
		}
	}
}
