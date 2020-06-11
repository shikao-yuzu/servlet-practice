package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
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
      Product p = new Product();

      p.setName (request.getParameter("name"));
      p.setPrice(Integer.parseInt(request.getParameter("price")));

      ProductDAO dao = new ProductDAO();

      int line = dao.insert(p);

      if (line > 0) out.println("Success!");
    }
    catch (Exception e)
    {
      e.printStackTrace(out);
    }

    Page.footer(out);
  }
}
