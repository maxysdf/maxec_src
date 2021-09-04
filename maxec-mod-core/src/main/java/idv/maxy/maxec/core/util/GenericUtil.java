package idv.maxy.maxec.core.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenericUtil {
	private static final Log logger = LogFactory.getLog(GenericUtil.class);
	
    /**
     * 轉型
     * @param obj
     * @param cls
     * @return
     */
	@SuppressWarnings("unchecked")
	public static <T> T cast(Object obj, Class<T> cls) {
		if(obj == null) return null;
		if(!cls.isAssignableFrom(obj.getClass())) return null;
		return (T)obj;
	}
	
	/**
	 * 對應至另一型態之list
	 * @param list
	 * @param f
	 * @return
	 */
	public static <S,T> List<T> map(Collection<S> coll, Function<S, T> f) {
		if(coll == null) { return null; }
		return coll.stream().map(f).collect(Collectors.toList());
	}
	
	/**
	 * 若空回傳預設值
	 * @param t
	 * @param vl
	 * @return
	 */
	public static <T> T nvl(T t, T vl) {
		return t != null ? t : vl;
	}
	
	/**
	 * 是否為子類別 (包含本身)
	 * @param cls
	 * @param clsName
	 * @return
	 */
	public static boolean isSubClass(final Class<?> cls, String clsName) {
		if(cls == null || clsName == null) { return false; }
		
		boolean re = false;
		Class<?> c = cls;
		while(c != null) {
			if(clsName.equals(c.getName())) { re= true; break; }
			c = c.getSuperclass();
		}
		return re;
	}

	/**
	 * 取得物件欄位的getter
	 * @param o
	 * @param flds
	 * @return
	 */
	public static Map<String, Method> getGetters(Class<?> clz, String[] flds) {
		if(clz == null || flds == null || flds.length == 0) { return new LinkedHashMap<>(); }
		
		Map<String, Method> methods = new LinkedHashMap<>();
		try {
	        BeanInfo info = Introspector.getBeanInfo(clz);  
	        
	        PropertyDescriptor[] props = info.getPropertyDescriptors();
	        Map<String, PropertyDescriptor> propMap = new LinkedHashMap<>();
	        for(PropertyDescriptor prop : props) { propMap.put(prop.getName(), prop); }

	        for(String fld : flds) {
	        	PropertyDescriptor prop = propMap.get(fld);
	        	Method m = prop.getReadMethod();
	        	if(m == null) { continue; }
	        	methods.put(fld, m);
	        }
	    } catch (Exception ex)  {
	    	logger.error("get getters failed", ex);
	    }
		return methods;
	}
}
