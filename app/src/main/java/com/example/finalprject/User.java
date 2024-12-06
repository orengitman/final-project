package com.example.finalprject;

import androidx.annotation.NonNull;

public class User {

        private String password;
        private String userName;
        private String Email;

        public User(String password, String name, String email) {
            this.password = password;
            this.userName = name;
            this.Email = email;
        }

        public String getPassword() {
            return password;
        }

        public String getUserName() {
            return userName;
        }

        public String getEmail() {
            return Email;
        }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}








