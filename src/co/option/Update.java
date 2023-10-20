package co.option;

import co.WelcomeMenu;
import co.stockmanagmnet.StockManagement;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Objects;
import java.util.Scanner;

public class Update {
    static Scanner sc = new Scanner(System.in);

    public static void updateFunction() {
        System.out.print("Please Input ID of Product : ");
        Integer userInput = Integer.parseInt(sc.next());
        for (StockManagement stockManagement : Write.stockManagementArrayList) {
            if (userInput.equals(stockManagement.getId())) {
                Table table = getTable(stockManagement);
                System.out.println(table.render());
                updateOption.option();
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
class updateOption {
    static Scanner sc = new Scanner(System.in);

    public static void option() {
        System.out.println("What do you want to update?");
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
        table.addCell(" ".repeat(5) + "1. All" + " ".repeat(5));
        table.addCell(" ".repeat(5) + "2. Name" + " ".repeat(5));
        table.addCell(" ".repeat(5) + "3. Quantity" + " ".repeat(5));
        table.addCell(" ".repeat(5) + "4. Unit Price" + " ".repeat(5));
        table.addCell(" ".repeat(5) + "5. Back to Menu" + " ".repeat(5));
        System.out.println(table.render());
        System.out.print("Option (1-5) : ");
        int userOption = Integer.parseInt(sc.next());

        switch (userOption) {
            case 1 -> allOption();
            case 2 -> nameOption();
            case 3 -> quantityOption();
            case 4 -> unitPriceOption();
            case 5 -> backToMenu();
        }
    }

    public static void allOption() {
        System.out.print("Product's name : ");
        String inputProName = sc.next();
        System.out.print("Product's Price : ");
        Double inputProPrice = Double.parseDouble(sc.next());
        System.out.print("Stock Quantity : ");
        Integer inputProQty = Integer.parseInt(sc.next());
        for (StockManagement stockManagement : Write.stockManagementArrayList) {
            stockManagement.setName(inputProName);
            stockManagement.setUnitPrice(inputProPrice);
            stockManagement.setQty(inputProQty);
            System.out.print("Are you sure want to Update this record? [Y/y] or [N/n]: ");
            String userInput = sc.next();
            if (userInput.equals("Y") || Objects.equals(userInput, "y")) {
                System.out.println("~".repeat(30));
                System.out.println(" Product was update ");
                System.out.println("~".repeat(30));
            } else if (userInput.equals("N") || Objects.equals(userInput, "n")) {
                System.out.println("Product Update is cancel");
            }
        }
    }
    public static void nameOption() {
        System.out.print("Product's name : ");
        String inputProName = sc.next();
        for (StockManagement stockManagement : Write.stockManagementArrayList) {
            stockManagement.setName(inputProName);
            Table table = getTable(stockManagement);
            System.out.println(table.render());
            System.out.print("Are you sure want to Update this record? [Y/y] or [N/n]: ");
            String userInput = sc.next();
            if (userInput.equals("Y") || Objects.equals(userInput, "y")) {
                System.out.println("~".repeat(30));
                System.out.println(" Product was update ");
                System.out.println("~".repeat(30));
            } else if (userInput.equals("N") || Objects.equals(userInput, "n")) {
                System.out.println("Product Update is cancel");
            }
        }
    }

    public static void quantityOption() {
        System.out.print("Stock Quantity : ");
        Integer inputProQty = Integer.parseInt(sc.next());
        for (StockManagement stockManagement : Write.stockManagementArrayList) {
            stockManagement.setQty(inputProQty);
            Table table = getTable(stockManagement);
            System.out.println(table.render());
            System.out.print("Are you sure want to Update this record? [Y/y] or [N/n]: ");
            String userInput = sc.next();
            if (userInput.equals("Y") || Objects.equals(userInput, "y")) {
                System.out.println("~".repeat(30));
                System.out.println(" Product was update ");
                System.out.println("~".repeat(30));
            } else if (userInput.equals("N") || Objects.equals(userInput, "n")) {
                System.out.println("Product Update is cancel");
            }
        }
    }

    public static void unitPriceOption() {
        System.out.print("Product's UnitPrice : ");
        Double inputProPrice = Double.parseDouble(sc.next());
        for (StockManagement stockManagement : Write.stockManagementArrayList) {
            stockManagement.setUnitPrice(inputProPrice);
            Table table = getTable(stockManagement);
            System.out.println(table.render());
            System.out.print("Are you sure want to Update this record? [Y/y] or [N/n]: ");
            String userInput = sc.next();
            if (userInput.equals("Y") || Objects.equals(userInput, "y")) {
                System.out.println("~".repeat(30));
                System.out.println(" Product was update ");
                System.out.println("~".repeat(30));
            } else if (userInput.equals("N") || Objects.equals(userInput, "n")) {
                System.out.println("Product Update is cancel");
            }
        }
    }

    public static void backToMenu() {
        WelcomeMenu.welcomeMsg();
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
