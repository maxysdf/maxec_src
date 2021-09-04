package idv.maxy.maxec.core.vo;

import java.util.ArrayList;
import java.util.List;

public class ParamTuples {
	private List<ParamTuple> tuples = new ArrayList<>();
	
	public static ParamTuples create() { return new ParamTuples(); }
	
	public ParamTuples add(String k, Object o) {
		tuples.add(new ParamTuple(k, o));
		return this;
	}
	
	public ParamTuples addIf(String k, Object o, boolean cond) {
		if(cond) { tuples.add(new ParamTuple(k, o)); }
		return this;
	}
	
	public List<ParamTuple> build() {
		return tuples;
	}
	
}
