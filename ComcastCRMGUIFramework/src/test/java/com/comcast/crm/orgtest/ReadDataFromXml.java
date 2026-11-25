package com.comcast.crm.orgtest;

import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;



import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXml {

    @Parameters({"un", "pwd"})
    @Test
    public void m1(@Optional("admin") String un,
                   @Optional("admin") String pwd) {

        System.out.println("un: " + un);
        System.out.println("pwd: " + pwd);
    }

    @Test
    public void m2(XmlTest test) {

        System.out.println("un: " + test.getParameter("un"));
        System.out.println("pwd: " + test.getParameter("pwd"));
    }

	}


