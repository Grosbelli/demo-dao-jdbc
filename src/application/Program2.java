package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: department findById =====");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("=== TEST 2: department findAll =====");
        List<Department> departments = departmentDao.findAll();
        departments.forEach(x -> {
            System.out.println(x);
        });

        System.out.println("=== TEST 3: department insert =====");
        department.setName("Musical");
        departmentDao.insert(department);
        System.out.println("Department included! Id = " + department.getId());

        System.out.println("=== TEST 4: department update =====");
        Department department2 = departmentDao.findById(3);
        department2.setName("Finance");
        departmentDao.update(department2);
        System.out.println("Update completed!");

        System.out.println("=== TEST 5: department delete =====");
        System.out.println("Enter with department id to be exclude: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
