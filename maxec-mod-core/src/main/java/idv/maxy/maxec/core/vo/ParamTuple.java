package idv.maxy.maxec.core.vo;

public class ParamTuple extends Tuple<String, Object> {
	
	public ParamTuple(String k, Object o) {
		super(k,o);
	}
	
	public static ParamTuple param(String v1, Object v2) {
		return new ParamTuple(v1, v2);
	}
}
