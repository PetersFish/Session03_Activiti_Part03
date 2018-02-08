package pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Leave {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column _LEAVE.l_id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column _LEAVE.l_uid
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column _LEAVE.l_title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column _LEAVE.l_reason
     *
     * @mbg.generated
     */
    private String reason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column _LEAVE.l_days
     *
     * @mbg.generated
     */
    private Integer days;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column _LEAVE.l_status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column _LEAVE.l_id
     *
     * @return the value of _LEAVE.l_id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column _LEAVE.l_id
     *
     * @param id the value for _LEAVE.l_id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column _LEAVE.l_uid
     *
     * @return the value of _LEAVE.l_uid
     *
     * @mbg.generated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column _LEAVE.l_uid
     *
     * @param uid the value for _LEAVE.l_uid
     *
     * @mbg.generated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column _LEAVE.l_title
     *
     * @return the value of _LEAVE.l_title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column _LEAVE.l_title
     *
     * @param title the value for _LEAVE.l_title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column _LEAVE.l_reason
     *
     * @return the value of _LEAVE.l_reason
     *
     * @mbg.generated
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column _LEAVE.l_reason
     *
     * @param reason the value for _LEAVE.l_reason
     *
     * @mbg.generated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column _LEAVE.l_days
     *
     * @return the value of _LEAVE.l_days
     *
     * @mbg.generated
     */
    public Integer getDays() {
        return days;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column _LEAVE.l_days
     *
     * @param days the value for _LEAVE.l_days
     *
     * @mbg.generated
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column _LEAVE.l_status
     *
     * @return the value of _LEAVE.l_status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column _LEAVE.l_status
     *
     * @param status the value for _LEAVE.l_status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}