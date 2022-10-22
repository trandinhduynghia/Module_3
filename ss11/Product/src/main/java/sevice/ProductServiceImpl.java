package sevice;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "heniken", 500, "bia", "heniken"));
        products.put(2, new Product(2, "tiger", 400, "bia", "tiger"));
        products.put(3, new Product(3, "cocacola", 200, "nuoc ngot", "tiger"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
