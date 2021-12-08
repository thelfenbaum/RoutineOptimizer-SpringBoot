const API_BASE_URL = "http://localhost:8080/users/"

let triedUsername = document.getElementById("username").value;
let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

let raw = JSON.stringify({
    "username": triedUsername,
    "password": document.getElementById("password").value
});

let requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
};



async function signUp() {
    fetch(API_BASE_URL, requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}


// takes username and returns userId. Returns undefined if username not in database.
async function getUserId(username){
     return fetch(API_BASE_URL + username)
            .then(response => response.json())
            .then(user => user.id)
            // reject is a good thing here. this is when we want to let them use the username
            .catch(reject => console.log(reject));
}

// if userId undefined, allow to create an account with username. Otherwise, alert
async function createAccount(){
    const userId = getUserId(triedUsername);
    if (userId === undefined) {
        signUp();
        location.href = "../timetable/timetable.html"
    } else {
        alert("Username is already in use. Please enter a different username.")
    }
}






