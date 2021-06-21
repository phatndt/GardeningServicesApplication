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

    $userMail = $_POST['username'];
    $userPassword = $_POST['password'];

    $control = mysqli_query($db->connect(),"SELECT * FROM users WHERE username = '$userMail' AND password = '$userPassword'") or die(mysqli_error());

    if (mysqli_num_rows($control) > 0) {
        $response = array();
        $response["success"] = 1;
        $response["message"] = "Đăng nhập thành công";
        echo json_encode($response, JSON_UNESCAPED_UNICODE);
    } else {
        $queryEmail = mysqli_query($db->connect(),"SELECT * FROM users WHERE email = '$userMail' AND password = '$userPassword'") or die(mysqli_error());
        
        if (mysqli_num_rows($queryEmail) > 0) {
            $response = array();
        $response["success"] = 1;
        $response["message"] = "Đăng nhập thành công";
        echo json_encode($response, JSON_UNESCAPED_UNICODE);
        } else {
            $response["success"] = 2;
            $response["message"] = "Đăng nhập thất bại";
            echo json_encode($response, JSON_UNESCAPED_UNICODE);
        }
    }
    // $count = mysqli_num_rows($control);

    // if($count > 0){
    //     $response["success"] = 1;
    //         $response["message"] = "Đăng nhập thành công";
    //         echo json_encode($response, JSON_UNESCAPED_UNICODE);
    //         mysqli_close($db->connect());

    // }else{

    //     $response["success"] = 2;
    //     $response["message"] = "Đăng nhập thất bại";
    //     echo json_encode($response, JSON_UNESCAPED_UNICODE);
    //     mysqli_close($db->connect());
    // }
?>