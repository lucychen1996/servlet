<%-- 
    Document   : main
    Created on : Oct 24, 2018, 1:42:16 PM
    Author     : Lucyc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send a Message Page</title>
         <jsp:useBean id="ub" class="servletpackage.bean" scope="session" />
    </head>
    
    <body>
       <h1>Send a Message</h1>
        <form method ="post" action="review">
            <table>
                <tbody>
                    <tr>
                      <td>Name:</td>
                    </tr>
                    <tr>
                    <td><input type="text" name="name"  placeholder="Enter Name" size="50"></td>
                    </td>
                    <tr>
                        <td>Email:</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="email" placeholder="Enter Email" size="50"></td>
                    </tr>
                    <tr>
                        <td> Message:</td>
                    </tr>
                    <tr>
                        <td><textarea rows="8" cols="50" name="message" placeholder="Enter Message" ></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Next" name="review" /></td>
                    </tr>          
                </tbody>
            </table> 
        </form>
    </body>
</html>
