import java.util.Arrays;
import java.util.Comparator;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product{" + "ID=" + productId + ", Name='" + productName + '\'' + ", Category='" + category + '\'' + '}';
    }
}

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product; 
            }
        }
        return null; 
    }

    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return sortedProducts[mid]; 
            }
            
            if (midId < targetId) {
                left = mid + 1;
            } 
           
            else {
                right = mid - 1;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        
        Product[] inventory = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Coffee Maker", "Home"),
            new Product(109, "Running Shoes", "Apparel"),
            new Product(103, "Mechanical Keyboard", "Electronics"),
            new Product(107, "Desk Lamp", "Home")
        };

        int searchId = 107;

        System.out.println("--- Linear Search ---");
        Product foundLinear = linearSearch(inventory, searchId);
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Product not found"));

        System.out.println("\n--- Binary Search ---");

        Arrays.sort(inventory, Comparator.comparingInt(Product::getProductId));
        
        Product foundBinary = binarySearch(inventory, searchId);
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Product not found"));
    }
}