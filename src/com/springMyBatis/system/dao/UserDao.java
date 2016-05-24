package com.springMyBatis.system.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springMyBatis.system.model.User;

public interface UserDao {
	@Select("select * from user where username=#{username} and password=#{password}")
	public User getUser(User user);
	
	@Insert("insert into user(id,username,password) values(#{id},#{username},#{password})")
    public void addUser(User user);
    
    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    public void updateUser(User user);
    
    @Delete("delete from user where id=#{id}")
    public void deleteUser(int UserId);
}
