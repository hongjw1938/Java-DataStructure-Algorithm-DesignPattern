package list;

public class DLEmployeeNode {
    private Employee employee;
    private DLEmployeeNode next;
    private DLEmployeeNode previous;

    public DLEmployeeNode(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public DLEmployeeNode getNext() {
        return next;
    }

    public void setNext(DLEmployeeNode next) {
        this.next = next;
    }

    public DLEmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLEmployeeNode previous) {
        this.previous = previous;
    }

    public String toString(){
        return employee.toString();
    }
}
