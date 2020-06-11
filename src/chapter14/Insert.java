package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

public class Insert extends HttpServlet
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

      // SQL文の作成
      PreparedStatement st = con.prepareStatement("insert into product values(null, ?, ?)");
      st.setString(1, name);
      st.setInt(2, price);

      // SQL文の実行
      int line = st.executeUpdate();

      if (line > 0)
      {
        out.println("成功しました");
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
