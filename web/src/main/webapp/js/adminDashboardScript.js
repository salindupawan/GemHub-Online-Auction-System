let socket = new WebSocket("ws://localhost:8080/gemhub/addNewBid");

socket.onmessage = event => {
    console.log(JSON.parse(event.data));
    let data = JSON.parse(event.data);
    document.getElementById("highestBid-"+data.id).innerHTML = `${data.currentPrice} $`;
    document.getElementById("auctionCount-"+data.id).innerHTML = `${data.auctionCount}`;
    document.getElementById("bidOwner-"+data.id).innerHTML = `${data.bidOwner}`;

};

socket.onopen = () => {
    console.log("connected")
};
socket.onclose = ()=>{
    console.log("closed")
}
socket.onerror = (e)=>{
    console.log(e)
}

// console.log("admin dashboard")