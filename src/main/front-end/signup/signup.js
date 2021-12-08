var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

async function signUp() {
    fetch("http://localhost:8080/users", {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify({
            "username": document.getElementById("username").value,
            "password": document.getElementById("password").value
        }),
        redirect: 'follow'
    })
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}


// takes username and returns userId. Returns undefined if username not in database.
async function getUserId(username){
     return fetch(API_BASE_URL + "/" + username)
            .then(response => response.json())
            .then(user => user.id)
            .catch(reject => console.log(reject));
}

// if userId undefined, allow to create an account with username. Otherwise, alert
async function createAccount(){
    const userId = await getUserId(document.getElementById("username").value);
    if (userId === undefined) {
        await signUp();
        // window.userId = getUserId(document.getElementById("username").value);
        location.href = "../timetable/timetable.html";
    } else {
        alert("Username is already in use. Please enter a different username.");
    }
}






