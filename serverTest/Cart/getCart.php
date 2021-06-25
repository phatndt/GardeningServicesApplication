<?php

    $response = array();
    
    require_once __DIR__ . '/db_connect.php';
    
    $db = new db_connect();

    $idUser = $_POST['idUser'];
    
    $result = mysqli_query($db->connect(),"SELECT * FROM cart WHERE idUser = '$idUser' AND state = '0'") or die(mysqli_error());
    
    if (mysqli_num_rows($result) > 0) {

        $response = array();
    
        while ($row = mysqli_fetch_array($result)) {

            $product = array();

            $product["id"] = $row["id"];
            $product["idUser"] = $row["idUser"];
            $product["total"] = $row["total"];
            $product["state"]=$row["state"];
            
            array_push($response, $product);

        }

        echo json_encode($response[0]);

    } else {

        echo json_encode($response);
    }
?>