package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String ID;
	private ArrayList<Double> ratings;
	private ArrayList<Pair> AllSim;
		
	
	public Product(String id) {
		this.ID=id;
		ratings=new ArrayList<>();
		AllSim=new ArrayList<>();
	}
	
	public int getTotal(){
		return this.ratings.size();
	}
	
	public String GetID() {
		return this.ID;
	}
	public ArrayList<Pair> getAllSim(){
		return AllSim;
	}
	
	public void AddPair(String ID,Double sim) {
		AllSim.add(new Pair(ID, sim));
	}

	public void InsertRating(String rate) {
		int Number = Integer.parseInt(rate);
		ratings.add((double) Number);
	}
	
	public ArrayList<Double> getRating(){
		return this.ratings;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}


	
	
	
	
	
}
