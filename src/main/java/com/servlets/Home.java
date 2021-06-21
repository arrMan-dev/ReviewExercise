package com.servlets;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

// import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String file = "ShowMe.txt";
    PrintWriter out = response.getWriter();

    try (FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource(file).getFile());
        BufferedInputStream bis = new BufferedInputStream(fis)) {
      response.setContentType("text/html");
      out.print("hello ");
      out.print("<br/>");

      while (bis.available() > 0) {
        out.print((char) bis.read());
      }
    } catch (Exception e) {
      out.print("file not found hello");
      e.printStackTrace();
    }
    out.close();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}
