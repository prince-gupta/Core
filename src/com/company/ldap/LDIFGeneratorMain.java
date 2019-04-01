package com.company.ldap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LDIFGeneratorMain {

    /**
     * Example LDIF Generator
     *
     */
    public static void main(String[] args) throws Exception {

        LDIFGenerator ldiffGenerator = new LDIFGenerator();
        File file = new File("/tmp/GroupsGen1.ldif");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);


        // configure following values

        final int TOTAL_USER_COUNT = 2;
        final int TOP_GROUPS_COUNT = 5;
        final int SUB_GROUPS_COUNT = 2;
        final int CHILD_GROUPS_COUNT = 10;
        final int USERS_PER_GROUP = 5;

        // Names
        final String COUNTRY = "IND";
        final String ORGANIZATION = "MAXWORTH";
        final String ORGANIZATION_UNIT = "it";

        //Organizational Roles names
        final String USERS = "users";
        final String GROUPS = "groups";
        final String ADMINS = "admins";

        //Admin Details
        final String ADMIN_NAME = "admin@admin.com";
        final String ADMIN_PASSWORD = "admin=";
        final String ADMIN_ROLE = "admin";

        final String USER_NAME_PREFIX = "user";
        final String USER_EMAIl_DOMAIN = "@user.com";
        final String USER_PASSWORD = "password=";

        final String GROUP_PARENT_NAME = "parentGroup";
        final String GROUP_SUB__NAME = "subGroup";
        final String GROUP_CHILD__NAME = "childGroup";


        bw.write("version: 1\n\n");

        // creating county
        bw.append(ldiffGenerator.generateCountry(COUNTRY));

        // creating origination DN
        bw.append(ldiffGenerator.generateOrganization(
                ORGANIZATION,
                ldiffGenerator.getCurrentCountryDN()));

        // creating originationUnit DN
        bw.append(ldiffGenerator.generateOrganizationalUnit(
                ORGANIZATION_UNIT,
                ldiffGenerator.getCurrentOrganizationDN()));

        // creating ADMIN organizational Role
        bw.append(ldiffGenerator.generateOrganizationalRole(
                ADMINS,
                ldiffGenerator.getCurrentOrganizationalUnitDN()));

        // adding ADMIN USER
        bw.append(ldiffGenerator.generateUser(
                LDIFGenerator.CN,
                ADMIN_NAME,
                ADMIN_PASSWORD,
                ADMIN_NAME,
                ldiffGenerator.getCurrentOrganizationalRoleDN()));

        bw.append(ldiffGenerator.generateGroup(
                LDIFGenerator.CN,
                ADMIN_ROLE,
                ldiffGenerator.getCurrentOrganizationalRoleDN()));

        bw.append(ldiffGenerator.generateMember(
                LDIFGenerator.MEMBER,
                LDIFGenerator.CN,
                ADMIN_NAME,
                ldiffGenerator.getCurrentOrganizationalRoleDN()));
        bw.append(LDIFGenerator.NL);

        // creating Users organizational Role
        bw.append(ldiffGenerator.generateOrganizationalRole(
                USERS, ldiffGenerator.getCurrentOrganizationalUnitDN()));

        String userPath = ldiffGenerator.getCurrentOrganizationalRoleDN();
        // creating users OrgRole
        for (int i = 1; i <= TOTAL_USER_COUNT; i++) {
            bw.append(ldiffGenerator.generateUser(
                    LDIFGenerator.CN,
                    USER_NAME_PREFIX + i + USER_EMAIl_DOMAIN,
                    USER_PASSWORD,
                    USER_NAME_PREFIX + i + USER_EMAIl_DOMAIN,
                    ldiffGenerator.getCurrentOrganizationalRoleDN()));
        }

        System.out.println("Generating users completed !");

        // creating groups OrgRole
        bw.append(ldiffGenerator.generateOrganizationalRole(
                GROUPS,
                ldiffGenerator.getCurrentOrganizationalUnitDN()));

        String groupsOrgRoleDN = ldiffGenerator.getCurrentOrganizationalRoleDN();

        for (int i = 1; i <= TOP_GROUPS_COUNT; i++) {

            bw.append(ldiffGenerator.generateOrganizationalRole(
                    GROUP_PARENT_NAME + i,
                    groupsOrgRoleDN));
            String currentTopGroupDN = ldiffGenerator.getCurrentOrganizationalRoleDN();

            for (int j = 1; j <= SUB_GROUPS_COUNT; j++) {

                String subGroupID = "_" + i + "_" + j;
                bw.append(ldiffGenerator.generateOrganizationalRole(
                        GROUP_SUB__NAME + subGroupID,
                        currentTopGroupDN));
                String currentSubGroupDN = ldiffGenerator.getCurrentOrganizationalRoleDN();

                for (int k = 1; k <= CHILD_GROUPS_COUNT; k++) {
                    String childGroupID = subGroupID + "_" + k;
                    bw.append(ldiffGenerator.generateGroup(
                            LDIFGenerator.CN,
                            GROUP_CHILD__NAME + childGroupID,
                            currentSubGroupDN));

                    //Adding users to above group.
                    for (int l = 0; l < USERS_PER_GROUP; l++) {

                        // Adding 1 to avoid getting zero and floor to avoid getting number more than TOTAL_USER_COUNT
                        int userID = (int) Math.floor(Math.random() * TOTAL_USER_COUNT) + 1;
                        bw.append(ldiffGenerator.generateMember(
                                LDIFGenerator.MEMBER,
                                LDIFGenerator.CN,
                                USER_NAME_PREFIX + userID + USER_EMAIl_DOMAIN,
                                userPath));
                    }
                    bw.append(LDIFGenerator.NL);
                }
            }
        }

        System.out.println("Generating groups completed !");

        bw.close();
        System.out.println("Done !");
    }




}
