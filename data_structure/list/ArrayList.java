package list;

import java.util.List;

public class ArrayList {
    public static void main(String[] args){
        List<Employee> employeeList = new java.util.ArrayList<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        // lambda 사용해 출력
//        employeeList.forEach(employee -> System.out.println(employee));
//
//        // John Doe가 나오게 된다. 1번 Index의 element
//        System.out.println(employeeList.get(1));
//
//        // ArrayList가 비어있는지 확인
//        System.out.println(employeeList.isEmpty());

        // 지정 Index의 Element 내용 변경
        employeeList.set(1, new Employee("John", "Adams", 4567));

        // 현재 추가된 Element의 수를 추적
//        System.out.println(employeeList.size());

        // 특정 index에 Element 삽입
        employeeList.add(3, new Employee("John", "Doe", 2123));

//        employeeList.forEach(employee -> System.out.println(employee));

        // 기존 Element를 배열로 변경하여 다른 객체 배열에 저장한 후 출력함
//        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for(Employee employee : employeeArray){
//            System.out.println(employee);
//        }

        // 인스턴스 끼리의 비교는 단순히 값만 같다고 해서 True가 되지 않음
        // 따라서 해당 비교는 Employee에 equals, hashcode를 override 하여야 한다.
        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22)));

        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 2123)));

        // 중간에 있는 index의 element를 삭제
        // shift를 해야 해서 실제 코드를 보면 arraycopy를 하고 있는 것을 알 수 있음
        employeeList.remove(2);

        employeeList.forEach(employee -> System.out.println(employee));
    }
}
