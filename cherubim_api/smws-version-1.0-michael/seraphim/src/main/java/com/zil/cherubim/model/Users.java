package com.zil.cherubim.model;

public class Users {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.email
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.username
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    private String username;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.email
     *
     * @return the value of users.email
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.email
     *
     * @param email the value for users.email
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.username
     *
     * @return the value of users.username
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.username
     *
     * @param username the value for users.username
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}