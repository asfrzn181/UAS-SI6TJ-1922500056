<?php

$con = new mysqli("localhost","root","","campuss");

if($con -> connect_errno){
	echo "Failed to connect to MySQL : ". $con -> connect_errno;
	exit();
}



$query = "SELECT * from lecturer";
$result = $con->query($query);

$data_dosen = $result->fetch_all(MYSQLI_ASSOC);

echo json_encode($data_dosen);

?>