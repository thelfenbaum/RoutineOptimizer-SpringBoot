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
    let url = API_BASE_URL + "calculatehours/" + userid + "/" + totalHours + "/" + startDateTime + "/" + dueDateTime;
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.log(error));
}

async function activateCalculateHours() {
    const userid = localStorage.getItem("userid");
    const totalHours = document.getElementById("totalHours").value;
    const startDateTime = document.getElementById("startDateTime").value;
    const dueDateTime = document.getElementById("dueDateTime").value;
    let hoursObj = calculateHours(userid, totalHours, startDateTime, dueDateTime);
    let minHours = hoursObj.minHours;
    let maxHours = hoursObj.maxHours;
    alert("You must work on this project at least " + minHours + " hours a day and at most " + maxHours + " hours a day.")
}

async function createProject(name, userid, startDateTime, dueDateTime, hoursPerDay){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", API_BASE_URL + "create-project", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        "name": name,
        "maxHoursPerTask": hoursPerDay,
        "userid": userid,
        "dueDateTime":dueDateTime,
        "startDateTime": startDateTime
    }));
}

async function getTaskSers(userid) {
    return fetch(API_BASE_URL + userid)
        .then(response => response.json())
}


async function goToUpdatedWeek(userid) {
    localStorage.setItem("taskSers", JSON.stringify(await getTaskSers(userid)));
    location.href = "../../timetable/timetable-empty.html";
}

async function submitInfo(){
    const userid = localStorage.getItem("userid");
    const name = localStorage.getItem("name");
    const startDateTime = document.getElementById("startDateTime").value;
    const dueDateTime = document.getElementById("dueDateTime").value;
    const hoursPerDay = document.getElementById("hoursNum").value;
    await createProject(name, userid, startDateTime, dueDateTime, hoursPerDay);
    await goToUpdatedWeek(userid);
}

