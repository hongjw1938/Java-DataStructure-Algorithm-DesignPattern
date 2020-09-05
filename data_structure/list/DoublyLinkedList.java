package list;

public class DoublyLinkedList {
    public static void main(String[] args){
        Employee employee = new Employee("John", "Doe", 4567);
        Employee employee2 = new Employee("Mary", "Smith", 22);
        Employee employee3 = new Employee("Jane", "Jones", 123);
        Employee employee4 = new Employee("Mike", "Wilson", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(employee);
        list.addToFront(employee2);
        list.addToFront(employee3);
        list.addToFront(employee4);



        Employee employee5 = new Employee("Bill", "End", 15);
        list.addToEnd(employee5);
        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        list.printList();

        list.removeFromEnd();
        list.printList();
    }
}
