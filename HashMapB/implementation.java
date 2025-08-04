
import java.util.*;

import backtracking.array;
import linkedlist.doubly;
import stackCreation.stackException;

public class implementation {
  static class HashMap<K, V> { // generic
    // given
    private class Node {
      K key;
      V value;

      public Node(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private int arr[];
    // array of linked lists
    private LinkedList<Node> buckets[];// N=buckets.length
    private int N;

    @SuppressWarnings("unchecked")
    public HashMap() {
      this.N = 4;
      this.buckets = new LinkedList[4];
      for (int i = 0; i < 4; i++) {
        this.buckets[i] = new LinkedList<>();
      }
    }

    private int hashFunction(K key) {
      int hc = key.hashCode();
      return Math.abs(hc) % N;// it should be in size
    }

    private int searchInLL(K key, int bi) {
      LinkedList<Node> ll = buckets[bi];
      int di = 0;
      for (int i = 0; i < ll.size(); i++) {
        Node node = ll.get(i);
        if (node.key == key) {
          return di;
        }
        di++;
      }
      return -1;
    }

    private void rehash() {
      LinkedList<Node> oldBuck[] = buckets;
      buckets = new LinkedList[N * 2];
      N = 2 * N;

      for (int i = 0; i < buckets.length; i++) {
        buckets[i] = new LinkedList<>();
      }

      // nodes-> add in bucket
      for (int i = 0; i < oldBuck.length; i++) {
        LinkedList<Node> ll = oldBuck[i];
        for (int j = 0; j < ll.size(); j++) {
          Node node = ll.remove();
          put(node.key, node.value);
        }
      }
    }

    // constant time
    public void put(K key, V value) {
      int bi = hashFunction(key);// from 0 to 3
      int di = searchInLL(key, bi);// 2 cases : found & not found (valis/-1) in that bi

      if (di != -1) {
        Node node = buckets[bi].get(di);
        node.value = value;
      } else {
        buckets[bi].add(new Node(key, value));
        size++;
      }

      // checking if rehashing needed

      double lambda = (double) size / N;
      if (lambda > 2.0) {
        rehash();
      }
    }

    public boolean containsKey(K key) {

      // put func to find bi di
      int bi = hashFunction(key);// from 0 to 3
      int di = searchInLL(key, bi);// 2 cases : found & not found (valis/-1) in that bi

      if (di != -1) {
        return true;// exists
      } else {
        return false;
      }

    }

    public V remove(K key) {// O(1)

      int bi = hashFunction(key);// from 0 to 3
      int di = searchInLL(key, bi);// 2 cases : found & not found (valis/-1) in that bi

      if (di != -1) {// found
        Node node = buckets[bi].remove(di);// LL function
        size--;
        return node.value;
      } else {
        return null;
      }
    }

    public V get(K key) { // O(1)

      // put func bi di
      int bi = hashFunction(key);// from 0 to 3
      int di = searchInLL(key, bi);// 2 cases : found & not found (valis/-1) in that bi

      if (di != -1) {
        Node node = buckets[bi].get(di);
        return node.value;
      } else {
        return null;
      }
    }

    public ArrayList<K> keySet() {
      ArrayList<K> keys = new ArrayList<>();

      for (int i = 0; i < buckets.length; i++) {
        LinkedList<Node> ll = buckets[i];
        for (Node node : ll) {
          keys.add(node.key);
        }
      }
      return keys;
    }

    public boolean isEmpty() {
      return size == 0;
    }

  }

  public static void main(String[] args) {
    HashMap<String, Integer> hm = new HashMap<>();
    hm.put("bajji", 10);
    hm.put("vada", 20);
    hm.put("idli", 10);
    hm.put("dosa", 30);

    ArrayList<String> keys = hm.keySet();
    for (String i : keys) {
      System.out.println(i + ":" + hm.get(i));
    }

  }
}
