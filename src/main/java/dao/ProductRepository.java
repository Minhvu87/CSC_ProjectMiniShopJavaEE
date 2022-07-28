package dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Product;

public class ProductRepository extends Repository {
	public int count() throws SQLException {
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) AS Total FROM Product");
			if (rs.next()) {
				return rs.getInt("Total");
			}
			return 0;
		} finally {
			close();
		}
	}

	public List<Product> getProducts(int index, int size) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Product LIMIT ?,?");
			pstmt.setInt(1, (index - 1) * size);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Product> list = new LinkedList<>();
			while (rs.next()) {
				Product obj = new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
						rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
				list.add(obj);
			}
			return list;
		} finally {
			close();
		}
	}
	public Product getProduct(int id) throws SQLException{
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Product WHERE ProductId = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Product(
						rs.getInt("ProductId"),
						rs.getString("Title"),
						rs.getString("ISBN"),
						rs.getInt("Price"),
						rs.getString("Pages"),
						rs.getString("ImageUrl"));
			}
			return null;
		}finally {
			close();
		}
	}
	public List<Product> search(String q)throws SQLException{
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Product WHERE Title LIKE ?");
			pstmt.setString(1,"%" + q + "%");
			rs = pstmt.executeQuery();
			List<Product> list = new LinkedList<>();
			while(rs.next()) {
				Product obj = new Product(
						rs.getInt("ProductId"),
						rs.getString("Title"),
						rs.getString("ISBN"),
						rs.getInt("Price"),
						rs.getString("Pages"),
						rs.getString("ImageUrl"));
				list.add(obj);
			}
			return list;
		}finally {
			close();
		}
	}
}
