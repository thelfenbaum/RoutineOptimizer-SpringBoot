const API_BASE_URL = "http://localhost:8080/tasks/"

let triedName = document.getElementById("name").value;
let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

let raw = JSON.stringify({
    "name": triedName,
    "start_date_time": document.getElementById("start_date_time").value,
    "duration": document.getElementById("duration").value,
    "user_id": document.getElementById("user_id").value
});

let requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
};

async function createNonFixedTask(){
    return fetch("http://localhost:8080/tasks/instantiate/{name}/{dueDateTime}/{duration}/{userId}", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error))
}

async function getWeekSer(userid) {
    return fetch(API_BASE_URL + "weeks/" + userid)
        .then(response => response.json())
}

async function getTaskSers(userid) {
    return fetch(API_BASE_URL + "tasks/" + userid)
        .then(response => response.json())
}

async function importWeek() {
    window.weekSer = getWeekSer(window.userid);
    window.taskSers = getTaskSers(window.userid);
    location.href = "../timetable/timetable.html";}
