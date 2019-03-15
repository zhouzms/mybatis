package com.zms.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ConnectionTest
 */
@WebServlet("/ConnectionTest")
public class ConnectionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ͨ��Context�������ĵ�Context.xml�������ļ������ҵ����ӳ��е����ݿ����
		//java:comp/env/����ǹ̶�������������������ʽ
		Context con;
		try {
			con = new InitialContext();
			DataSource ds=(DataSource) con.lookup("java:comp/env/mysql");//�ҵ����ӳ����������ݿ�Ĵ���
			Connection cons=ds.getConnection();//�õ��������ݿ��Connection����
			PreparedStatement ps=cons.prepareStatement("select * from login");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				response.getWriter().write(rs.getString(1)+"\n");
			}
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
