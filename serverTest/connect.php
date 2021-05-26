<?php
    $host = "localhost";
    $username = "root";
    $password = "";
    $database = "androidapp";

    $conn = mysqli_connect($host, $username, $password, $database);
    mysqli_query($conn, "SET NAMES 'utf8'");
    if ($conn) {
        echo "Thanh cong";
    } else {
        echo "That bai";
    }
?>