const API_BASE_URL = "http://localhost:8080"

// return a list containing JSON objects denoting all the users in the database
async function getUser(username){
    fetch(API_BASE_URL + '/users/' + username)
           .then(response => response.json())
           .then(data => { return JSON.parse(data)};
}

// async function printUsers(){
//     fetch(API_BASE_URL + '/users')
//         .then(response => response.json())
//         .then(data => {return data});
// }


//
// function checkInput(username, password, users){
//     // loop through users[i] and check if users[i].username matches username.
//     // If yes, check if users[i].password matches. If yes return true, otherwise return false.
//     for(let i = 0; i < users.length; i++){
//         if (users[i].username === username){
//             return users[i].password === password;
//
//         }
//     }
//     return false;
// }

function validate(){
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    if(getUser(username).password == password){
        window.location.href="timetable.html";
    } else {
        alert("Username or password are incorrect. Please try again.");
    }
}

