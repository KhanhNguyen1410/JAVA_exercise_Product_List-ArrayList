package manager;

import java.util.List;

public interface MyManager<T> {
    void add (T o);
    void edit(T o);
    void delete(int id);
    T findById(int id);
    T findByName(String Name);
    List<T> showAll();
    boolean isExisted(int id);
}
