package Control;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import View.LoginFrame;
import Model.Pair;
import Model.Product;
import utils.MyFileLogWriter;

public class Main {

	private static ArrayList<Product> Products;
	private static DataHandler Data;
	private static Main instance;
//	public static void main(String[] args) {
//		
//		Data = new DataHandler();
//		Data.ImportData();
//		Products = Data.getProducts();
//		Calculate();
//		TopProducts();
//		for(Product p : Products) {
//			System.out.println(p.getAllSim().get(0).GetSim());
//		}
//		Data.ExportData();
//		
//	}
//	
	public Main(String file){
		Data = new DataHandler();
		Data.setStaticSelectedFile(file);
		Data.ImportData();
		Products = Data.getProducts();
		Calculate();
		TopProducts();
		for(Product p : Products) {
			System.out.println(p.getAllSim().get(0).GetSim());
		}
		Data.ExportData(topSoldProducts());
		
	}
	
	public static void main(String[] args) {
		Data = new DataHandler();
		
		
		LoginFrame frm = new LoginFrame();
		frm.setVisible(true);
	}
	
	
	private static void TopProducts() {
		for(Product p : Products) {
			Collections.sort(p.getAllSim(), new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					return o1.GetSim().compareTo(o2.GetSim());
				}
			});
		}
	}
	
	private static ArrayList<Product> topSoldProducts(){
		ArrayList<Product> SProd = new ArrayList<Product>();
		int temp = 0;
		Product prod = null;
		for (int i = 0; i < 3; i++) {
			for (Product p : Products) {
				if (p.getTotal() > temp && !SProd.contains(p)) {
					temp = p.getTotal();
					prod = p;
				}
			}

			if (!SProd.contains(prod)) {
				SProd.add(prod);
			}

			temp = 0;
		}
		return SProd;
	}
	
	private static void Calculate() {
		
		int sum=0;
		double Multiple=0;
		double FirstProduct=0,SecondProduct=0;
		double down=0;
		double total =0;
		for(int i=0 ; i < Products.size() ; i++ ) {
			
			for(int j=0; j < Products.size();j++) {
			
				if(i!=j) {
					
					if(!Products.get(i).getRating().isEmpty() || !Products.get(j).getRating().isEmpty()) {
						
						if(Products.get(i).getRating().size() <= Products.get(j).getRating().size()) {
							sum = Products.get(i).getRating().size();
						}else {
							sum = Products.get(j).getRating().size();
						}
					
						for(int k =0 ; k < sum ; k++) {
							Multiple = Multiple + Products.get(i).getRating().get(k)*Products.get(j).getRating().get(k);
							System.out.println();
							FirstProduct = FirstProduct + Math.pow(Products.get(i).getRating().get(k), 2);
							SecondProduct = SecondProduct + Math.pow(Products.get(j).getRating().get(k), 2);

							
						}
						FirstProduct = Math.sqrt(FirstProduct);
						SecondProduct = Math.sqrt(SecondProduct);
						down = FirstProduct*SecondProduct;
						total = Multiple/down;
						Products.get(i).getAllSim().add(new Pair(Products.get(j).GetID(), total));
						
					
						Multiple =0;
						FirstProduct =0;
						SecondProduct=0;
						down =0 ;
						total =0;
					}
				}
			}
			
		}
	}

}
