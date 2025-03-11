package arrayLists;
import java.util.*;

public class ArrayListProblems {
    public static void main(String[] args)
    {
        creation();
        studentsList();
    }

    public static void creation()
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(22);
        numbers.add(33);
        numbers.add(44);
        numbers.add(55);
        numbers.add(33);
        numbers.add(22);

        System.out.println(numbers);
        removeDuplicates(numbers);
    }

    public static void removeDuplicates(List<Integer> numbers)
    {
        Set<Integer> numbersSet = new HashSet<Integer>(numbers);
        ArrayList<Integer> numbersList = new ArrayList<>(numbersSet);
        System.out.println("List after duplicate removal Random" + numbersList);

        Set<Integer> numberLinkedSet = new LinkedHashSet<>(numbers);
        ArrayList<Integer> arrangedList = new ArrayList<>(numberLinkedSet);
        System.out.println("List after duplicate removal Arranged" + arrangedList);
    }

    public static void studentsList(){
        LinkedList<String> studentDetails = new LinkedList<>();
        studentDetails.add("Rohit");
        studentDetails.add("Gill");
        studentDetails.add("Virat");
        studentDetails.add("Shreyas");
        studentDetails.add("Axar");
        studentDetails.add("Rahul");
        studentDetails.add("Hardik");

        studentDetails.forEach(System.out :: println);
    }
}
