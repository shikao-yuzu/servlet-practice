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

public class Search extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();
    Page.header(out);

    try
    {
      // JNDIを用いてデータソースを取得
      InitialContext ic  = new InitialContext();
      DataSource     ds  = (DataSource)ic.lookup("java:/comp/env/jdbc/book");

      // コネクションを取得
      Connection con = ds.getConnection();

      String keyword = request.getParameter("keyword");

      // SQL文の作成
      PreparedStatement st = con.prepareStatement("select * from product where name like ?");
      st.setString(1, "%"+keyword+"%");

      // SQL文の実行
      ResultSet rs = st.executeQuery();

      while (rs.next())
      {
        out.println(rs.getInt("id"));
        out.println(":");
        out.println(rs.getString("name"));
        out.println(":");
        out.println(rs.getInt("price"));
        out.println("<br>");
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
