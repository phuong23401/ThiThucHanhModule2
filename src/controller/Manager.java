package controller;

import model.Directory;
import storage.IOFile;
import view.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final List<Directory> DIRECTORY_LIST = new ArrayList<>();

    static {
        Directory d1 = new Directory("0966666666", "C0221I1", "Phuongdz", "Nam", "HN", "23/04/01", "hoaphuong23401@gmail.com");
        Directory d2 = new Directory("0988888888", "C0221I1", "Hadz", "Nam", "HN", "xx/xx/97", "hadz123@gmail.com");
        Directory d3 = new Directory("0977777777", "C0221I1", "Khanhdz", "Nam", "HN", "xx/xx/93", "khanhdz123@gmail.com");
        DIRECTORY_LIST.add(d1);
        DIRECTORY_LIST.add(d2);
        DIRECTORY_LIST.add(d3);
    }

    public void show() {
        for (Directory directory : DIRECTORY_LIST) {
            System.out.println(directory.toString());
        }
    }

    public void add() {
        while (true) {
            String phoneNum = inputPhoneNum();
            if (!validatePhone(phoneNum)) {
                System.out.println("Số điện thoại không đúng định dạng!");
            } else {
                String group = inputGroup();
                String name = inputName();
                String gender = inputGender();
                String address = inputAddress();
                String birth = inputBirth();
                while (true) {
                    String email = inputEmail();
                    if (!validateEmail(email)) {
                        System.out.println("Email không đúng định dạng!");
                    } else {
                        Directory directory = new Directory(phoneNum, group, name, gender, address, birth, email);
                        DIRECTORY_LIST.add(directory);
                        System.out.println("Đã thêm thông tin vào danh bạ!");
                        break;
                    }
                }
                break;
            }
        }
        IOFile.writeDirectoryList();
    }

    public void edit(String phone) {
        Directory directory = getDirectoryByPhone(phone);
        if (directory == null) {
            System.out.println("Không tìm thấy danh bạ với số điện thoại trên!");
        } else {
            directory.setGroup(inputGroup());
            directory.setName(inputName());
            directory.setGender(inputGender());
            directory.setAddress(inputAddress());
            directory.setBitrh(inputBirth());
            while (true) {
                directory.setEmail(inputEmail());
                if (!validateEmail(directory.getEmail())) {
                    System.out.println("Email không đúng định dạng!");
                } else {
                    System.out.println("Đã sửa thông tin danh bạ!");
                    break;
                }
            }
        }
    }

    public void delete(String phone) {
        Directory directory = getDirectoryByPhone(phone);
        if (directory == null) {
            System.out.println("Không tìm thấy danh bạ với số điện thoại trên!");
        } else {
            System.out.print("Nhập 'Y' để xác nhận xóa danh bạ: ");
            String choose = SCANNER.nextLine();
            switch (choose) {
                case "Y":
                    DIRECTORY_LIST.remove(directory);
                    System.out.println("Đã xóa danh bạ!");
                    Main.showMenu();
                    break;
                default:
                    System.out.println("Vui lòng chọn 'Y' để xóa!");
            }
        }
    }

    public void searchByName(String name) {
        Directory directory = getDirectoryByName(name);
        if (directory == null) {
            System.out.println("Không tìm thấy danh bạ với tên trên!");
        } else {
            System.out.println(directory);
        }
    }

    public void searchByPhoneNum(String phone) {
        Directory directory = getDirectoryByPhone(phone);
        if (directory == null) {
            System.out.println("Không tìm thấy danh bạ với số điện thoại trên!");
        } else {
            System.out.println(directory);
        }
    }

    public Directory getDirectoryByPhone(String phone) {
        Directory directory = null;
        for (Directory directory1 : DIRECTORY_LIST) {
            if (directory1.getPhoneNum().equals(phone)) {
                directory = directory1;
            }
        }
        return directory;
    }

    public Directory getDirectoryByName(String name) {
        Directory directory = null;
        for (Directory directory1 : DIRECTORY_LIST) {
            if (directory1.getName().equals(name)) {
                directory = directory1;
            }
        }
        return directory;
    }

    public boolean validateEmail(String regex) {
        String email_regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z]+(\\.[A-Za-z]+)$";
        Pattern pattern = Pattern.compile(email_regex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePhone(String regex) {
        String phone_regex = "^(\\+84|0[3|5|7|8|9])+([0-9]{8})$";
        Pattern pattern = Pattern.compile(phone_regex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public String inputPhoneNum() {
        System.out.print("Mời nhập số điện thoại (+84xxxxxxxx hoặc 0xxxxxxxxx): ");
        return SCANNER.nextLine();
    }

    public String inputGroup() {
        System.out.print("Mời nhập nhóm: ");
        return SCANNER.nextLine();
    }

    public String inputName() {
        System.out.print("Mời nhập tên: ");
        return SCANNER.nextLine();
    }

    public String inputGender() {
        System.out.print("Mời nhập giới tính (1-Nam/ 2-Nữ/ 0-Khác): ");
        String gender = null;
        String choose = SCANNER.nextLine();

        switch (choose) {
            case "1":
                gender = "Nam";
                break;
            case "2":
                gender = "Nữ";
                break;
            case "0":
                System.out.println("Mời nhập giới tính: ");
                gender = SCANNER.nextLine();
                break;
            default:
                System.out.println("Vui lòng chọn chức năng trong menu!");
                break;
        }
        return gender;
    }

    public String inputAddress() {
        System.out.print("Mời nhập địa chỉ: ");
        return SCANNER.nextLine();
    }

    public String inputBirth() {
        System.out.print("Mời nhập ngày sinh: ");
        return SCANNER.nextLine();
    }

    public String inputEmail() {
        System.out.print("Mời nhập email (xxx123@xxx.xxx): ");
        return SCANNER.nextLine();
    }
}
