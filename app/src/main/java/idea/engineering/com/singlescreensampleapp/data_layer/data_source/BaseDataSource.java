package idea.engineering.com.singlescreensampleapp.data_layer.data_source;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class BaseDataSource<T> {

    protected T data;

    private List<DataSourceListener> listeners = new CopyOnWriteArrayList<>();

    public abstract void reloadData();

    public void addListener(DataSourceListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @SuppressWarnings("unused")
    public void removeListener(DataSourceListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public void notifyListenersDidLoadItems() {
        for (DataSourceListener listener : listeners) {
            listener.notifyDidLoadItems(data);
        }
    }

    void notifyListenersWillLoadItems() {
        for (DataSourceListener listener : listeners) {
            listener.notifyWillLoadItems();
        }
    }

    void notifyListenersDidLoadItemsWithError(String error) {
        for (DataSourceListener listener : listeners) {
            listener.notifyDidLoadItemsWithError(error);
        }
    }

    public interface DataSourceListener<T> {
        void notifyWillLoadItems();

        void notifyDidLoadItems(T data);

        void notifyDidLoadItemsWithError(String error);
    }
}
