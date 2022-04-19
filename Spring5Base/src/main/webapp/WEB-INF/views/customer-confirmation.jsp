<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
	<title>Customer Confirmation</title>
</head>

<body>

The customer is confirmed: ${customer2.firstName} ${customer2.lastName}

<br><br>

Free passes: ${customer2.freePasses}

<br><br>

Email: ${customer2.email}

<br><br>

Postal Code: ${customer2.postalCode}

</body>

</html>










