API_BASE_URL = "http://localhost:8080/"

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

