package app.Model;

public class List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    transient Object[] elementData;
    private final boolean fixed_size;
    private int size;

    public List(int initialCapacity, boolean fixed_size) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        elementData = new Object[initialCapacity];
        this.fixed_size = fixed_size;
        if (fixed_size) {
            for (int i = 0; i < initialCapacity; i++)
                elementData[i] = null;
            size = initialCapacity;
        }
    }

    public List(int initialCapacity) {
        this(initialCapacity, false);
    }

    public List() {
        this.fixed_size = false;
        this.elementData = EMPTY_ELEMENT_DATA;
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);

        Object[] tmp = new Object[newCapacity];
        for (int i = 0; i < elementData.length; i++)
            tmp[i] = elementData[i];
        elementData = tmp;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    public boolean sort(java.util.Comparator<E> cmp) {
        boolean is_swapped = false;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size - 1; j++) {
                if (cmp.compare((E) elementData[j], (E) elementData[j + 1]) > 0) {
                    is_swapped = true;
                    Object swap = elementData[j];
                    elementData[j] = elementData[j + 1];
                    elementData[j + 1] = swap;
                }
            }
            if (!is_swapped)
                return false;
        }
        return true;
    }

    public boolean add(E e) {
        if (fixed_size)
            return false;
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    public void add(int index, E element) {
        if (fixed_size)
            return;
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    public Object[] toArray() {
        Object[] tmp = new Object[size];
        for (int i = 0; i < tmp.length; i++)
            tmp[i] = elementData[i];
        return tmp;
    }

    public E remove(int index) {
        rangeCheck(index);
        E oldValue = elementData(index);
        if (fixed_size) {
            elementData[index] = null;
            return oldValue;
        }
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--size] = null;
        return oldValue;
    }

    public boolean remove(Object o) {
        if (fixed_size && o == null)
            return false;
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    public int removeAll(Object o) {
        int count = 0;
        while (remove(o))
            count++;
        return count;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == EMPTY_ELEMENT_DATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private void fastRemove(int index) {
        if (fixed_size) {
            elementData[index] = null;
            return;
        }
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--size] = null;
    }
}