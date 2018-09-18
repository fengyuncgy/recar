package cn.xzit.recar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @RequestMapping("/admin")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/customer")
    public String customerIndex() {
        return "customer/index";
    }

    @RequestMapping("/passwordCustomer")
    public String passwordUpdateCustomer() {
        return "customer/passwordUpdate";
    }

    @RequestMapping("/carCustomer")
    public String carCustomer() {
        return "customer/car";
    }


    @RequestMapping("/employee")
    public String employeeIndex() {
        return "employee/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/StoreManage")
    public String storeManage() {
        return "StoreManage";
    }

    @RequestMapping("/StoreDetails")
    public String storeDetails() {
        return "StoreDetails";
    }

    @RequestMapping("/StoreMemberList")
    public String storeMemberList() {
        return "StoreMemberList";
    }

    @RequestMapping("/StoreRecord")
    public String storeRecord() {
        return "StoreRecord";
    }

    @RequestMapping("/StoreRevenueRecord")
    public String storeRevenueRecord() {
        return "StoreRevenueRecord";
    }

    @RequestMapping("/AccountSettings")
    public String accountSettings() {
        return "AccountSettings";
    }

    @RequestMapping("/Employees")
    public String employees() {
        return "admin/Employees";
    }

    @RequestMapping("/Salary")
    public String salary() {
        return "admin/Salary";
    }

    @RequestMapping("/Car")
    public String car() {
        return "admin/Car";
    }

    @RequestMapping("/Customer")
    public String customer() {
        return "admin/Customer";
    }

    @RequestMapping("/Applies")
    public String apply() {
        return "admin/Applies";
    }

    @RequestMapping("/customer_Applies")
    public String customerApply() {
        return "customer/Applies";
    }

    @RequestMapping("/Detection")
    public String detection() {
        return "admin/Detection";
    }

    @RequestMapping("/Maintenance")
    public String maintenance() {
        return "admin/Maintenance";
    }

    @RequestMapping("/Evaluate")
    public String evaluate() {
        return "admin/Evaluate";
    }

    @RequestMapping("/PartGroup")
    public String partGroup() {
        return "admin/PartGroup";
    }

    @RequestMapping("/Part")
    public String part() {
        return "admin/Part";
    }

    @RequestMapping("/Manufacturer")
    public String manufacturer() {
        return "admin/Manufacturer";
    }

    @RequestMapping("/Warehouse")
    public String warehouse() {
        return "admin/Warehouse";
    }

    @RequestMapping("/MaintenancePart")
    public String maintenancePart() {
        return "admin/MaintenancePart";
    }
    @RequestMapping("/MaintenancePart2")
    public String maintenancePart2() {
        return "admin/MaintenancePart2";
    }
    @RequestMapping("/Order")
    public String order(){
        return "admin/Order";
    }
    @RequestMapping("/CustomerOrder")
    public String customerOrder(){
        return "customer/Order";
    }
    @RequestMapping("/Flow")
    public String flow() {
        return "admin/Flow";
    }

    @RequestMapping("/Register")
    public String register() {
        return "register";
    }

    @RequestMapping("/CustomerInfo")
    public String customerInfo() {
        return "customer/customerInfo";
    }


    @RequestMapping("/EmployeeInfo")
    public String employeeInfo() {
        return "employee/employeeInfo";
    }

    @RequestMapping("/EmpSalary")
    public String empSalary() {
        return "employee/Salary";
    }

    @RequestMapping("/EmployeePasswordUpdate")
    public String passwordUpdate() {
        return "employee/passwordUpdate";
    }

    @RequestMapping("/EmployeeDetection")
    public String employeeDetection() {
        return "employee/Detection";
    }

    @RequestMapping("/EmployeeMaintenance")
    public String employeeMaintenance() {
        return "employee/Maintenance";
    }

    @RequestMapping("/EmployeeEvaluate")
    public String employeeEvaluate() {
        return "employee/Evaluate";
    }

    @RequestMapping("/EmployeeMaintenancePart")
    public String employeeMaintenancePart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        if (id != null)
            session.setAttribute("maintenanceid", id);
        return "employee/MaintenancePart";
    }


    @RequestMapping("/CustomerDetection")
    public String customerDetection() {
        return "customer/Detection";
    }


    @RequestMapping("/CustomerMaintenancePart")
    public String customerMaintenancePart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        if (id != null)
            session.setAttribute("maintenanceid", id);
        return "customer/MaintenancePart";
    }
    @RequestMapping("/AdminMaintenancePart")
    public String adminMaintenancePart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        if (id != null)
            session.setAttribute("maintenanceid", id);
        return "admin/MaintenancePart";
    }

    @RequestMapping("/AdminFlowPart")
    public String adminFlowPart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        if (id != null)
            session.setAttribute("flowid", id);
        return "admin/FlowPart";
    }
    @RequestMapping("/CustomerMaintenance")
    public String customerMaintenance() {
        return "customer/Maintenance";
    }

    @RequestMapping("/CustomerEvaluate")
    public String customerEvaluate() {
        return "customer/Evaluate";
    }
}
