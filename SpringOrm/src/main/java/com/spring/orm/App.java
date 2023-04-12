package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(45,"prashant","mumbai");
//        int r =studentDao.insert(student);
//        System.out.println("done..."+r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true; // use for exit to exit the loop.
		while (go) {
			System.out.println("PRESS 1 for add new Student");
			System.out.println("PRESS 2 for display all student ");
			System.out.println("PRESS 3 for get detail of single student");
			System.out.println("PRESS 4 for delete students");
			System.out.println("PRESS 5 for update students");
			System.out.println("PRESS 6 for Exit");

			try {

				int input = Integer.parseInt(br.readLine());

//				if(input == 1)
//				{
//					//add a new student
//				}else if(input ==2 )
//				{
//					//display
//				}

				switch (input) {

				case 1:
					// add a new student
					// taking input from users
					System.out.println("Enter user id :");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("Enter user name :");
					String uName = br.readLine();

					System.out.println("Enter user city :");
					String uCity = br.readLine();

					// creating student object and setting values
					Student s = new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);

					// saving student object to database by calling insert of student Dao
					int r = studentDao.insert(s);
					System.out.println(r + " Student added");
					System.out.println("******************************");
					System.out.println();

					break;
				case 2:
					// display all student
					System.out.println("**************************");
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println("Id : " + st.getStudentId());
						System.out.println("Name : " + st.getStudentName());
						System.out.println("City : " + st.getStudentCity());
						System.out.println("________________________________");
					}
					System.out.println("**************************");
					break;
				case 3:
					// get detail of single student

					System.out.println("Enter user id :");
					int userId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId);
					System.out.println("Id : " + student.getStudentId());
					System.out.println("Name : " + student.getStudentName());
					System.out.println("City : " + student.getStudentCity());
					System.out.println("________________________________");

					break;
				case 4:
					// delete students
					System.out.println("Enter user id :");
					int id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student deleted...");

					break;
				case 5:
					// update students
					System.out.println("Update");

					System.out.println("Enter user id :");
					int id1 = Integer.parseInt(br.readLine());
					System.out.println("Do you want to update name also type 1 /2 ");
					int key = Integer.parseInt(br.readLine());

					String Name1 = "";
					String City1 = "";

					Student st1 = studentDao.getStudent(id1);
					System.out.println(st1);

					switch (key) {
					case 1:
						System.out.println("Enter Name :");
						Name1 = br.readLine();
						break;

					case 2:
						System.out.println("Retreving Old Name from DB");
						Name1 = st1.getStudentName();
						System.out.println(st1.getStudentName());
						System.out.println("Name : " + st1.getStudentName() + "" + "Retrieved");
						System.out.println("__________________________");
					default:
						break;
					}

					System.out.println("Do you want to update City type 1/2");
					int key1 = Integer.parseInt(br.readLine());

					switch (key1) {
					case 1:
						System.out.println("Enter City Name :");
						City1 = br.readLine();
						break;

					case 2:
						System.out.println("Retreving Old Name from DB");
						City1 = st1.getStudentCity();
						System.out.println(st1.getStudentCity());
						System.out.println("Name : " + st1.getStudentCity() + "" + "Retrieved");
						System.out.println("__________________________");
					default:
						break;
					}
					
					Student student2 = new Student(id1,Name1, City1);
					studentDao.updateStudent(student2);
					System.out.println("Id Number :"+id1+" had been successfully updated");
					

					break;
				case 6:
					// exit
					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input Try with another one !!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thankyou for using my application");
		System.out.println("See you soon");

	}
}
