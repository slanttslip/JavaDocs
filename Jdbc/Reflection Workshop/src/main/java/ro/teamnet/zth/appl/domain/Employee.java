package ro.teamnet.zth.appl.domain;

import java.math.BigDecimal;
import java.util.Date;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Entitate pe care o vom folosi in dezvoltarea aplicatiei,
 * si pe care o mapam cu tabela employees din baza de date.
 * Fiecarui camp din aceasta entitate ii corespunde o coloana
 * din tabela employees
 */
@Table(name = "employees")
public class Employee {

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }

    @Id(name = "EMPLOYEE_ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private Date hireDate;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;

    @Column(name = "MANAGER_ID")
    private Integer managerId;

    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        if(commissionPct != null ? !commissionPct.equals(employee.commissionPct) : employee.commissionPct != null) {
            return false;
        }
        if(departmentId != null ? !departmentId.equals(employee.departmentId) : employee.departmentId != null) {
            return false;
        }
        if(email != null ? !email.equals(employee.email) : employee.email != null) {
            return false;
        }
        if(firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) {
            return false;
        }
        if(id != null ? !id.equals(employee.id) : employee.id != null) {
            return false;
        }
        if(jobId != null ? !jobId.equals(employee.jobId) : employee.jobId != null) {
            return false;
        }
        if(lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) {
            return false;
        }
        if(managerId != null ? !managerId.equals(employee.managerId) : employee.managerId != null) {
            return false;
        }
        if(phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null) {
            return false;
        }
        if(salary != null ? !salary.equals(employee.salary) : employee.salary != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (commissionPct != null ? commissionPct.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        return result;
    }
}
