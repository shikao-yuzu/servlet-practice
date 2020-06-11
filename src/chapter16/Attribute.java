package chapter16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;

public class Attribute extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    Product p = new Product();

    p.setId(1);
    p.setName("まぐろ");
    p.setPrice(100);

    // リクエスト属性の設定
    request.setAttribute("product", p);

    // フォーワード
    request.getRequestDispatcher("attribute.jsp").forward(request, response);
  }
}
