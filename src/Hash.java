import java.util.Iterator;


public class Hash<K extends Comparable<K>, V> implements Iterable<K> {
    private static class HashElement<K extends Comparable<K>, V> implements Comparable<HashElement<K, V>> {
        K key;
        V value;
        
        HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public int compareTo(HashElement<K, V> o) {
            return this.key.compareTo(o.key);
        } 
    }
    
    private int numElements, tableSize;
    private double maxLoadFactor;
    private LinkedList<HashElement<K, V>> [] hashArray;

    @SuppressWarnings("unchecked")
    public Hash(int tableSize){
        this.tableSize = tableSize;
        hashArray = (LinkedList<HashElement<K, V>> []) new LinkedList[tableSize];

        for(int i = 0; i < tableSize; i++){
            hashArray[i] = new LinkedList<HashElement<K, V>>();
        }

        maxLoadFactor = 0.75;
        numElements = 0;
    }

    public boolean add(K key, V value){
        if(loadFactor() > maxLoadFactor)
             resize(tableSize * 2);
        HashElement<K, V> hash = new HashElement<>(key, value);
        int hashVal = (key.hashCode() & 0x7FFFFFFF) % tableSize;

        hashArray[hashVal].addLast(hash);
        numElements++;
        return true;
    }

    public boolean remove(K key, V value){
        HashElement<K, V> hash = new HashElement<>(key, value);
        int hashVal = (key.hashCode() & 0x7FFFFFFF) % tableSize;
        if(hashArray[hashVal].remove(hash) != null){
            numElements--;
            return true;
        }
        return false;
    }

    public V getValue(K key){
        int hashVal = (key.hashCode() & 0x7FFFFFFF) % tableSize;
        for(HashElement<K, V> he : hashArray[hashVal]){
            if(key.compareTo(he.key) == 0)
                return he.value;
        }
        return null;
    }

    private double loadFactor() {
        return (double) numElements / tableSize;
    }

    @SuppressWarnings("unchecked")
    public void resize(int newSize){
        LinkedList<HashElement<K, V>>[] new_array = (LinkedList<HashElement<K, V>> []) new LinkedList[newSize];
        for(int i = 0; i < newSize; i++){
            new_array[i] = new LinkedList<HashElement<K, V>>();
        }
        for(K key : this){
            V val = getValue(key);
            HashElement<K, V> he = new HashElement<>(key, val);
            int hashVal = (key.hashCode() & 0x7FFFFFFF) % newSize;
            new_array[hashVal].addLast(he);
        }
        hashArray = new_array;
        tableSize = newSize;
    }

    @Override
    public Iterator<K> iterator() {
        return new IteratorHelper();
    }

    @SuppressWarnings("unchecked")
    private class IteratorHelper implements Iterator<K> {
        K[] keys;
        int position;
        
        public IteratorHelper(){
            keys = (K[]) new Comparable[numElements]; 
            int p = 0;
            for(int i = 0; i < tableSize; i++){
                LinkedList<HashElement<K, V>> list = hashArray[i];
                for(HashElement<K, V> h : list){
                    keys[p++] = h.key;
                }
            }
            position = 0;
        }

        @Override
        public boolean hasNext(){
            return position < keys.length;
        }
        @Override
        public K next(){
            if(!hasNext())
                return null;
            return keys[position++];
        }
    }
}
