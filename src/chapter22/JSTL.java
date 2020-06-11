package chapter22;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

public class JSTL extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();

    try
    {
      ProductDAO dao = new ProductDAO();

      List<Product> list = dao.search("");

      // リクエスト属性の設定
      request.setAttribute("list", list);

      // フォーワード
      request.getRequestDispatcher("jstl.jsp").forward(request, response);
    }
    catch (Exception e)
    {
      e.printStackTrace(out);
    }
  }
}