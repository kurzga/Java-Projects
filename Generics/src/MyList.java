public class MyList<T> {
    Object[] mylist;
    int size;

    public MyList(int capacity) {
        mylist = new Object[capacity];
        size = 0;
    }

    public void add(T value) {
        if (size < mylist.length) {
            mylist[size] = value;
            size++;
        } else {
            System.out.println("Dizi kapasitesi aşıldı.");
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) mylist[index];
        } else {
            throw new IndexOutOfBoundsException("Geçersiz index");
        }
    }
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                mylist[i] = mylist[i + 1];
            }
            mylist[size - 1] = null;
            size--;
        } else {
            System.out.println("Geçersiz index");
        }
    }
}
