package utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TablePrinter {

    public static void printProductTable(ResultSet rs) throws SQLException {

        System.out.printf("%-5s %-20s %-15s %-10s %-10s\n",
                "ID", "NAME", "BRAND", "PRICE", "STOCK");

        while (rs.next()) {

            System.out.printf("%-5d %-20s %-15s %-10.2f %-10d\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("brand"),
                    rs.getDouble("price"),
                    rs.getInt("stock"));
        }
    }

    public static void printCustomerTable(ResultSet rs) throws SQLException {

        System.out.printf("%-5s %-20s %-15s %-25s %-20s\n",
                "ID","NAME","PHONE","EMAIL","ADDRESS");

        while(rs.next()){

            System.out.printf("%-5d %-20s %-15s %-25s %-20s\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
            );
        }
    }

    public static void printRevenumTable(ResultSet rs) throws SQLException {

        try {

            ResultSetMetaData meta = rs.getMetaData();

            int columnCount = meta.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-20s", meta.getColumnName(i));
            }

            System.out.println();
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }

                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInvoiceTable(ResultSet rs) {

        try {

            System.out.printf("%-5s %-20s %-31s %-18s\n",
                    "ID", "Customer", "Date", "Total");

            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {

                String customer = rs.getString("name");
                if (customer.length() > 18) {
                    customer = customer.substring(0, 18);
                }

                String date = rs.getTimestamp("created_at")
                        .toLocalDateTime()
                        .toString();

                System.out.printf("%-5d %-20s %-31s %-18.2f\n",
                        rs.getInt("id"),
                        customer,
                        date,
                        rs.getDouble("total_amount")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInvoiceDetailTable(ResultSet rs) {

        try {

            System.out.printf("%-5s %-10s %-10s %-10s %-10s\n",
                    "ID", "InvoiceID", "ProductID", "Qty", "unit_price");

            System.out.println("-----------------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-5d %-10d %-10d %-10d %-10.2f\n",
                        rs.getInt("id"),
                        rs.getInt("invoice_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
