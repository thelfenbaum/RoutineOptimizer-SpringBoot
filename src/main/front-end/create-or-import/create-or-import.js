const API_BASE_URL = "http://localhost:8080/"

async function getWeekSer(userid) {
    return fetch(API_BASE_URL + "weeks/" + userid)
        .then(response => response.json())
        .catch(error => console.log(error));
}

async function getTaskSers(id) {
    return fetch(API_BASE_URL + "tasks/" + id)
        .then(response => response.json())
        .catch(error => console.log(error));
}

async function importWeek() {
    const userid = localStorage.getItem("userid");
    localStorage.setItem("weekSer", await getWeekSer(userid));
    localStorage.setItem("taskSers", await getTaskSers(userid));
    location.href = "../timetable/timetable-empty.html";
}

function createWeek() {
    location.href = "start-when.html";
}

