package org.mingle.banana.jsp.beans.shopping;

import java.io.*;
import java.util.*;

/**
 * This class represents a shopping cart. It holds a list of products.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月13日
 * @version 1.0
 */
public class CartBean implements Serializable {
	private static final long serialVersionUID = 6814114341098854439L;

	private Vector<ProductBean> cart = new Vector<ProductBean>();

	/**
	 * Adds a product to the cart, if it's not already there.
	 *
	 * @param product
	 *            the ProductBean
	 */
	public void setProduct(ProductBean product) {
		if (product != null && cart.indexOf(product) == -1) {
			cart.addElement(product);
		}
	}

	/**
	 * Returns the product list.
	 *
	 * @return an Iterator of ProductBeans
	 */
	public ProductBean[] getProductList() {
		ProductBean[] products = null;
		synchronized (cart) {
			products = new ProductBean[cart.size()];
			cart.toArray(products);
		}
		return products;
	}

	/**
	 * Returns the total price for all products in the cart
	 *
	 * @return the total price
	 */
	public float getTotal() {
		float total = 0;
		Iterator<ProductBean> prods = cart.iterator();
		while (prods.hasNext()) {
			ProductBean product = (ProductBean) prods.next();
			float price = product.getPrice();
			total += price;
		}
		return total;
	}
}
