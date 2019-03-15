package com.zms.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zms.bean.Login;

public class Loginsqltest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//mybatis需要用到工厂模式进行测试sql语句
		//得到xml文件
			InputStream in=Resources.getResourceAsStream("mybatis.xml");//加载全局配置文件
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);//建立工厂代理模式	
			SqlSession sqlsession=factory.openSession();//生产sql
			//查询出一个集合来
//			List<Login> lists=sqlsession.selectList("a.b.seletLogin");//返回所有的对象
//			for(Login list : lists) {
//				System.out.println(list.toString());
//			}
			//查询出单个值
//			Login simple=sqlsession.selectOne("a.b.selectsimple");
//			System.out.println(simp0le.toString());
			//查询出一个map的值
//			Map<Object, Object> ss=sqlsession.selectMap("a.b.c", "username_login");
//			System.out.println(ss.toString());
//			Map<String, Object> map=new HashMap<>();
//			map.put("id", 1);
//			map.put("name", "张三");
//			List<Login> one = sqlsession.selectList("a.b.d",map);
			Login login=new Login();
			login.setPassword_login("147");
			login.setUsername_login("zms");
			int indexf=sqlsession.insert("a.b.ins",login);
			if(indexf>0) {
				System.out.println("success");
			}else {
				System.out.println("false");
			}
			sqlsession.commit();//手动提交事务
			sqlsession.close();//关闭sqlsession对象
	}	

}
