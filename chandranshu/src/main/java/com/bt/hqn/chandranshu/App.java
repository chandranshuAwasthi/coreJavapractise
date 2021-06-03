package com.bt.hqn.chandranshu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 *?
 *
 **/

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        final Employee employee=new Employee(1,"chandranshu");
        List<Employee> listOfemployee=new ArrayList();
        listOfemployee.add(new Employee(1,"chandranshu"));
        listOfemployee.add(new Employee(1,"chandranshu"));
        listOfemployee.add(new Employee(2,"Himanshu"));
        listOfemployee.add(new Employee(3,"Shiva"));
        listOfemployee.add(new Employee(4,"Medha"));
        Function<Employee,Integer> employeeStringFunction=(employeetoMap)->{
          return  employeetoMap.getId();
        };

        listOfemployee.stream().map(Employee::getId)
                .collect(Collectors.toSet() );





    }
}
