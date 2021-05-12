package model;

public class Directory {
    String phoneNum, group, name, gender, address, bitrh, email;

    public Directory(String phoneNum, String group, String name, String gender, String address, String bitrh, String email) {
        this.phoneNum = phoneNum;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.bitrh = bitrh;
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBitrh() {
        return bitrh;
    }

    public void setBitrh(String bitrh) {
        this.bitrh = bitrh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SDT: " + phoneNum +
                ", Nhóm: " + group +
                ", Tên: " + name +
                ", Giới tính: " + gender +
                ", Địa chỉ: " + address;
    }

    public String toString1() {
        return "phoneNum=" + phoneNum +
                ", group='" + group +
                ", name='" + name +
                ", gender='" + gender +
                ", address='" + address +
                ", bitrh='" + bitrh +
                ", email='" + email +
                "\n";
    }


}
