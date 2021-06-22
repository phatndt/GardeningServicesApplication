<?php
    $response = array();
    
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    
    $db = new db_connect();

    $userId = $_POST['idUser'];

    $sql= "SELECT name,date,gender,telephone,email FROM users WHERE id='$userId'"; 

    $control = mysqli_query($db->connect(),$sql) or die(mysqli_error());
    if (mysqli_num_rows($control) >0) {
        $response = array();
            while ( $row = mysqli_fetch_array($control)) 
            {
            $user = array();
            $user["id"] = $row["id"];
            $user["username"] = $row["username"];
            $user["password"] = $row["password"];
            $user["name"] = $row["name"];
            $user["date"] = $row["date"];
            $user["gender"] = $row["gender"];
            $user["telephone"] = $row["telephone"];
            $user["email"] = $row["email"];
            array_push($response, $user);
            }
        echo json_encode($response);
    }
    else {
        echo json_encode($response);
    }
?>