package org.repositorypattern.myrepo.model;

import lombok.*;

@Data
@Builder
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements IEntity {
    private String CustomerID;

    private String CompanyName;

    private String ContactName;

    private String ContactTitle;

    private String Address;

    private String City;

    private String Region;

    private String PostalCode;

    private String Country;

    private String Phone;

    private String Fax;



}
