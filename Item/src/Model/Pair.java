package Model;

import java.io.Serializable;

public class Pair implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String ID;
	Double sim;
	
	public Pair(String id, Double sim) {
		this.ID=id;
		this.sim=sim;
	}
	
	public String getID() {
		return this.ID;
	}

	public Double GetSim() {
		return this.sim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sim == null) ? 0 : sim.hashCode());
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
		Pair other = (Pair) obj;
		if (sim == null) {
			if (other.sim != null)
				return false;
		} else if (!sim.equals(other.sim))
			return false;
		return true;
	}


}
