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
		//mybatis��Ҫ�õ�����ģʽ���в���sql���
		//�õ�xml�ļ�
			InputStream in=Resources.getResourceAsStream("mybatis.xml");//����ȫ�������ļ�
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);//������������ģʽ	
			SqlSession sqlsession=factory.openSession();//����sql
			//��ѯ��һ��������
//			List<Login> lists=sqlsession.selectList("a.b.seletLogin");//�������еĶ���
//			for(Login list : lists) {
//				System.out.println(list.toString());
//			}
			//��ѯ������ֵ
//			Login simple=sqlsession.selectOne("a.b.selectsimple");
//			System.out.println(simp0le.toString());
			//��ѯ��һ��map��ֵ
//			Map<Object, Object> ss=sqlsession.selectMap("a.b.c", "username_login");
//			System.out.println(ss.toString());
//			Map<String, Object> map=new HashMap<>();
//			map.put("id", 1);
//			map.put("name", "����");
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
			sqlsession.commit();//�ֶ��ύ����
			sqlsession.close();//�ر�sqlsession����
	}	

}
