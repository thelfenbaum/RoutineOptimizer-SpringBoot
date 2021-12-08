API_BASE_URL = "http://localhost:8080/"

let triedUserId = document.getElementById("user_id").value;

let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

let raw = JSON.stringify({
    "user_id": triedUserId,
    "start_date": document.getElementById("start_date").value

});

let requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
};

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
    location.href = "../timetable/timetable.html";
}

