package com.deliveredtechnologies.rulebook;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A decorator for NameValueReferableMap that adds common type conversions.
 * @param <T> the type of objects contained in the NameValueReferable objects
 */
public class TypeConvertibleFactMap<T> implements NameValueReferableTypeConvertibleMap<T> {

  NameValueReferableMap<T> _map;

  public TypeConvertibleFactMap(NameValueReferableMap<T> map) {
    _map = map;
  }

  @Override
  public String getStrVal(String name) {
    if (getValue(name) instanceof String) {
      return (String)getValue(name);
    }
    return String.valueOf(getValue(name));
  }

  @Override
  public T getOne() {
    return _map.getOne();
  }

  @Override
  public T getValue(String name) {
    return _map.getValue(name);
  }

  @Override
  public Integer getIntVal(String name) {
    Object value = getValue(name);
    if (value != null) {
      if (Integer.class == value.getClass()) {
        return (Integer)value;
      }
      if (value.getClass() == String.class) {
        return Integer.valueOf((String) value);
      }
    }
    return null;
  }

  @Override
  public void setValue(String name, T obj) {
    _map.setValue(name, obj);
  }

  @Override
  public Double getDblVal(String name) {
    Object value = getValue(name);
    if (value != null) {
      if (Float.class == value.getClass()) {
        return Double.valueOf((Float) value);
      }
      if (Double.class == value.getClass()) {
        return (Double)value;
      }
      if (Integer.class == value.getClass()) {
        return Double.valueOf((Integer) value);
      }
      if (Long.class == value.getClass()) {
        return Double.valueOf((Long) value);
      }
      if (String.class == value.getClass()) {
        return Double.parseDouble((String)value);
      }
    }
    return null;
  }

  @Override
  public int size() {
    return _map.size();
  }

  @Override
  public boolean isEmpty() {
    return _map.isEmpty();
  }

  @Override
  public boolean containsKey(Object key) {
    return _map.containsKey(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return _map.containsValue(value);
  }

  @Override
  public NameValueReferable<T> get(Object key) {
    return _map.get(key);
  }

  @Override
  public NameValueReferable<T> put(NameValueReferable<T> ref) {
    return _map.put(ref);
  }

  @Override
  public NameValueReferable<T> put(String key, NameValueReferable<T> value) {
    return _map.put(key, value);
  }

  @Override
  public NameValueReferable<T> remove(Object key) {
    return _map.remove(key);
  }

  @Override
  public void putAll(Map<? extends String, ? extends NameValueReferable<T>> map) {
    _map.putAll(map);
  }

  @Override
  public void clear() {
    _map.clear();
  }

  @Override
  public Set<String> keySet() {
    return _map.keySet();
  }

  @Override
  public Collection<NameValueReferable<T>> values() {
    return _map.values();
  }

  @Override
  public Set<Entry<String, NameValueReferable<T>>> entrySet() {
    return _map.entrySet();
  }
}
