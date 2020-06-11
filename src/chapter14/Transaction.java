package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

public class Transaction extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();
    Page.header(out);

    try
    {
      // JNDIを用いてデータソースを取得
      InitialContext ic = new InitialContext();
      DataSource     ds = (DataSource)ic.lookup("java:/comp/env/jdbc/book");

      // コネクションを取得
      Connection con = ds.getConnection();

      String name  = request.getParameter("name");
      int    price = Integer.parseInt(request.getParameter("price"));

      // 自動コミットモードを無効化
      con.setAutoCommit(false);

      // 挿入SQL文の作成
      PreparedStatement st = con.prepareStatement("insert into product values(null, ?, ?)");
      st.setString(1, name);
      st.setInt(2, price);

      // 挿入SQL文の実行
      st.executeUpdate();

      // 登録チェックSQL文の作成
      st = con.prepareStatement("select * from product where name=?");
      st.setString(1, name);

      // 登録チェックSQL文の実行
      ResultSet rs = st.executeQuery();

      int line = 0;
      while (rs.next())
      {
        line++;
      }

      if (line == 1)
      {
        // コミット
        con.commit();
        out.println("商品を登録しました");
      }
      else
      {
        // ロールバック
        con.rollback();
        out.println("エラー：商品は登録済み！");
      }

      // DB切断
      st.close();
      con.close();
    }
    catch (Exception e)
    {
      e.printStackTrace(out);
    }

    Page.footer(out);
  }
}
