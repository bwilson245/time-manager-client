package com.tmc.controller;

import com.tmc.dependency.*;
import com.tmc.model.*;
import com.tmc.model.request.*;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@RestController
public class Controller {
    /*
     ********************** HEALTH CHECK ****************
     */
    @GetMapping("/")
    public String healthCheck() {
        return "Welcome to Time Manager!";
    }

    /*
     ********************** TIMESHEET ****************
     */
    @GetMapping("/timesheets/{id}")
    public ResponseEntity<Timesheet> getTimesheet(@PathVariable String id) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideTimesheetActivity().getTimesheet(id), HttpStatus.OK);
    }

    @GetMapping("/timesheets/company/{id}")
    public ResponseEntity<List<Timesheet>> getTimesheetsForCompany(@RequestParam String id,
                                                         @RequestParam (required = false) String type,
                                                         @RequestParam (required = false) Long before,
                                                         @RequestParam (required = false) Long after,
                                                         @RequestParam (required = false) String department,
                                                         @RequestParam (required = false) Boolean complete,
                                                         @RequestParam (required = false) Boolean validated,
                                                         @RequestParam (required = false) String orderNum) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideTimesheetActivity().getTimesheetsForCompany(id, type, department,
                                                        orderNum, before, after, complete, validated), HttpStatus.OK);
    }

    @GetMapping("/timesheets/customer/{id}")
    public ResponseEntity<List<Timesheet>> getTimesheetsForCustomer(@RequestParam String id,
                                                                   @RequestParam (required = false) String type,
                                                                   @RequestParam (required = false) Long before,
                                                                   @RequestParam (required = false) Long after,
                                                                   @RequestParam (required = false) String department,
                                                                   @RequestParam (required = false) Boolean complete,
                                                                   @RequestParam (required = false) Boolean validated,
                                                                   @RequestParam (required = false) String orderNum) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideTimesheetActivity().getTimesheetsForCustomer(id, type, department,
                orderNum, before, after, complete, validated), HttpStatus.OK);
    }

    @GetMapping("/timesheets/employee/{id}")
    public ResponseEntity<List<Timesheet>> getTimesheetsForEmployee(@RequestParam String id,
                                                                    @RequestParam (required = false) String type,
                                                                    @RequestParam (required = false) Long before,
                                                                    @RequestParam (required = false) Long after,
                                                                    @RequestParam (required = false) String department,
                                                                    @RequestParam (required = false) Boolean complete,
                                                                    @RequestParam (required = false) Boolean validated,
                                                                    @RequestParam (required = false) String orderNum) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideTimesheetActivity().getTimesheetsForEmployee(id, type, department,
                orderNum, before, after, complete, validated), HttpStatus.OK);
    }

    @PostMapping("/timesheets")
    public ResponseEntity<Timesheet> createTimesheet(@RequestBody CreateTimesheetRequest request) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideTimesheetActivity().createTimesheet(request), HttpStatus.OK);
    }

    @PutMapping("/timesheets/{id}")
    public ResponseEntity<Timesheet> editEmployee(@PathVariable String id,
                                                 @RequestBody EditTimesheetRequest request) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideTimesheetActivity()
                .editTimesheet(id, request), HttpStatus.OK);
    }

    /*
     ********************** EMPLOYEE ****************
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideEmployeeActivity().getEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestBody List<String> ids) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideEmployeeActivity().getEmployees(ids), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeRequest request) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideEmployeeActivity().createEmployee(request), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable String id,
                                                 @RequestBody EditEmployeeRequest request) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideEmployeeActivity()
                .editEmployee(id, request), HttpStatus.OK);
    }


    @PutMapping("/employees/deactivate/{id}")
    public ResponseEntity<Employee> deactivateEmployee(@PathVariable String id) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideEmployeeActivity()
                .deactivateEmployee(id), HttpStatus.OK);
    }

    /*
    ********************** CUSTOMER ****************
     */
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCustomerActivity().getCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(@RequestBody List<String> ids) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCustomerActivity().getCustomers(ids), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequest request) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCustomerActivity().createCustomer(request), HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable String id,
                                                 @RequestBody EditCustomerRequest request) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCustomerActivity()
                .editCustomer(id, request), HttpStatus.OK);
    }

    @PutMapping("/customers/deactivate/{id}")
    public ResponseEntity<Customer> deactivateCustomer(@PathVariable String id) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCustomerActivity()
                .deactivateCustomer(id), HttpStatus.OK);
    }

    /*
     ********************** COMPANY ****************
     */
    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable String id) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCompanyActivity().getCompany(id), HttpStatus.OK);
    }

    @PostMapping("/company")
    public ResponseEntity<Company> createCompany(@RequestBody CreateCompanyRequest request) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCompanyActivity().createCompany(request), HttpStatus.OK);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<Company> editCompany(@PathVariable String id,
                                                 @RequestBody EditCompanyRequest request) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCompanyActivity()
                .editCompany(id, request), HttpStatus.OK);
    }

    @PutMapping("/company/deactivate/{id}")
    public ResponseEntity<Company> deactivateCompany(@PathVariable String id) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return new ResponseEntity<>(dagger.provideCompanyActivity()
                .deactivateCompany(id), HttpStatus.OK);
    }
}
