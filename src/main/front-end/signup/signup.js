function signUp(username, password) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/users", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        "username": username,
        "password": password
    }));
}

// takes username and returns userId. Returns undefined if username not in database.
async function getUserid(username) {
    return fetch("http://localhost:8080/users/" + username)
        .then(response => response.json())
        .then(user => user.id)
        .catch(reject => console.log(reject));
}

// if userId undefined, allow to create an account with username. Otherwise, alert
async function createAccount(){
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const userid = await getUserid(username);


    if (userid !== undefined) {
        alert("Username is already in use. Please enter a different username.");
    } else {
        await signUp(username, password);
        const userid = await getUserid(username);
        localStorage.setItem("userid", userid);
        location.href = "../start-when/start-when.html";
    }
}






