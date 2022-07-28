package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;

import domain.Member;

public class MemberRepository extends Repository {
	private static byte[] sha256(String plaintext) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return digest.digest(plaintext.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
			return null;
		}
	}
	public static String getSHA256(String data){
	    StringBuffer sb = new StringBuffer();
	    try{
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(data.getBytes());
	        byte byteData[] = md.digest();

	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return sb.toString();
	}
	private static long random() {
		Random rand = new Random();
		long a = rand.nextInt();
		long b = rand.nextInt();
		return a * b;
	}

	public int add(Member obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement(
					"INSERT INTO Member(MemberId, Username, Password, FullName, Email, Gender) VALUES(?,?,?,?,?,?)");
			pstmt.setLong(1, random());
			pstmt.setString(2, obj.getUsername());
			pstmt.setString(3, getSHA256(obj.getPassword()));
			pstmt.setString(4, obj.getFullname());
			pstmt.setString(5, obj.getEmail());
			pstmt.setByte(6, obj.getGender());
			return pstmt.executeUpdate();
		} finally {
			close();
		}
	}

	public Member logOn(String username, String password) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT MemberId, Username FROM Member WHERE Username = ? AND Password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, getSHA256(password));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getLong("MemberId"), rs.getString("Username"));
			}
			return null;
		} finally {
			close();
		}
	}

}
