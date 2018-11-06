<%-- 
    Document   : edit
    Created on : Oct 29, 2018, 11:34:57 PM
    Author     : Lucyc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Missing Field Page</title>
        <jsp:useBean id="ub" class="servletpackage.bean" scope="session" />
    </head>
    <body>
        <h2><jsp:getProperty name="ub" property="status" /></h2>
        <form method ="post" action ="review">
            <table>
                <tbody>
                    <tr>
                        <td>Name:</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="name" size="50" value=<jsp:getProperty name="ub" property="name" />></td>                       
                    </tr>
                    <tr>
                        <td>Email:</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="email" size="50" value=<jsp:getProperty name="ub" property="email" />></td>
                    </tr>
                    <tr>
                        <td>Message:</td>
                    </tr>
                    <tr>
                        <td><textarea name="message" rows="8" cols="50"><jsp:getProperty name="ub" property="message" /></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Next" name="review" ></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
