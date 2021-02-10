import java.util.*;

public class Collections {

    public static void main(String[] args)
    {
        System.out.println("ArrayList:");
        ArrayList<String> list = new ArrayList<String>();
        list.add("Sam");
        list.add("Lisa");
        System.out.println(list);

        System.out.println("\nVector:");
        Vector<Integer> vec = new Vector<Integer>();
        vec.addElement(3);
        vec.addElement(55);
        System.out.println(vec);

        System.out.println("\nLinkedList:");
        LinkedList<String> cities = new LinkedList<String>();
        cities.add("Chicago");
        cities.add("Columbia");
        Iterator<String> it = cities.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

        System.out.println("\nHashSet");
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(789);
        set.add(99);
        set.add(43);
        set.add(1);
        System.out.println(set);

        System.out.println("\nLinkedHashSet:");
        LinkedHashSet<Integer> set2 = new LinkedHashSet<Integer>();
        set2.add(456);
        set2.add(123);
        set2.add(589);
        set2.add(255);
        System.out.println(set2);

        System.out.println("\nHashMap");
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "Ash");
        hm.put(2, "Craig");
        hm.put(3, "Sara");
        for (Map.Entry<Integer, String> m : hm.entrySet())
        {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("\nHashTable");
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
        ht.put(4, "Canada");
        ht.put(5, "South Africa");
        ht.put(6, "New Zealand");
        for (Map.Entry<Integer, String> m : ht.entrySet())
        {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }
    
}
