package org.blumea.cms.web.util;

import com.google.common.base.Joiner;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 */
public class PageData extends ConcurrentHashMap implements Map {

    private static final long serialVersionUID = 5226918731997559284L;

    private final Map paramDataMap = new ConcurrentHashMap();

    private HttpServletRequest request;

    public PageData() {
    }

    public PageData(HttpServletRequest request) {
        this.request = request;
        Map requestParamMap = request.getParameterMap();
        Iterator iter = requestParamMap.entrySet().iterator();

        while (iter.hasNext()) {
            Entry entry = (Entry) iter.next();
            String paramName = (String) entry.getKey();
            Object paramValue = entry.getValue();

            String paramVal;
            if (null == paramValue) {
                paramVal = "";
            } else if (paramValue instanceof String[]) {
                String[] values = (String[]) paramValue;
                paramVal = Joiner.on(",").join(values);
            } else {
                paramVal = paramValue.toString();
            }
            paramDataMap.put(paramName, paramVal);
        }
    }


    @Override
    public Object get(Object key) {
        Object obj;
        if (paramDataMap.get(key) instanceof Object[]) {
            Object[] arr = (Object[]) paramDataMap.get(key);
            obj = arr[0];
        } else {
            obj = paramDataMap.get(key);
        }
        return obj;
    }

    public String getString(Object key) {
        return (String) get(key);
    }

    public Integer getInt(Object key) {
        return Integer.valueOf((String) get(key));
    }

    @Override
    public Object put(Object key, Object value) {
        return paramDataMap.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return paramDataMap.remove(key);
    }

    public void clear() {
        paramDataMap.clear();
    }

    public boolean containsKey(Object key) {
        return paramDataMap.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return paramDataMap.containsValue(value);
    }

    public Set entrySet() {
        return paramDataMap.entrySet();
    }

    public boolean isEmpty() {
        return paramDataMap.isEmpty();
    }

    public Set keySet() {
        return paramDataMap.keySet();
    }

    public void putAll(Map map) {
        paramDataMap.putAll(map);
    }

    public int size() {
        return paramDataMap.size();
    }

    public Collection values() {
        return paramDataMap.values();
    }

}
