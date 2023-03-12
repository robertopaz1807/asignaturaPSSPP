<?php
 
class DbOperation
{
    private $con;
 
    function __construct()
    {
        require_once dirname(__FILE__) . '/DbConnect.php';
        $db = new DbConnect();
        $this->con = $db->connect();
    }
 
 //adding a record to database 
 public function createArtist($name, $expertise){
     $stmt = $this->con->prepare("INSERT INTO artists (name, expertise) VALUES (?, ?)");
     $stmt->bind_param("ss", $name, $expertise);
     if($stmt->execute())
         return true; 
     return false; 
 }
 
 //fetching all records from the database 
 public function getArtists(){
     $stmt = $this->con->prepare("SELECT id, name, expertise FROM artists");
     $stmt->execute();
     $stmt->bind_result($id, $name, $expertise);
     $artists = array();
     
     while($stmt->fetch()){
         $temp = array(); 
         $temp['id'] = $id; 
         $temp['name'] = $name; 
         $temp['expertise'] = $expertise; 
         array_push($artists, $temp);
     }
     return $artists; 
 }
}