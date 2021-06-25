<?php

    $response = array();

    require_once __DIR__ . '/db_connect.php';

    $db = new db_connect();

    $userMail = $_POST['username'];
    $userPassword = $_POST['password'];
    
    $result = mysqli_query($db->connect(),"SELECT id FROM users WHERE username = '$userMail' AND password = '$userPassword'") or die(mysqli_error());

    if (mysqli_num_rows($result) > 0) {

        $response = array();

        while ($row = mysqli_fetch_array($result)) {

            $idUser = array();

            $idUser["id"] = $row["id"];
            
            array_push($response, $idUser);

        }


        echo json_encode($response, JSON_UNESCAPED_UNICODE);

    } else {

        $queryEmail = mysqli_query($db->connect(),"SELECT id FROM users WHERE email = '$userMail' AND password = '$userPassword'") or die(mysqli_error());
        
        if (mysqli_num_rows($queryEmail) > 0) {

            $response = array();

            echo json_encode($response, JSON_UNESCAPED_UNICODE);

        } else {

            echo json_encode($response, JSON_UNESCAPED_UNICODE);
        }
    }

?>