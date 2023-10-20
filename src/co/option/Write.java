package co.option;

import co.stockmanagmnet.StockManagement;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.*;

public class Write {
    static List<StockManagement> stockManagementArrayList = new ArrayList<>();
    static StockManagement stockManagement = new StockManagement();
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void writeFunction() {
        int randomNumber = random.nextInt(100) + 1;
        stockManagement.setDate(LocalDate.now());
        Integer proID = stockManagement.setId(randomNumber);
        System.out.println("Product ID : " + proID);
        System.out.print("Product's name : ");
        String proName = stockManagement.setName(scanner.next());
        System.out.print("Product's Price : ");
        Double proPrice = stockManagement.setUnitPrice(scanner.nextDouble());
        System.out.print("Product's Qty : ");
        Integer proQty = stockManagement. setQty(scanner.nextInt());
        addItem(new StockManagement(proID, proName, proPrice, proQty, LocalDate.now()));
        Table table = getTable();
        System.out.println(table.render());
        System.out.print("Are you sure want to add this record? [Y/y] or [N/n]: ");
        String userInput = scanner.next();
        if (userInput.equals("Y") || Objects.equals(userInput, "y")) {
            System.out.println("~".repeat(30));
            System.out.println(stockManagement.getId() + " was added sucessfully ");
            System.out.println("~".repeat(30));
        } else if (userInput.equals("N") || Objects.equals(userInput, "n")) {
            removeItem(stockManagement);
            System.out.println("Product is not added");
        }
    }

    public static Table getTable() {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
        table.addCell("ID" + " ".repeat(20) + ": " + stockManagement.getId());
        table.addCell("Name" + " ".repeat(18) + ": " + stockManagement.getName());
        table.addCell("Unit Price" + " ".repeat(12) + ": " + stockManagement.getUnitPrice());
        table.addCell("Qty" + " ".repeat(19) + ": " + stockManagement.getQty());
        table.addCell("Imported Date" + " ".repeat(9) + ": " + stockManagement.getDate());
        return table;
    }

    public static void addItem(StockManagement stockManagement) {
        stockManagementArrayList.add(stockManagement);
    }

    public static void removeItem(StockManagement stockManagement) {
        stockManagementArrayList.remove(stockManagement);
    }
}


