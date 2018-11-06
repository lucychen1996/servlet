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
        <title>Review Page</title>
        <jsp:useBean id="ub" class="servletpackage.bean" scope="session" />
    </head>
    <body>
        
        <h2>Review</h2>
        <form method ="post" action="submit">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name"  readonly size="50" value=<jsp:getProperty name="ub" property="name" />></td>                       
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email"  readonly size="50" value=<jsp:getProperty name="ub" property="email" />></td>
                    </tr>
                    <tr>
                        <td>Message:</td>
                        <td><textarea name="message" rows="8" cols="50" readonly><jsp:getProperty name="ub" property="message" /></textarea>
                        </td>
                    </tr>
                    <tr>
                          <td></td> 
                          <td><input type="submit" value="Submit Message" name="submit" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
