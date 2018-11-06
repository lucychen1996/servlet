<%-- 
    Document   : confirmation
    Created on : Oct 29, 2018, 11:36:48 PM
    Author     : Lucyc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
         <jsp:useBean id="ub" class="servletpackage.bean" scope="session" />
    </head>
    <body>
        <h2>Thanks
            <jsp:getProperty name="ub" property="name" />
        </h2>
        <p>
            <jsp:getProperty name="ub" property="status" />
        </p>
    </body>
</html>
