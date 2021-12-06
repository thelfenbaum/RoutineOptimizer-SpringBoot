const API_BASE_URL = "http://localhost:8080"

// return a list containing JSON objects denoting all the users in the database
async function getAllUsers(){
    const response = await fetch(API_BASE_URL + "/users");
    const users = await response.json();
    return JSON.parse(users);
}


function checkInput(username, password, users){
    // loop through users[i] and check if users[i].username matches username.
    // If yes, check if users[i].password matches. If yes return true, otherwise return false.
}




