import manager.ProductManager;
import model.Product;

import java.util.*;

public class Main {
    static void display(List list) {
        Iterator<Product> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        List<Product> productList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choose= -1;

        while (choose!=0){
        System.out.println("Menu: ");
        System.out.println("1: add a newProduct");
        System.out.println("2: edit a Product");
        System.out.println("3: delete a Product");
        System.out.println("4: find a Product by ID");
        System.out.println("5: find a Product by Name");
        System.out.println("6: Sort by price increment");
//        System.out.println("7: Sort by descending price");
        System.out.println("0: exit");

        System.out.println("enter your choose: ");
         choose = input.nextInt();


        switch (choose) {
            case 1:
                System.out.print("enter a ID: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.print("enter a Name: ");
                String name = input.nextLine();
                System.out.print("enter a Price: ");
                double price = input.nextDouble();
                Product newProduct = new Product(id, name, price);
                productManager.add(newProduct);
                productList = productManager.showAll();
                display(productList);
                break;
            case 2:
                System.out.print("enter a ID: ");
                int idEdit = input.nextInt();
                input.nextLine();
                System.out.print("enter a Name: ");
                String nameEdit = input.nextLine();
                System.out.print("enter a Price: ");
                double priceEdit = input.nextDouble();
                Product editProduct = new Product(idEdit, nameEdit, priceEdit);
                productManager.edit(editProduct);
                productList = productManager.showAll();
                display(productList);
                break;
            case 3:
                System.out.print("enter a ID: ");
                int idDel = input.nextInt();
                productManager.delete(idDel);
                productList = productManager.showAll();
                display(productList);
                break;
            case 4:
                System.out.print("enter a ID: ");
                int idFind = input.nextInt();
                System.out.println(productManager.findById(idFind));
                break;
            case 5:
                System.out.print("enter a Name: ");
                String nameFind = input.nextLine();
                System.out.println(productManager.findByName(nameFind));
                break;
            case 6:
                productList = productManager.showAll();
                Collections.sort(productList);
                display(productList);
                break;
            case 0:
                System.exit(0);
        }
        }
        System.out.println("________________________");
    }
}
