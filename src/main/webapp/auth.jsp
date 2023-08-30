<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            background-color: #f8f9fa;
        }

        .card {
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .form-outline {
            position: relative;
        }

        .form-outline label {
            position: absolute;
            top: -12px;
            left: 12px;
            background-color: #f8f9fa;
            padding: 0 4px;
            font-size: 12px;
            color: #999999;
        }

        .splash-container {
            text-align: center;
            margin-bottom: 10px; /* Updated margin */
            padding-bottom: 20px; /* Added padding */
        }

        .splash-logo {
            font-size: 48px;
            color: #4caf50;
            margin-bottom: 20px;
        }

        .splash-title {
            font-size: 24px;
            color: #333;
            margin-bottom: 10px; /* Updated margin */
        }

        .form-check-label::before {
            width: 20px;
            height: 20px;
            margin-top: -2px;
            margin-left: -20px;
        }

        .btn-primary {
            background-color: #4caf50;
            border-color: #4caf50;
        }

        .btn-primary:hover {
            background-color: #45a049;
            border-color: #45a049;
        }

        .btn-primary:focus {
            box-shadow: 0 0 0 0.2rem rgba(76, 175, 80, 0.5);
        }
    </style>
</head>
<body>
<br>
<br>
<br>
<div class="splash-container">
    <i class="fas fa-car splash-logo"></i>
    <h1 class="splash-title">Welcome to Car Showroom</h1>
</div>
<form method="post" action="userAuth">
    <div class="container py-3">
        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <h5 class="text-danger">${erreur}</h5>
                        <h3 class="mb-5">Sign in</h3>

                        <div class="form-outline mb-4">
                            <label class="form-label" for="typeEmailX-2">Login</label>
                            <input type="email" id="typeEmailX-2" class="form-control form-control-lg" name="login" required />
                        </div>

                        <div class="form-outline mb-4">
                            <label class="form-label" for="typePasswordX-2">Password</label>
                            <input type="password" id="typePasswordX-2" class="form-control form-control-lg" name="password" required />
                        </div>


            <!-- Checkbox -->
            <div class="form-check d-flex justify-content-start mb-4">
                <input class="form-check-input" type="checkbox" value="" id="form1Example3" />
                <label class="form-check-label" for="form1Example3">Remember password</label>
            </div>

            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
          </div>
        </div>
      </div>
    </div>
  </div>

</form>
</body>
</html>
