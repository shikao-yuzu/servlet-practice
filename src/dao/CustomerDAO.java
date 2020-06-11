package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;

public class CustomerDAO extends DAO
{
  public Customer search(String login, String password)
    throws Exception
  {
    Customer customer = null;

    // コネクションを取得
    Connection con = this.getConnection();

    // SQL文の作成
    PreparedStatement st = con.prepareStatement("select * from customer where login=? and password=?");
    st.setString(1, login);
    st.setString(2, password);

    // SQL文の実行
    ResultSet rs = st.executeQuery();

    while (rs.next())
    {
      customer = new Customer();
      customer.setId      (rs.getInt   ("id"      ));
      customer.setLogin   (rs.getString("login"   ));
      customer.setPassword(rs.getString("password"));
    }

    // DB切断
    st.close();
    con.close();

    return customer;
  }
}
