package com.imagecheck.mapper;




import java.util.List;

import com.imagecheck.pojo.User;

public interface UserMapper {
	public int insert(User user);
	public boolean deleteById(String userid);
	public boolean update(User user);
	public User findByPassword( String userId,String password);
	public User findById( String userId);
	public List<User> findByClassId(String classid);
}
