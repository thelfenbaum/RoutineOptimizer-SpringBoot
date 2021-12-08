const API_BASE_URL = "http://localhost:8080/weeks"

let triedUserId = document.getElementById("user_id").value;

let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

let raw = JSON.stringify({
    "user_id": triedUserId,
    "start_date": document.getElementById("start_date").value

});

let requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
};



