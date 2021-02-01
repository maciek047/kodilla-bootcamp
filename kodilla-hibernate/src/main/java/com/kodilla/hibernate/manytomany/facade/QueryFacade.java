package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QueryFacade {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> findEmployee(String text) {
        return employeeDao.retrieveEmployeesByFragmentOfText("%"+text+"%");
    }

    public List<Company> findCompany(String text) {
        return companyDao.retrieveCompaniesByFragmentOfText("%"+text+"%");
    }
}
