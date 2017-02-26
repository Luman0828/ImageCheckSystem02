package com.imagecheck.mapper;




import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imagecheck.pojo.User;

public interface UserMapper {
	public int insert(@Param("user")User user);
	public int deleteById(@Param("userId")String userId);
	public int update(@Param("user")User user);
	public User findByPassword( @Param("userId")String userId,@Param("password")String password);
	public User findById(@Param("userId") String userId);
	
}
