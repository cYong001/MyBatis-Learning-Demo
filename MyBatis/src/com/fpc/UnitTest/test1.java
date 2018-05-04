package com.fpc.UnitTest;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.util.ArrayList;
import java.util.List;

import com.fpc.Entity.Classes;
import com.fpc.Entity.Order;
import com.fpc.Entity.User;
import com.fpc.MappingInterface.userMapperI;

public class test1 {
	public static SqlSession getMybatisSession () {
		//mybatis�������ļ�
		String resource = "conf.xml";
				
		//ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ�
		InputStream is = test1.class.getClassLoader().getResourceAsStream(resource);
				
		//����sqlSessiong�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
				
		SqlSession  session = sessionFactory.openSession();
		return session;
	}
	
	public String addUser(User user) {
		SqlSession session = test1.getMybatisSession();
		String statement1 = "com.fpc.Mapping.userMapper.addUser"; //����û�
		//�������
		int resultRet = session.insert(statement1, user);
		//�ֶ��ύ����
		session.commit();
		session.close();
		
		if ( resultRet != 0 ) {
			return "add success";
		} else {
			return "add failed";
		}
	}
	
	public User getUserByID( int id ) {
		SqlSession session = test1.getMybatisSession();
		String statement = "com.fpc.Mapping.userMapper.getUser"; //ӳ��sql�ı�ʶ�ַ���
		User user = session.selectOne(statement,id);
		session.close();
		return user;
	}
	public List<User> getAllUsers(){
		SqlSession session = test1.getMybatisSession();
		String statement = "com.fpc.Mapping.userMapper.getAllUsers";
		List list = new ArrayList<User>();
		list = session.selectList(statement);
		return list;
	}
	
	public String deleteUser( int id ) {
		SqlSession session = test1.getMybatisSession();
		String statement = "com.fpc.Mapping.userMapper.deleteUser";
		int resultRet = session.delete(statement,id);
		if ( resultRet != 0 ) {
			return "delete success";
		} else {
			return "delete failed";
		}
	}
	
	public String updateUser( User user ) {
		SqlSession session = test1.getMybatisSession();
		String statement = "com.fpc.Mapping.userMapper.updateUser";
		int resultRet = session.delete(statement,user);
		if ( resultRet != 0 ) {
			return "update success";
		} else {
			return "update failed";
		}
	}
	
	public Order getOrderById( int id) {
		SqlSession session = test1.getMybatisSession();
		String statement = "com.fpc.Mapping.orderMapper.selectOrderResultMap";
		Order order = session.selectOne(statement,id);
		return order;
	}
	
	public Classes getClass( int id ) {
		SqlSession session = test1.getMybatisSession();
		String statement = "com.fpc.Mapping.classMapper.getClass1";
		Classes c = session.selectOne(statement, id);
		return c;
	}
	public static void main( String[] args ) {
		test1 t = new test1();
		Classes c = t.getClass(1);
		System.out.println(c.toString());
	}
	public static void cuttingLine() {
		System.out.println("===========================================");
	}
}
