package manager;

import model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManager implements MyManager<Product> {

    static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Cafe", 30.5));
        products.add(new Product(2, "Coca", 20));
        products.add(new Product(3, "Pepsi", 22.3));
        products.add(new Product(4, "Soda", 18.6));
    }

    @Override
    public void add(Product object) {
        if (!isExisted(object.getId()))
        products.add(object);
        System.out.println("ID is existed, plz use edit product");
    }

    @Override
    public void edit(Product newProduct) {
        if (isExisted(newProduct.getId())) {
            for (int i = 0; i < products.size(); i++) {
                if (newProduct.getId() == products.get(i).getId()) {
                    products.set(i, newProduct);
                }
            }
        } else {
            System.out.printf("There are no products with ID '%d' in the list", newProduct.getId());
            System.out.println();
        }
    }

    @Override
    public void delete(int id) {
        if (isExisted(id)){
            for (int i = 0; i < products.size(); i++) {
                if (id == products.get(i).getId()){
                    products.remove(i);
                }
            }
        }
        else {
            System.out.println("there are no products in the list ");
        }
    }

    @Override
    public Product findById(int id) {
        if (isExisted(id)) {
            for (int i = 0; i < products.size(); i++) {
                if (id == products.get(i).getId()) {
                    return products.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String Name) {
        List<Product> nameList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if ( products.get(i).getName().equals(Name)){
               nameList.add(products.get(i));
            }
        }
        return nameList;
    }

    @Override
    public List<Product> showAll() {
        List<Product> productList = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            productList.add(iterator.next());
        }
        return productList;
    }

    @Override
    public boolean isExisted(int id) {
        for (Product product: products){
            if (id == product.getId()){
                return true;
            }
        }
        return false;
    }
}
