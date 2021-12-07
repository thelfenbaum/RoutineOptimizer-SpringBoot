const API_BASE_URL = "http://localhost:8080/users"

let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

let raw = JSON.stringify({
    "username": document.getElementById("username").value,
    "password": document.getElementById("password").value
});

let requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
};

async function signUp(){
    fetch("http://localhost:8080/users", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}



