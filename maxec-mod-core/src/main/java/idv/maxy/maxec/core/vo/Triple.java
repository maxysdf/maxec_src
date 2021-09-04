package idv.maxy.maxec.core.vo;

/**
 * 
 * @author Max Chen
 *
 * @param <V1>
 * @param <V2>
 */
public class Triple<V1,V2,V3> {
	private V1 v1;
	private V2 v2;
	private V3 v3;
	
	public Triple() {}
	
	public Triple(V1 v1, V2 v2, V3 v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public V1 getV1() {
		return v1;
	}

	public void setV1(V1 v1) {
		this.v1 = v1;
	}

	public V2 getV2() {
		return v2;
	}

	public void setV2(V2 v2) {
		this.v2 = v2;
	}
	
	public V3 getV3() {
		return v3;
	}
	public void setV3(V3 v3) {
		this.v3 = v3;
	}
	
}
