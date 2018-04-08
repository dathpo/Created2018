function Controller(){

    var socket = io.connect();
    var ouptut = document.getElementById("output");
    var image = document.getElementById("image");
    var img = document.createElement("img");
    img.src = "/static/Magnitude.png";
    image.appendChild(img);
    socket.on('message', function(data){
        output.innerHTML = data;
    });
    socket.emit('connect', 'connecting');
}

var controller = new Controller();