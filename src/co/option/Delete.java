package co.option;

import co.stockmanagmnet.StockManagement;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.Scanner;

public class Delete {
    public static void deleteFunction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID of the product you want to delete: ");
        Integer inputId = Integer.parseInt(sc.nextLine());
        for (StockManagement stockManagement : Write.stockManagementArrayList) {
            if (stockManagement.getId().equals(inputId)) {
                Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                table.addCell(" ID            : " + stockManagement.getId() + " ".repeat(10));
                table.addCell(" Name          : " + stockManagement.getName() + " ".repeat(10));
                table.addCell(" Unit price    : " + stockManagement.getUnitPrice() + " ".repeat(10));
                table.addCell(" Qty           : " + stockManagement.getQty() + " ".repeat(10));
                table.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                System.out.println(table.render());
                System.out.print("Are you sure to add this record? [Y/y] or [N/n] : ");
                String options = sc.nextLine();
                switch (options) {
                    case "y", "Y" -> {
                        Write.stockManagementArrayList.remove(stockManagement);
                        System.out.println("Product with ID " + inputId + " deleted successfully.");
                        return;
                    }
                    case "n", "N" -> {
                        System.out.println("Product is not deleted");
                        return;
                    }
                    default -> System.out.println("Invalid options");
                }
            }
        }
    }
}
