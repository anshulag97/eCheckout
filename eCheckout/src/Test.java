import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;	

import com.bo.ProductBO;
import com.dao.ProductDAO;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{
		File file = new File("/home/unparallel_ag/eCheckoutImages/image1");
		InputStream in = new FileInputStream(file);

		String productId = "CBC778";
		String productName = "Carpet1";
		String material = "RandMat";
		String collection = "New";
		double length = 90;
		double width = 45;
		String colour = "Red";
		String description = "Best";
		InputStream image =in;
		double price=100;
		
		ProductBO product = new ProductBO(productId, productName, material, collection, length, width, colour, description, price, image);
		System.out.println(product);
		ProductDAO.addProduct(product);
		
		ProductDAO.viewAllProducts();
		
		in.close();
	}
}
