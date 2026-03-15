package Validator;

import java.time.LocalDate;
import java.util.Scanner;

public class InputValidator {

    private static Scanner sc = new Scanner(System.in);

    public static int inputInt() {

        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (Exception e) {
                System.out.println("Lỗi: phải nhập số nguyên!");
            }
        }

    }

    public static double inputDouble() {

        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine());
                return value;
            } catch (Exception e) {
                System.out.println("Lỗi: phải nhập số!");
            }
        }

    }

    public static String inputString() {

        while (true) {
            String value = sc.nextLine();

            if (!value.trim().isEmpty()) {
                return value;
            }

            System.out.println("Không được để trống!");
        }

    }
    public static LocalDate inputDate() {
        LocalDate date;

        while (true) {

            try {
                System.out.print("Nhập ngày (yyyy-MM-dd): ");
                date = LocalDate.parse(sc.nextLine());
                return date;

            } catch (Exception e) {
                System.out.println("Sai định dạng ngày!");
            }

        }
    }
}
