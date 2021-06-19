<?php
 
    $response = array();
    
    require_once __DIR__ . '/db_connect.php';
    
    $db = new db_connect();

    $idProduct = $_POST['idProduct'];
    $quantity = $_POST['quantity'];
    
    $result = mysqli_query($db->connect(),"UPDATE cart_detail SET quantity = '$quantity' WHERE idProduct = '$idProduct'") or die(mysqli_error());
    
    $response = array();

    echo json_encode($response, JSON_UNESCAPED_UNICODE);
?>