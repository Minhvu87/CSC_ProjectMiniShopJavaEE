package dao;

import java.sql.SQLException;
import java.util.List;

import dao.Repository;
import domain.Invoice;
import domain.InvoiceDetail;

public class InvoiceRepository extends Repository {
    private int[] add(List<InvoiceDetail> list) throws SQLException{
    	pstmt = connection.prepareStatement("INSERT INTO InvoiceDetail(InvoiceId, ProductId, Quantity, Price) VALUES(?,?,?,?)");
    	for(InvoiceDetail detail : list) {
    		pstmt.setLong(1, detail.getId());
    		pstmt.setInt(2, detail.getProductId());
    		pstmt.setShort(3, detail.getQuantity());
    		pstmt.setInt(4, detail.getPrice());
    		pstmt.addBatch();
    	}
    	return pstmt.executeBatch();
    }
    public int add(Invoice obj)throws SQLException{
    	try {
    		open();
    		pstmt = connection.prepareStatement("INSERT INTO Invoice(InvoiceId, MemberId, Email, Tel, Address) VALUES(?,?,?,?,?)");
    		pstmt.setLong(1, obj.getId());
    		pstmt.setObject(2, obj.getMemberId());
    		pstmt.setString(3, obj.getEmail());
    		pstmt.setString(4, obj.getTel());
    		pstmt.setString(5, obj.getAddress());
    		int ret = pstmt.executeUpdate();
    		pstmt.close();
    		add(obj.getDetails());
    		return ret;
    	}finally {
    		close();
    	}
    }
}
