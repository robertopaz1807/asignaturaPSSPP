<?php 
 
 //adding dboperation file 
 require_once '../includes/DbOperation.php';
 
 //response array 
 $response = array(); 
 
 //if a get parameter named op is set we will consider it as an api call 
 if(isset($_GET['op'])){
 
     //switching the get op value 
     switch($_GET['op']){
     
         //if it is add artist 
         //that means we will add an artist 
         case 'addartist':
             if(isset($_POST['name']) && isset($_POST['expertise'])){
                 $db = new DbOperation(); 
                 if($db->createArtist($_POST['name'], $_POST['expertise'])){
                     $response['error'] = false;
                     $response['message'] = 'Artista añadido satisfactoriamente.';
                     }else{
                         $response['error'] = true;
                         $response['message'] = 'No se ha podido añadir el artista.';
                     }
                 }else{
                     $response['error'] = true; 
                     $response['message'] = 'Faltan parametros obligatorios';
             }
             break; 
         
         //if it is getartist that means we are fetching the records
         case 'getartists':
             $db = new DbOperation();
             $artists = $db->getArtists();
             if(count($artists)<=0){
                 $response['error'] = true; 
                 $response['message'] = 'Artista no encontrado.';
             }else{
                 $response['error'] = false; 
                 $response['artists'] = $artists;
             }
             break; 
         
         default:
             $response['error'] = true;
             $response['message'] = 'Operacion no permitida';
     }
  }else{
     $response['error'] = false; 
     $response['message'] = 'Peticion invalida';
 }
 
 //displaying the data in json 
 echo json_encode($response);