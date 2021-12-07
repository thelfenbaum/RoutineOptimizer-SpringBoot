API_BASE_URL = "http://localhost:8080/users/"

async function getPassword(username) {
    return fetch(API_BASE_URL + username)
        .then(response => response.json())
        .then(user => user.password)
        .catch(reject => console.log(reject));
}

async function getUserid(username) {
    return fetch(API_BASE_URL + username)
        .then(response => response.json())
        .then(user => user.id)
        .catch(reject => console.log(reject));
}

async function validate() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const expPassword = await getPassword(username);
    const userid = await getUserid(username);

    if(expPassword === undefined){
        alert("Username not found. Please try again.");
    } else if (expPassword !== password) {
        alert("Password is incorrect. Please try again.");
    } else {
        window.userid = userid;
        location.href = "../timetable/timetable.html";
    }
}