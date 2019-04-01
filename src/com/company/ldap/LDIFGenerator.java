package com.company.ldap;

/**
 *  Copyright (c) 2014.
 *  This file is licensed under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 *  Author : Hasitha Aravinda
 */


public class LDIFGenerator {

    //LDAP related constants:
    public static final String DN = "dn";
    public static final String C = "c";
    public static final String O = "o";
    public static final String OU = "ou";

    //Attributes
    public static final String OBJECT_CLASS = "objectClass";
    public static final String CN = "cn";
    public static final String SN = "sn";
    public static final String GIVENNAME = "givenname";
    public static final String MAIL = "mail";
    public static final String UID = "uid";
    public static final String USER_PASSWORD = "userpassword";

    // Attributes' values
    public static final String TOP = "top";
    public static final String COUNTY = "country";
    public static final String ORGANIZATION = "organization";
    public static final String ORGANIZATIONAL_UNIT = "organizationalUnit";
    public static final String ORGANIZATIONAL_ROLE = "organizationalRole";
    public static final String INET_ORG_PERSON = "inetOrgPerson";
    public static final String PERSON = "person";
    public static final String ORGANIZATIONAL_PERSON = "organizationalPerson";
    public static final String GROUP_OF_NAME = "groupOfNames";
    public static final String MEMBER = "member";

    public static final String EQ = "=";
    public static final String COMMA = ",";
    public static final String NL = "\n"; // New line
    public static final String COLON = ": ";


    private String currentCountryDN;
    private String currentOrganizationDN;
    private String currentOrganizationalUnitDN;
    private String currentOrganizationalRoleDN;

    public String getCurrentCountryDN() {
        if (currentCountryDN == null) {
            throw new RuntimeException("County DN is not generated yet.");
        }
        return currentCountryDN;
    }

    public String getCurrentOrganizationDN() {
        if (currentOrganizationDN == null) {
            throw new RuntimeException("organization DN is not generated yet.");
        }
        return currentOrganizationDN;
    }

    public String getCurrentOrganizationalUnitDN() {
        if (currentOrganizationalUnitDN == null) {
            throw new RuntimeException("organizationalUnit DN is not generated yet");
        }
        return currentOrganizationalUnitDN;
    }

    public String getCurrentOrganizationalRoleDN() {
        if (currentOrganizationalRoleDN == null) {
            throw new RuntimeException("organizationalRole DN is not generated yet");
        }
        return currentOrganizationalRoleDN;
    }

    public String generateUser(String attribute, String username, String password, String email, String parentDN) {
        return DN + COLON + attribute + EQ + username + COMMA + parentDN + NL
                + OBJECT_CLASS + COLON + TOP + NL
                + OBJECT_CLASS + COLON + INET_ORG_PERSON + NL
                + OBJECT_CLASS + COLON + PERSON + NL
                + OBJECT_CLASS + COLON + ORGANIZATIONAL_PERSON + NL
                + CN + COLON + username + NL
                + SN + COLON + username + NL
                + GIVENNAME + COLON + username + NL
                + MAIL + COLON + email + NL
                + UID + COLON + username + NL
                + USER_PASSWORD + COLON + password + NL
                + NL
                ;
    }

    public String generateCountry(String country) {
        this.currentCountryDN = C + EQ + country;
        return DN + COLON + currentCountryDN + NL
                + OBJECT_CLASS + COLON + TOP + NL
                + OBJECT_CLASS + COLON + COUNTY + NL
                + C + COLON + country + NL
                + NL;
    }

    public String generateOrganization(String organization, String countryDN) {
        this.currentOrganizationDN = O + EQ + organization + COMMA + countryDN;
        return DN + COLON + currentOrganizationDN + NL
                + OBJECT_CLASS + COLON + TOP + NL
                + OBJECT_CLASS + COLON + ORGANIZATION + NL
                + O + COLON + organization + NL
                + NL;
    }

    public String generateOrganizationalUnit(String organizationUnit, String organizationDN) {
        this.currentOrganizationalUnitDN = OU + EQ + organizationUnit + COMMA + organizationDN;
        return DN + COLON + currentOrganizationalUnitDN + NL
                + OBJECT_CLASS + COLON + TOP + NL
                + OBJECT_CLASS + COLON + ORGANIZATIONAL_UNIT + NL
                + OU + COLON + organizationUnit + NL
                + NL;
    }

    public String generateOrganizationalRole(String name, String parentDN) {
        this.currentOrganizationalRoleDN = CN + EQ + name + COMMA + parentDN;
        return DN + COLON + currentOrganizationalRoleDN + NL
                + OBJECT_CLASS + COLON + TOP + NL
                + OBJECT_CLASS + COLON + ORGANIZATIONAL_ROLE + NL
                + CN + COLON + name + NL
                + NL;
    }

    public String generateGroup(String attribute, String groupName, String parentDN) {
        return DN + COLON + attribute + EQ + groupName + COMMA + parentDN + NL
                + OBJECT_CLASS + COLON + TOP + NL
                + OBJECT_CLASS + COLON + GROUP_OF_NAME + NL
                + attribute + COLON + groupName + NL
                ;
    }

    public String generateMember(String membershipAttribute, String attribute, String userID, String userParentDN) {
        return MEMBER + COLON + attribute + EQ + userID + COMMA + userParentDN + NL;
    }

}
