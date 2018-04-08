var express = require('express');
var path = require('path');
var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
app.use('/static', express.static(__dirname + '/static'));
app.get('/image', function(request, response) {
  response.sendFile(path.join(__dirname, '/static/temp-plot.html'));
});
app.get('/data', function(request, response) {
  response.sendFile(path.join(__dirname, '/index.html'));
});
app.post("/", function (request, response) {
  
})
io.on('connection', s => {
  console.error('socket.io connection');
  setInterval(() => s.emit('message', 'new data'), 1000);
});
http.listen(3000, () => console.error('listening on http://localhost:3000/'));
console.error('socket.io example');