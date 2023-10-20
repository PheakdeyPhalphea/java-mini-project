package co.option;

import co.stockmanagmnet.StockManagement;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class Read {
    static Scanner sc = new Scanner(System.in);

    public static void readFunction() {
        System.out.print("Read by ID: ");
        Integer userInput = Integer.parseInt(sc.next());
        for (StockManagement stockManagement : Write.stockManagementArrayList) {
            if (userInput.equals(stockManagement.getId())) {
                Table table = getTable(stockManagement);
                System.out.println(table.render());
            } else {
                System.out.println("~".repeat(10));
                System.out.println("ID : " + userInput + " is not found! ");
                System.out.println("~".repeat(10));
            }
        }
    }

    private static Table getTable(StockManagement stockManagement) {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
        table.addCell("ID" + " ".repeat(20) + ": " + stockManagement.getId());
        table.addCell("Name" + " ".repeat(18) + ": " + stockManagement.getName());
        table.addCell("Unit Price" + " ".repeat(12) + ": " + stockManagement.getUnitPrice());
        table.addCell("Qty" + " ".repeat(19) + ": " + stockManagement.getQty());
        table.addCell("Imported Date" + " ".repeat(9) + ": " + stockManagement.getDate());
        return table;
    }
}
