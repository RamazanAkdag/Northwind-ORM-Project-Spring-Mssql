package org.repositorypattern.myrepo.model;


import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements IEntity{
    private int EmployeeID;

    private String LastName;

    private String FirstName;

    private String Title;

    private String TitleOfCourtesy;

    private Timestamp BirthDate;

    private Timestamp HireDate;

    private String Address;

    private String City;

    private String Region;

    private String PostalCode;

    private String Country;

    private String HomePhone;

    private String Extension;


}
