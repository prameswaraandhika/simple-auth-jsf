package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.ConnectionManager;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class LoginServiceImpl implements LoginServices {

    @Override
    public String validatingAccounts(String username, String password) {
        String query = "SELECT * FROM \n"
                + "public.tabel_login\n"
                + "WHERE username = ? AND password = ?;";

        Connection conn = null;
        ResultSet res = null;
        PreparedStatement pre = null;
        String role = "";
        try {
            conn = new ConnectionManager().getConnection();
            pre = conn.prepareStatement(query);
            pre.setString(1, username);
            pre.setString(2, password);
            res = pre.executeQuery();
            while (res.next()) {
                role = res.getString("role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pre.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return role;
    }

//    public static void main(String[] args) {
//        String roleUser = new LoginServiceImpl().validatingAccounts("andhikap", "");
//
//        switch (roleUser) {
//            case "helpdesk":
//                System.out.println("hello from dashboard helpdesk");
//                break;
//            case "client":
//                System.out.println("hello from dashboard client");
//                break;
//            case "admin":
//                System.out.println("hello from dashboard admin");
//                break;
//            default:
//                System.out.println("user not found / login failed");
//        }
//
//    }
}
