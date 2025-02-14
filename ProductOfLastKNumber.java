import java.util.*;

class ProductOfNumbers {
    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Initialize with 1 for easier calculations
    }
    
    public void add(int num) {
        if (num == 0) {
            // Reset the prefixProducts list when a zero is encountered
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            // Append new product to the list
            prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefixProducts.size();
        if (k >= size) {
            return 0; // If k extends beyond the last zero reset, product is zero
        }
        return prefixProducts.get(size - 1) / prefixProducts.get(size - 1 - k);
    }
}
