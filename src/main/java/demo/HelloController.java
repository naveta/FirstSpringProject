package demo;

/**
 * Created by robotic4 on 1/10/15.
 */

import java.util.*;


import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class HelloController {


    private static final String template = "Hello %s !!";

    private final AtomicLong counter = new AtomicLong();

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    Map<Integer, Employee> empData = new HashMap<>();

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/greeting")

    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @RequestMapping(value = AppConstants.DUMMY_EMP, method = RequestMethod.GET)

    public
    @ResponseBody
    Employee getDummyEmployee() {
        logger.info("start get Dummy Employee");

        Employee emp = new Employee();

        emp.setId(21);

        emp.setName("Naveta");

        emp.setDate(new Date());

        empData.put(21, emp);

        return emp;
    }

    @RequestMapping(value = AppConstants.GET_EMP, method = RequestMethod.GET)

    public
    @ResponseBody
    Employee getEmployee(@PathVariable("id") int empId) {
        logger.info("start in get Employee with id " + empId);

        return empData.get(empId);
    }


    @RequestMapping(value = AppConstants.GET_ALL_EMP, method = RequestMethod.GET)

    public
    @ResponseBody
    List<Employee> getAllEmployees() {
        logger.info("start in get all employees");

        List<Employee> employees = new ArrayList<>();

        Set<Integer> empIDKeys = empData.keySet();

        for (Integer i : empIDKeys)
            employees.add(empData.get(i));

        return employees;
    }

    @RequestMapping(value = AppConstants.CREATE_EMP, method = RequestMethod.POST)

    public
    @ResponseBody
    Employee createEmployee(@RequestBody Employee employee) {
        logger.info("start inside creating a new employee");

        employee.setDate(new Date());

        empData.put(employee.getId(), employee);

        return employee;
    }


    @RequestMapping(value = AppConstants.DELETE_EMP, method = RequestMethod.PUT)

    public
    @ResponseBody
    Employee deleteEmployee(@PathVariable("id") int emId) {
        logger.info("start in delete emp");

        Employee employee = empData.get(emId);

        empData.remove(employee);

        return employee;
    }


    @RequestMapping(value = AppConstants.CREATE_DATABASE_EMP, method = RequestMethod.POST)

    public
    @ResponseBody
    User createDatabaseUser(@RequestBody User user) {


        logger.info("start inside create database user");
        user = userService.save(user);


        return user;
//        User user = null;
//
//        try
//        {
//            user = new User(name,email,salary);
//
//            userDao.save(user);
//        }
//
//        catch (Exception e)
//        {
//            return null;
//        }
//
//        return user;

    }


    @RequestMapping(value = AppConstants.GET_ALL_DATABASE_EMP, method = RequestMethod.GET)

    public
    @ResponseBody
    ResponseEntity getAllDatabaseEmployees() {
        Iterable user = userDao.findAll();

        if (user == null) {
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }


    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;
}