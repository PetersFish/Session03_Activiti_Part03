package mapper;

import pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated
     */
    int insertSelective(User record);

    /**
     * added by my self
     * @param user
     * @return
     */
    List<User> selectUserByAttribute(User user);
}