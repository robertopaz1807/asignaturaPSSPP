const express = require('express');
const request = require('request');

const myApp = express();

console.log("Arrancando")

myApp.get('/validate', function(req, resp) {
   
    const postData = {
        secret: '6LfY_04jAAAAAM0-UGF4w1BD908rotSlsAXZBkwf',
        response: req.query.user_token
    };

    console.log("pase por aqui")

    request.post({
        url: 'https://www.google.com/recaptcha/api/siteverify',
        form: postData
        }, function(error, response, body) {
            jsonData = JSON.parse(body); // Parse the JSON document
             
            if(jsonData.success) { // User passed the test
                resp.send('PASS');
            } else { // User didn't pass the test
                resp.send('FAIL');
            }
         
    });


});


myApp.listen(8000);
