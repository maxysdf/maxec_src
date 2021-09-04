package idv.maxy.maxec.core.vo;

import java.util.ArrayList;
import java.util.List;

public class Tuples<V1,V2> {
	private List<Tuple<V1,V2>> tuples = new ArrayList<>();
	
	public Tuples<V1,V2> add(V1 v1, V2 v2) {
		tuples.add(new Tuple<>(v1, v2));
		return this;
	}
	
	public List<Tuple<V1, V2>> getTuples() {
		return tuples;
	}
}
