package pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.t_id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.t_username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.t_password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.t_autority
     *
     * @mbg.generated
     */
    private Integer autority;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.t_id
     *
     * @return the value of USER.t_id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.t_id
     *
     * @param id the value for USER.t_id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.t_username
     *
     * @return the value of USER.t_username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.t_username
     *
     * @param username the value for USER.t_username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.t_password
     *
     * @return the value of USER.t_password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.t_password
     *
     * @param password the value for USER.t_password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.t_autority
     *
     * @return the value of USER.t_autority
     *
     * @mbg.generated
     */
    public Integer getAutority() {
        return autority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.t_autority
     *
     * @param autority the value for USER.t_autority
     *
     * @mbg.generated
     */
    public void setAutority(Integer autority) {
        this.autority = autority;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", autority=" + autority +
                '}';
    }
}