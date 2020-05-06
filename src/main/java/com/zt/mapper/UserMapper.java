package com.zt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zt.entity.User;

@Repository("userMapper")
public interface UserMapper {
	@Insert("INSERT INTO smbms_user(usercode,username,userpassword,gender,birthday,phone,address,userrole,createdby,creationDate,modifyby,modifydate) VALUES(#{userCode},#{userName},#{userPassword},#{gender},#{birthday},#{phone},#{address},#{userRole},#{createdBy},#{creationDate},#{modifyBy},#{modifyDate})")
	public int addUser(User user);

	//@Delete("DELETE FROM smbms_user WHERE id=#{id}")
	public int delUserById(int id);

	@Update("UPDATE smbms_user SET userpassword=#{userPassword} where usercode=#{userCode2}")
	public int updateUser(User user);
	//
	@Select("SELECT * FROM smbms_user WHERE userCode=#{userCode2} and userPassword=#{userPassword}")
	//@ResultMap("userResultMap")
	@Results({
			@Result(id=true,property="id",column="id"),
			@Result(property="userCode2",column="userCode"),
			@Result(property="userName",column="userName")
	})
	public User loginUser(User user);

	/**
	 * 根据ID查询用户
	 */
	@Select("select * from smbms_user where id=#{id}")
	@Results({
			@Result(property="userCode2",column="userCode")
	})
	public User getUserById(int id);

	@Select("select * from smbms_user")
	@Results({
			@Result(property="userCode2",column="userCode")
	})
	public List<User> getUsers();
}
