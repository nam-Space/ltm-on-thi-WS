
package WebService.B21DCCN214;

import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.ProductY;

public class ProductYCode {
    public static void main(String[] args) throws Exception{
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        String studentCode = "B21DCCN214", qCode = "XjsfWh7P";
        ProductY product = port.requestProductY(studentCode, qCode);
        System.out.println(product.getPrice() + " " + product.getTaxRate() + " " + product.getDiscount() + " " + product.getFinalPrice());
        float price = product.getPrice();
        float tax = product.getTaxRate();
        float discount = product.getDiscount();
        float finalPrice = price * (1 + tax / 100) * (1 - discount / 100);
        System.out.println(finalPrice);
        product.setFinalPrice(finalPrice);
        port.submitProductY(studentCode, qCode, product);
    }
}
