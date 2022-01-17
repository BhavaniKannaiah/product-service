package com.retail.product.productservice.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import com.retail.product.productservice.entity.CurrentPrice;
import com.retail.product.productservice.entity.Product;
/**
 * Helper class to call the external webservice.
 * @author bhava
 *
 */
public class ProductItemHelper {

	private final static String URL ="https://redsky-uat.perf.target.com/redsky_aggregations/v1/redsky/case_study_v1?key=3yUxt7WltYG7MFKPp7uyELi1K40ad2ys&tcin=";	
	private final static String DATA = "data";
	private final static String PRODUCT = "product";
	private final static String ITEM = "item";
	private final static String PRODUCT_DESCRIPTION = "product_description";
	private final static String TITLE = "title";
	private final static String TCIN ="tcin";
	private final static String USD ="USD";
/**
 * Get the product description from the external webservice.
 * @param productId
 * @return product, product details
 */
	public static Product getProductDescription(String productId) {

		String url = URL+productId;
		JSONObject json = null ;
		JSONObject jsonData = null ;
		JSONObject jsonProduct = null ;
		JSONObject jsonItem = null ;
		JSONObject jsonProductDesription = null ;
		String productTitle = null;
		Product product =new Product();
		String id = null;

		try {
			InputStream is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			json = new JSONObject(jsonText);
			if(json!=null && json.get(DATA) !=null) {
				System.out.println("Json respone from the external System: +"+json.toString());
				jsonData = (JSONObject) json.get(DATA);
			}
			if(jsonData !=null && jsonData.get(PRODUCT)!=null) {
				jsonProduct = (JSONObject) jsonData.get(PRODUCT);
			}
			if(jsonProduct !=null && jsonProduct.get(ITEM)!=null) {
				jsonItem = (JSONObject) jsonProduct.get(ITEM);
			}
			if(jsonItem !=null && jsonItem.get(PRODUCT_DESCRIPTION)!=null) {

				jsonProductDesription = (JSONObject) jsonItem.get(PRODUCT_DESCRIPTION);
			}
			if(jsonProductDesription !=null && jsonProductDesription.get(TITLE)!=null) {

				productTitle = jsonProductDesription.get(TITLE).toString();
				System.out.println("Product Descrition: "+ jsonProductDesription.get(TITLE));
			}

			id = (String)jsonProduct.get(TCIN);
			product.setId(id);
			product.setName(productTitle);
			CurrentPrice currentPrice = new CurrentPrice();
			currentPrice.setCurrencyCode(USD);
			currentPrice.setValue(13.49);
			product.setCurrentPrice(currentPrice);

		} catch (IOException e) {			
			e.printStackTrace();
		}
		return product;

	}
/**
 * Read the json the webservice and convert that to String.
 * @param rd
 * @return String, json object to string 
 * @throws IOException, exception will be thrown if the external webservice fail
 */
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}


	public static void main(String[] args) throws IOException, JSONException {
		Long id = (long) 13860428;
		//String json = getProductDescription(id);
		// System.out.println(json);
		// System.out.println(json.get("id"));
	}
}
