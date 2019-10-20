<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Calcul Mental - Resultat</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>
<!-- Affichage du résultat du test -->
<div class="container">
    <div class="callout large primary">
        <div class="row column text-center">
            <h1>Calcul Mental - Résultat</h1>
        </div>
    </div>
    <div class="text-center">
            <p class="white-text text-lighten-5">Votre score est de <b>${nbCorrect} / ${nbQuestions}</b></p>
            <a class="button expanded" href="<c:url value="/accueil" />">Retourner à l'accueil</a>
    </div>
</div>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
</body>
</html>