package chapter17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Page;

public class CartRemove extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();

    Page.header(out);

    // セッションの開始/取得
    HttpSession session = request.getSession();

    // セッション属性の削除
    session.removeAttribute("cart");

    out.println("カートを削除しました");
    Page.footer(out);
  }
}