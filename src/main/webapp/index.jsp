<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Splash Screen</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .splash-container {
            text-align: center;
        }

        .splash-logo {
            font-size: 48px;
            color: #4caf50;
            margin-bottom: 20px;
        }

        .splash-title {
            font-size: 24px;
            color: #333;
            margin-bottom: 30px;
        }

        .splash-button {
            font-size: 24px;
            padding: 10px 30px;
            border-radius: 5px;
            background-color: #4caf50;
            border-color: #4caf50;
            color: #fff;
            text-decoration: none;
        }

        .splash-button:hover {
            background-color: #45a049;
            border-color: #45a049;
        }
    </style>
</head>
<body>
<div class="splash-container">
    <i class="fas fa-car splash-logo"></i>
    <h1 class="splash-title">Welcome to Car Showroom</h1>
    <a href="userAuth" class="splash-button">Connexion</a>
</div>
</body>
</html>
