const BROADCAST = 11;
const NOTIFICATION = 12;
const SUCCESS_MESSAGE = 9;
const ERROR_MESSAGE = 10;

let socket = new WebSocket("ws://localhost:8080/gemhub/addNewBid");
socket.onmessage = event => {

    let data = JSON.parse(event.data);

    if (data.code === BROADCAST) {
        document.getElementById("current_price_" + data.id).innerHTML = `${data.currentPrice} $`;

    } else if (data.code === NOTIFICATION) {
        document.getElementById("messageBox").innerHTML = `${data.message}`;
        document.getElementById("messageWrapper").classList.remove("hide");

        if (data.type === SUCCESS_MESSAGE) {
            document.getElementById("messageWrapper").classList.add("success");
            document.getElementById("messageBox").classList.add("success__title");

        } else if (data.type === ERROR_MESSAGE) {
            document.getElementById("messageWrapper").classList.add("error");
            document.getElementById("messageBox").classList.add("error__title");

        }

        setTimeout(() => {
            document.getElementById("messageWrapper").classList = "hide";
            document.getElementById("messageBox").classList = "";

        }, 3000)

    }
};

socket.onopen = () => {
    console.log("connected")
    socket.send(JSON.stringify({email: getEmailFromCookie()}))
};
socket.onclose = () => {
    console.log("closed")
}
socket.onerror = (e) => {
    console.log(e)
}


async function placeBid(id) {
    let value = document.getElementById("bid_input_" + id).value;
    const data = {
        id: id,
        amount: value
    }
    const response = await fetch(
        "./placeBid",
        {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "content-type": "application/json"
            }
        });

    if (response.ok) {
        document.getElementById("bid_input_" + id).value = null;
    }


}

function getEmailFromCookie() {
    let email = document.cookie
        .split('; ')
        .find(row => row.startsWith('email='))
        ?.split('=')[1];

    return email

}

