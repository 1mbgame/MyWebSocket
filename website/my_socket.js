console.log("Web Socket");

// Create WebSocket connection.
const socket = new WebSocket('ws:127.0.0.1:8181/api/websocket-end-point');
socket.onopen= (event)=> {
    console.log("Socket open");
    socket.send("My Name is Andy");
    socket.send("asds","mess");
};



// Connection opened
socket.addEventListener("/api/web-socket/user-auth-status", (event) => {
    console.log("Message from server(user-auth-status) ", event.data);
    socket.send("Hello Server!");
});

// Listen for messages
socket.addEventListener("message", (event) => {
    console.log("Message from server ", event.data);
});

function createWebSocket() {
    
}
