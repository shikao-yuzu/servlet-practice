package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDAO extends DAO
{
  public List<Product> search(String keyword)
    throws Exception
  {
    List<Product> list = new ArrayList<>();

    // コネクションを取得
    Connection con = this.getConnection();

    // SQL文の作成
    PreparedStatement st = con.prepareStatement("select * from product where name like ?");
    st.setString(1, "%"+keyword+"%");

    // SQL文の実行
    ResultSet rs = st.executeQuery();

    while (rs.next())
    {
      Product p = new Product();
      p.setId   (rs.getInt   ("id"   ));
      p.setName (rs.getString("name" ));
      p.setPrice(rs.getInt   ("price"));
      list.add(p);
    }

    // DB切断
    st.close();
    con.close();

    return list;
  }

  public int insert(Product product)
      throws Exception
    {
      // コネクションを取得
      Connection con = this.getConnection();

      // SQL文の作成
      PreparedStatement st = con.prepareStatement("insert into product values(null, ?, ?)");
      st.setString(1, product.getName() );
      st.setInt   (2, product.getPrice());

      // SQL文の実行
      int line = st.executeUpdate();

      // DB切断
      st.close();
      con.close();

      return line;
    }
}
