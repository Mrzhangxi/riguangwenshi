<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.sql.Statement" %>
<%@page import="utilsIpml.aboutDatabaseImpl" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>

<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示学生信息</title>
<link href="css/list.css" rel="stylesheet" type="text/css">
</head>
<%! String url, user, pass; %>
<%! Connection conn; %>
<%! ResultSet rs; %>
<%! PreparedStatement pstemt; %>
<%! Statement stmt; %>
<%! aboutDatabaseImpl ad; %>
<body>
	<div id="tablediv">
		<div class="titlediv">温室数据查询</div>
		<table>
			<tr>
				<td class="shiliu">数据编号</td>
				<td class="shiliu">Mac地址</td>
				<td class="ba">空气湿度</td>
				<td class="ba">空气温度</td>
				<td class="shiliu">土壤湿度</td>
				<td class="shier">查看详情</td>
				<td class="shier">删除</td>
			</tr>
	<%
		String url = "jdbc:mysql://localhost:3306/server";
		String user = "root";
		String pass = "123654147a";
		ad = new aboutDatabaseImpl();
		ad.intiDatabase();
		Connection conn = ad.getconn(url, user, pass);
		ad = new aboutDatabaseImpl();
		ad.intiDatabase();
		conn = ad.getconn(url, user, pass);
		try{
//			stmt = conn.createStatement();
			pstemt = conn.prepareStatement("select * from elementdata1");
			rs = pstemt.executeQuery();
			while(rs.next()) {
	%>
			<tr>
				<td class="shiliu"><%=rs.getInt("dataid") %></td>
				<td class="shiliu"><%=rs.getString("mac")%></td>
				<td class="ba"><%=rs.getDouble("airtemp") %></td>
				<td class="ba"><%=rs.getDouble("airhum") %></td>
				<td class="ba"><%=rs.getDouble("soilhum") %></td>
				<td class="shiliu"><a href="change.jsp?xuehao=<%=rs.getInt("dataid") %>">查看详情</a></td>
				<td class="shiliu"><a href="del.jsp?xuehao=<%=rs.getInt("dataid") %>">删除</a></td>
			</tr>		
		<%	}
		}catch(Exception e){
			
		}finally{
			rs.close();
			pstemt.close();
			conn.close();
		}
	%>
		</table>
		<a id="insert" href="">上一页</a>
		<a id="insert" href="">下一页</a>
		&nbsp 
		按条件查询
		<select>
			<option>查看当天</option>
			<option>最近三天</option>
			<option>查看本周</option>
			<option>最近十五天</option>
			<option>最近一个月</option>
			<option>本季作物所有数据</option>		
		</select>
		&nbsp 
		<a id="insert" href="">生成数据图表</a>
		
	</div>
</body>
</html>