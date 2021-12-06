

const API_BASE_URL = "http://localhost:8080"

async function postUser(username, password) {
    const object = { username: username, password: password};
    const requestOptions = {
        method: 'POST',
        body: JSON.stringify(object)
    }
    await fetch(API_BASE_URL + "/users", requestOptions);
}

document.getElementById("clickMe").onclick = doFunction;


