/*

public class InternetOrder implements Interfaces.IOrder {

    private int size = 0;

    private Interfaces.IOrder[] orders = new Interfaces.IOrder[]{};

    InternetOrder() {
    }

    
     * Добавляет новый элемент в коллекцию
     *
     * @param item Новая элемент
     * @return true
     
    public boolean add(IItem item) {
        size++;
        IItem[] tempDishes = new IItem[size];
        for (int i = 0; i < items.length; i++)
            tempDishes[i] = items[i];
        tempDishes[size - 1] = item;
        items = tempDishes;
        return true;
    }

    
     * Удаляет позицию из заказа по его названию.
     *
     * @param itemName Название
     * @return Количество удалений
    
    public int removeAll(String itemName) {
        int lastSize = items.length;
        int count = 0;
        for (int i = 0; i < size; i++)
            if (items[i].getName().equals(itemName) == false)
                count++;

        IItem[] tempItems = new IItem[count];
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName) == false) {
                tempItems[currentIndex] = items[i];
                currentIndex++;
            }
        }
        items = tempItems;
        size = items.length;
        return lastSize - size;
    }

    
     * Удаляет название из заказа по его названию.
     *
     * @param itemName Название
     * @return Количество удалений
    
    public boolean remove(String itemName) {
        IItem[] tempItems = new IItem[items.length];
        int remove_pos = -1;
        for (int i = size-1; i >= 0; i--)
            if (items[i].getName().equals(itemName)) {
                remove_pos = i;
                break;
            }
        if (remove_pos == -1)
            return false;
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            if (i == remove_pos)
                continue;
            tempItems[currentIndex] = items[i];
            currentIndex++;
        }
        items = tempItems;
        size = items.length;
        return true;
    }


    
     * Удаляющий все позиции с заданным именем
     *
     * @param itemName Название
     * @return Количество удалений
    
    public int itemQuantityDelete(String itemName) {
        return removeAll(itemName);
    }

    
     * Возвращает общее число позиций заказа (повторяющиеся тоже считаются) в заказе.
     *
     * @return Количество элементов
    
    public int itemQuantity() {
        return items.length;
    }

    
     * Возвращает число заказанных блюд или напитков.
     *
     * @param itemName Название
     * @return Количество элементов с указанным именем
    
    public int itemQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < size; i++)
            if (itemName.equals(items[i].getName()))
                count++;
        return count;
    }

    
     * Возвращает массив заказанных блюд и напитков
     *
     * @return массив элементов
    
    public IItem[] getItems() {
        return items.clone();
    }

    
     * Возвращает общую стоимость заказа.
     *
     * @return Общая стоимость
    
    public double costTotal() {
        double coastAll = 0;
        for (int i = 0; i < items.length; i++) {
            coastAll += items[i].getCost();
        }
        return coastAll;
    }

    
     * Возвращает массив названий заказанных блюд и напитков.
     *
     * @return Список имен
    
    public String[] itemsNames() {
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = items[i].getName();
        }

        return names;
    }

   
     * Возвращает массив позициий заказа, отсортированный по убыванию цены.
     *
     * @return Список элементов, отсортированных по убыванию цены
     
    public IItem[] sortedItemsByCostDescending() {
        IItem temp;
        IItem[] itemsCopy = items.clone();
        for (int i = 0; i < itemsCopy.length; i++) {
            for (int j = i; j < itemsCopy.length - 1; j++) {
                if (itemsCopy[j].getCost() < itemsCopy[j + 1].getCost()) {
                    temp = itemsCopy[j];
                    itemsCopy[j] = itemsCopy[j + 1];
                    itemsCopy[j + 1] = temp;
                }
            }
        }
        return itemsCopy;
    }

    public String toString() {

        return "Заказ:" +
                " размер: " + size +
                ", позиции: " + Arrays.toString(items);
    }
}
*/