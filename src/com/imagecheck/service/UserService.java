package com.imagecheck.service;

import java.util.List;

import com.imagecheck.pojo.Homework_Result;
import com.imagecheck.pojo.Homework_Task;
import com.imagecheck.pojo.User;
import com.imagecheck.util.Page;


public interface UserService {
    public String login(String userid, String password);
    public List<Homework_Task> readTasks(Page page);
    public Homework_Task readTask(int taskId);
    public boolean uploadResult(Homework_Result result);
    public Homework_Result readOwnResult(int userId,int taskId);
    public boolean changeData(User user);
}