const API_BASE_URL = "http://localhost:8080"

// return a list containing JSON objects denoting all the users in the database
async function getAllUsers(){
    const response = await fetch(API_BASE_URL + "/users");
    const users = await response.json();
    return JSON.parse(users);
}


