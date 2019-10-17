<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Calcul Mental - Accueil</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>

    <div class="callout large primary">
        <div class="row column text-center">
            <h1>Calcul Mental - Accueil</h1>
        </div>
    </div>

    <div>
        <a class="button expanded" href="<c:url value="/jeu" />">COMMENCER</a>
    </div>

    <div class="row small-8 small-centered">
        <table>
            <thead>
            <tr>
                <th>Rang</th>
                <th>Nom</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="classement" items="${ sessionScope.classement }" varStatus="status">
                <tr>
                    <td>${classement.rang}</td>
                    <td>${classement.nom}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
    <script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
    <script>
        $(document).foundation();
        document.documentElement.setAttribute('data-useragent', navigator.userAgent);
    </script>
</body>
</html>
