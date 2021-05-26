<?php

    /*
    * Following code will list all the products
    */
    // array for JSON response
    $response = array();
    
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
        
    // connecting to db
    $db = new db_connect();

    $userName = $_POST['username'];
    $userPassword = $_POST['password'];
    $userEmail=$_POST['email'];

    $control = mysqli_query($db->connect(),"INSERT INTO users(username,password,email) VALUES ('$userName','$userPassword','$userEmail')");
    if ($control) {
        $response = array();
        $response["success"] = 1;
        $response["message"] = "Đăng ký thành công";
         echo json_encode($response, JSON_UNESCAPED_UNICODE);
    }
     else {
        
        $response["success"] = 2;
        $response["message"] = "Đăng ký thất bại";
         echo json_encode($response, JSON_UNESCAPED_UNICODE);
    }
?>