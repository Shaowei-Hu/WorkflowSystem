package com.shaowei.workflow.util;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * <a href="OrderedProperties.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrderedProperties extends Properties {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7570077919181232216L;
	
    private Vector<Object> _names;

	public OrderedProperties() {
        super ();

        _names = new Vector<>();
    }

    public Enumeration<?> propertyNames() {
        return _names.elements();
    }

    public Object put(Object key, Object value) {
        if (_names.contains(key)) {
            _names.remove(key);
        }

        _names.add(key);

        return super .put(key, value);
    }

    public Object remove(Object key) {
        _names.remove(key);

        return super .remove(key);
    }



}
