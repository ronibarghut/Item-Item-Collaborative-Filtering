package Control;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
 
import Model.Product;
import au.com.bytecode.opencsv.CSVReader;

public class DataHandler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Product> AllProduct;
	private static DataHandler instance;
	public String StaticSelectedFile = null; 

	public void setStaticSelectedFile(String staticSelectedFile) {
		StaticSelectedFile = staticSelectedFile;
	}

	public DataHandler() {
		AllProduct = new ArrayList<>();
	}
	
	public static DataHandler getInstance() {
		if (instance == null) {
				instance = new DataHandler();
		}
		return instance;
	} 
	
	public void ImportData() {
		CSVReader  reader = null;
		int lineCounter = 0;
		try {
			reader = new CSVReader(new FileReader(StaticSelectedFile));
			String[] line;
			reader.readNext();
			while ((line = reader.readNext()) != null) {
				if(Integer.parseInt(line[7])!=0) {
					
					if(!AllProduct.contains(new Product(line[1]))) {
						Product p = new Product(line[1]);
						p.InsertRating(line[7]);
						AllProduct.add(p);
					}else {
						int counter=0;
						for(Product p : AllProduct) {
							if(!p.equals(new Product(line[1]))) {
								counter++;
							}
						}
						AllProduct.get(counter).InsertRating(line[7]);
					
					}
					
				}
			
				
			}
			
		} catch(Exception e1) {
			
			System.out.println(e1.getMessage());
			System.out.println("Fail");
		}finally {
			try {
				reader.close();
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
				System.out.println("Fail");
				
			}
		}

	}
	
	public void ExportData(ArrayList<Product> topProd) {
		PrintWriter pw =null;
		int count = 0;
		try {
			pw = new PrintWriter(new File("ItemsList.csv"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		
		builder.append("productID");
		builder.append(',');
		builder.append("relatedOne");
		builder.append(',');
		builder.append("relatedTwo");
		builder.append(',');
		builder.append("relatedThree");
		builder.append('\n');
		
		for(Product p : AllProduct) {
			count = 0;
			builder.append(p.GetID());
			
			for(int i =0 ;  i < 3 ; i++ ) {
				
				if(p.getAllSim().size() > i) {
					
					builder.append(',');
					builder.append(p.getAllSim().get(i).getID());
				}else {
					
					builder.append(',');
					builder.append(topProd.get(count).GetID());
					if(topProd.size()>count){
					count++;
					}
				}
			}	
			
			builder.append('\n');
			
		}
		
		pw.write(builder.toString());
		pw.close();
		

		
	}
	
	
	public ArrayList<Product> getProducts(){
		return AllProduct;
	}
	
	
}
