package com.fpc.MappingInterface;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

import com.fpc.Entity.User;

public interface userMapperI {
	//ʹ��@Insertע��ָ��add����Ҫִ�е�SQL
	@Insert("insert into users(name,age) values(#{name},#{age})")
	public int addUser(User user);
	
	//ʹ��@Deleteע��ָ��deleteUser����Ҫִ�е�SQL
	@Delete("delete from users where id=#{id}")
	public int deleteUser(int id);
	
	//ʹ��@Update����ָ��updateUser����Ҫִ�е�SQL
	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	public int updateUser(User user);
	
	//ʹ��selectע��ָ��getUserById����Ҫִ�е�SQL
	@Select("select * from users where id=#{id}")
	public User getUserById(int id);
	
	//ʹ��selectע��ָ��getAllUsers����Ҫִ�е�SQL
	@Select("select * from users")
	public List<User> getAllUsers();
}
