package hashTable;

public class StoredEmployee {


    // Linear Probing 시 get method에서 올바른 값을 반환 받기 위해 key 또한 저장해
    // 두기 위한 class를 따로 생성함함
    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}
