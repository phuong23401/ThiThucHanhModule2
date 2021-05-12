package view;

import controller.Manager;
import storage.IOFile;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Manager PHUONGDZ = new Manager();
    private static String phoneNum;

    public static void showMenu() {
        while (true) {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("0. Thoát");
            System.out.println("Mời nhập chức năng: ");

            String choose = SCANNER.nextLine();
            switch (choose) {
                case "1":
                    PHUONGDZ.show();
                    break;
                case "2":
                    PHUONGDZ.add();
                    break;
                case "3":
                    phoneNum = PHUONGDZ.inputPhoneNum();
                    PHUONGDZ.edit(phoneNum);
                    break;
                case "4":
                    phoneNum = PHUONGDZ.inputPhoneNum();
                    PHUONGDZ.delete(phoneNum);
                    break;
                case "5":
                    menuSearch();
                    break;
                case "6":
                    IOFile.readDirectoryList();
                    break;
                case "7":
                    IOFile.writeDirectoryList();
                    System.out.println("Đã làm mới file!");
                    break;
                case "0":
                    System.out.println("Đã thoát");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn chức năng trong Menu!");
                    break;
            }
        }
    }

    private static void menuSearch() {
        while (true) {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Tìm kiếm bằng số điện thoại");
            System.out.println("2. Tìm kiếm bằng tên");
            System.out.println("0. Thoát");
            System.out.println("Mời nhập chức năng: ");

            String choose = SCANNER.nextLine();
            switch (choose) {
                case "1":
                    phoneNum = PHUONGDZ.inputPhoneNum();
                    PHUONGDZ.searchByPhoneNum(phoneNum);
                    break;
                case "2":
                    String name = PHUONGDZ.inputName();
                    PHUONGDZ.searchByName(name);
                    break;
                case "0":
                    showMenu();
                    break;
                default:
                    System.out.println("Vui lòng chọn chức năng trong Menu!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        showMenu();

    }
}
