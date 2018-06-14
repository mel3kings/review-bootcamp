var express = require('express');
var app = express();
var port = process.env.PORT || 3000;

app.set('view engine', 'ejs');

app.get('/', function(req, res, next){
   console.log("interceptor");
   next();
});

app.get("/", function(req, res){
    res.render('index', {ID: '1234'});

});
app.listen(port);