var stompClient = null;

connect();
console.log("Version:1.0.3");


function connect() {
    let opts = {
        'headers' : 
            { 'Authorization' : 'Andy Token' }
        
    };
    for (var key in opts.headers) {
        console.log('=====================>>>>');
        console.log('key,value=(' + key + ',' + opts.headers[key] +')');
      }

    let header = {
        'Authorization' : '9743819yeahruqwgrjbsmacbamzsbca9743819yeahruqwgrjbsmacbamzsbca9743819yeahruqwgrjbsmacbamzsbca9743819yeahruqwgrjbsmacbamzsbca9743819yeahruqwgrjbsmacbamzsbca'
    }
    var socket = new SockJS('http://127.0.0.1:8181/api/websocket-end-point',{},opts);
    console.log(socket);
    stompClient = Stomp.over(socket);
    console.log(stompClient);
    stompClient.connect(opts,function (frame) {
        console.log('Connected: ' + frame);
        let username = "D" + (new Date()).getMilliseconds();
        console.log("username: " + username);
        stompClient.subscribe('/user/' + username + '/msg', function (greeting) {
            console.log('=========================>');
           console.log("Message from server : " + greeting);
        });
        onUserConnected(username);
        
    });
}

function onUserConnected(username) {
    stompClient.send('/api/web-socket/user-connected', {},username);
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}




