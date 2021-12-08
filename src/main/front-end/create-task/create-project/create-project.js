const API_BASE_URL = "http://localhost:8080/project/"

// let triedProjectName = document.getElementById("project_name").value;
// let myHeaders = new Headers();
// myHeaders.append("Content-Type", "application/json");
//
// let raw = JSON.stringify({
//     "project_name": triedProjectName,
//     "start_date_time": document.getElementById("start_date_time").value,
//     "duration": document.getElementById("duration").value,
//     "is_complete": document.getElementById("is_complete").value,
//     "user_id": document.getElementById("user_id").value
// });
//
// let requestOptions = {
//     method: 'POST',
//     headers: myHeaders,
//     body: raw,
//     redirect: 'follow'
// };

async function calculateHours(userid, totalHours, startDateTime, dueDateTime){
    let url = API_BASE_URL + userid + "/" + totalHours + "/" + startDateTime + "/" + dueDateTime;
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.log(error));
}

async function activateCalculateHours() {
    let userid = localStorage.getItem("userid");
    let totalHours = document.getElementById("totalHours").value;
    let startDateTime = document.getElementById("startDateTime").value;
    let dueDateTime = document.getElementById("dueDateTime").value;
    let hoursObj = calculateHours(userid, totalHours, startDateTime, dueDateTime);
    let minHours = hoursObj.minHours;
    let maxHours = hoursObj.maxHours;
    alert("You must work on this project at least " + minHours + " hours a day and at most " + maxHours + " hours a day.")
}

