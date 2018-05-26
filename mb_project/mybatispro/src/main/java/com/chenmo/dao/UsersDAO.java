package com.chenmo.dao;

import com.chenmo.entity.Users;
import com.chenmo.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class UsersDAO {

    private SqlSession sqlSession;
    private List<Users> list;
    private Users user;

    private SqlSession getSession(){
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    /**
     * 查询全部用户
     * @return
     */
    public List<Users> findAll(){
        try {
            list = getSession().selectList("findUsers");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    /**
     * 查询单个用户根据编号
     * @param id
     * @return
     */
    public Users findById(Integer id){
        try {
            user = getSession().selectOne("findUsers",new Users(id));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
           sqlSession.close();
        }
        return user;
    }

    /**
     * 增加一个新用户数据到数据库的方法
     * @return
     */
    public Users  addUser(Users user){
        try {
            //返回值 是insert执行过程中影响的行数
            getSession().insert("addUser",user);
            sqlSession.commit();
        }catch (Exception e){

            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return user;
    }

    /**
     * 用于修改用户资料的方法
     */
    public Users updateUsers(Users user){
        try{
            getSession().update("updateUser",user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return user;
    }


}
